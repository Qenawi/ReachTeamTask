package com.qm.reach.ui.fragment.home.repository

import android.app.Application
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import com.qm.reach.base.network.HandleResponseData
import com.qm.reach.base.network.HandleResponseData.Companion
import com.qm.reach.base.network.IsRepo
import com.qm.reach.data.remote.ApiService
import com.qm.reach.ui.fragment.home.HomeResponse
import com.qm.reach.ui.fragment.home.model.CategoryRequestModel
import com.qm.reach.ui.fragment.home.model.OffersGamesRequestModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.operators.completable.CompletableDisposeOn
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

//MARK:- Home Repo
class HomeRepository @Inject constructor(
  private val apiService: ApiService,
  private val app: Application
) : IsRepo {
  var jop = CompositeDisposable()
  fun getCategories(call: (HandleResponseData<CategoryRequestModel>) -> Unit = {}) {

    val disposable = apiService.getCategory()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .doOnError { e ->
        call(Companion.error(e.localizedMessage))
      }
      .subscribe { a ->
        call(HandleResponseData.success(a))
      }
    jop.add(disposable)
  }

  fun getOffers(call: (HandleResponseData<OffersGamesRequestModel>) -> Unit = {}) {

    val disposable = apiService.getTimeLine()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .doOnError { e ->
        call(Companion.error(e.localizedMessage))
      }
      .subscribe { a ->
        call(HandleResponseData.success(a))
      }
    jop.add(disposable)
  }

  //MARK:- lifeCycle Related
  fun onClear() {
    //MARK:- clear with maintaining instance
    jop.clear()
  }
}
