package com.qm.reach.ui.fragment.home.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.qm.reach.base.network.HandleResponseData
import com.qm.reach.base.viewmodel.AndroidBaseViewModel
import com.qm.reach.ui.fragment.home.HomeItem
import com.qm.reach.ui.fragment.home.repository.HomeRepository
import com.qm.reach.ui.fragment.home.HomeResponse
import com.qm.reach.ui.fragment.home.view.HomeAdapter
import java.util.Observable
import javax.inject.Inject

//MARK:- HomeViewModel@Docs
class HomeViewModel @Inject constructor(
  app: Application,
  private val homeRepository: HomeRepository
) : AndroidBaseViewModel(app) {

  //MARK:- search text
  val searchText = ObservableField("")
  val categoryAdapter = HomeAdapter(::onItemClick)
  val Adapter = HomeAdapter(::onItemClick)

  private fun onItemClick(homeItem: HomeItem) {
    setValue(homeItem)
  }
}