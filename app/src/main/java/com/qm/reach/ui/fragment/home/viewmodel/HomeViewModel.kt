package com.qm.reach.ui.fragment.home.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import com.qm.reach.R
import com.qm.reach.base.network.Status.SUCCESS
import com.qm.reach.base.viewmodel.AndroidBaseViewModel
import com.qm.reach.ui.fragment.home.model.CategoryUIItem
import com.qm.reach.ui.fragment.home.model.OfferUIItem
import com.qm.reach.ui.fragment.home.protocols.HomeViewProtocol
import com.qm.reach.ui.fragment.home.repository.HomeRepository
import com.qm.reach.ui.fragment.home.view.BottomBarNavigation
import com.qm.reach.ui.fragment.home.view.BottomBarNavigation.Other
import com.qm.reach.ui.fragment.home.view.MainCategoryAdapter
import com.qm.reach.ui.fragment.home.view.OffersAdapter
import javax.inject.Inject

//MARK:- HomeViewModel @Docs
class HomeViewModel @Inject constructor(
  app: Application,
  private val homeRepository: HomeRepository
) : AndroidBaseViewModel(app) {
  init {
    //load categories
    loadCats()
    //load offers
    loadOffers()
  }

  var view: HomeViewProtocol? = null

  //MARK:- search text
  val searchText = ObservableField("")

  //MARK:- offer adapter
  val offerAdapter = OffersAdapter { item ->
    view?.handleOfferOnclick(item.urlClick ?: "")

  }

  //MARK:- category adapter
  val catAdapter = MainCategoryAdapter()

  //MARK:- offerAdapter data src
  val offerAdapterDataSrc = ArrayList<OfferUIItem>()

  //MARK:- category adapter data src
  val categoryAdapterDataSrc = ArrayList<CategoryUIItem>()

  //MARK:- bottomBar Selection
  val bottomBarSelection = ObservableField<BottomBarNavigation>(BottomBarNavigation.Search)

  private fun loadCats() {
    isLoading.set(true)
    homeRepository.getCategories { a ->
      isLoading.set(false)
      if (a.status == SUCCESS) onCategoryReady(a.data)
      else setError(a.message ?: app.getString(R.string.network_error))
    }
  }

  private fun loadOffers() {
    isLoading.set(true)
    homeRepository.getOffers { a ->
      isLoading.set(false)
      if (a.status == SUCCESS) onOfferReady(a.data)
      else setError(a.message ?: app.getString(R.string.network_error))

    }
  }

  override fun onCleared() {
    super.onCleared()
    homeRepository.onClear()
  }

  //MARK:- filter Search Result
  fun filter() {
    catAdapter.filter.filter(searchText.get())
  }

  //MARK:- Bottom View Actions
  fun other() {
    bottomBarSelection.set(Other)
  }

  fun profile() {
    bottomBarSelection.set(BottomBarNavigation.Profile)
  }

  fun discover() {
    bottomBarSelection.set(BottomBarNavigation.Search)
  }
}



