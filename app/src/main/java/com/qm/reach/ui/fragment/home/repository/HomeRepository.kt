package com.qm.reach.ui.fragment.home.repository

import com.qm.reach.base.network.HandleResponseData
import com.qm.reach.base.network.HandleResponseData.Companion
import com.qm.reach.base.network.IsRepo
import com.qm.reach.data.remote.ApiService
import com.qm.reach.di.dataBase.db_model.ReachDataBase
import com.qm.reach.ui.fragment.home.model.CategoryRequestModel
import com.qm.reach.ui.fragment.home.model.OffersGamesRequestModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

//MARK:- Home Repo
class HomeRepository @Inject constructor(
  private val apiService: ApiService,
  private val dataBase: ReachDataBase
) : IsRepo {
  private val fixedRowId = 1
  var jop = CompositeDisposable()
  fun getCategories(call: (HandleResponseData<CategoryRequestModel>) -> Unit = {}) {

    val disposable = apiService.getCategory()
      .subscribeOn(Schedulers.io())
      .observeOn(Schedulers.computation())
      .map { a ->
        dataBase.categoryDao().insert(a.apply { id = fixedRowId })
        dataBase.categoryDao().get().first()
      }
      .doOnError { e ->
        //MARK:- return cached data if any on error case else return live data
        val cachedData = dataBase.categoryDao().get()
        if (cachedData.isNullOrEmpty()) call(Companion.error(e.localizedMessage))
        else call(HandleResponseData.success(cachedData.first()))
      }
      .subscribe { a -> call(HandleResponseData.success(a)) }
    jop.add(disposable)
  }

  fun getOffers(call: (HandleResponseData<OffersGamesRequestModel>) -> Unit = {}) {

    val disposable = apiService.getTimeLine()
      .subscribeOn(Schedulers.io())
      .observeOn(Schedulers.computation())
      .map {
        dataBase.offersDao().insert(it.apply { id = fixedRowId })
        dataBase.offersDao().get().first()
      }
      .doOnError { e ->
        //MARK:- return cached data if any on error case else return live data
        val cachedData = dataBase.offersDao().get()
        if (cachedData.isNullOrEmpty()) call(Companion.error(e.localizedMessage))
        else call(HandleResponseData.success(cachedData.first()))
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
