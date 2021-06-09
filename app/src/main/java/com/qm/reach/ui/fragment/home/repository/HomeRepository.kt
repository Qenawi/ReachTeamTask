package com.qm.reach.ui.fragment.home.repository

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import com.qm.reach.base.network.HandleResponseData
import com.qm.reach.base.network.IsRepo
import com.qm.reach.data.remote.ApiService
import com.qm.reach.ui.fragment.home.HomeResponse
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: ApiService) : IsRepo
{

    fun getUser(page: Int): @NonNull Flowable<HandleResponseData<HomeResponse>>
    {
        return apiService.getChars(page)
            .subscribeOn(Schedulers.io())
            .onErrorReturn {
                HomeResponse(code = 401, message = it.localizedMessage)
            }
            .map {
                if (it.code == 200)
                    return@map HandleResponseData.success(it)
                else
                    return@map HandleResponseData.error(it.message)
            }

    }

    fun getUsers(page: Int): MediatorLiveData<HandleResponseData<HomeResponse>> {
        val userLiveData = MediatorLiveData<HandleResponseData<HomeResponse>>()
        val source = LiveDataReactiveStreams.fromPublisher(
            apiService.getChars(page)
                .subscribeOn(Schedulers.io())
                .onErrorReturn {
                    HomeResponse(code = 401, message = it.localizedMessage)
                }
                .map {
                    if (it.code == 200)
                        return@map HandleResponseData.success(it)
                    else
                        return@map HandleResponseData.error(it.message)
                }
        )
        userLiveData.addSource(source) {
            userLiveData.value = it
            userLiveData.removeSource(source)
        }
        return userLiveData
    }
}