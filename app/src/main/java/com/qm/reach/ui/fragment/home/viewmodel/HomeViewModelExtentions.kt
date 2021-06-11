package com.qm.reach.ui.fragment.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.qm.reach.ui.fragment.home.model.CategoryDataList
import com.qm.reach.ui.fragment.home.model.CategoryRequestModel
import com.qm.reach.ui.fragment.home.model.CategoryUIItem
import com.qm.reach.ui.fragment.home.model.OfferData
import com.qm.reach.ui.fragment.home.model.OfferUIItem
import com.qm.reach.ui.fragment.home.model.OffersGamesRequestModel
import com.qm.reach.ui.fragment.home.model.SupCategoriesUIItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//MARK:- handle offerSuccess
fun HomeViewModel.onOfferReady(data: OffersGamesRequestModel?) {
  viewModelScope.launch(Dispatchers.IO)
  {
    val dataHolder = ArrayList<OfferUIItem>()
    data?.offerList?.offers?.data?.map { item ->
      item?.let { itemNonNull -> dataHolder.add(toOfferUIITem(itemNonNull)) }
      offerAdapterDataSrc.clear()
      offerAdapterDataSrc.addAll(dataHolder)
    }
    withContext(Dispatchers.Main) {

      offerAdapter.setList(offerAdapterDataSrc)
    }
  }
}

//MARK:- map OfferData to OfferUIItem
fun toOfferUIITem(item: OfferData): OfferUIItem {
  return OfferUIItem(
    id = item.id ?: 0, text = item.cta, fontColor = item.ctaTextColor,
    coverColor = item.ctaBackgroundColor, image = item.coverImage, urlClick = item.ctaUrl
  )
}

//MARK:- map CategoryDataList to CategoryUIItem list
fun toCategoryUIITem(item: CategoryDataList): CategoryUIItem {
  //MARK:- max items per column
  val maxPerCoulm = 2
  //MARK:- map user to SupCategoriesUIItem @Docs
  var markedArray = item.users?.data?.map { a ->
    SupCategoriesUIItem(
      id = a.id ?: 0, name = a.name ?: "", profilePic = a.profilePicture ?: "",
      cover = a.coverPhoto ?: ""
    )
  }?.toCollection(ArrayList()) ?: arrayListOf()
  //MARK:- add Show All item If category length was more than 2
  if (markedArray.size > maxPerCoulm) {
    markedArray = markedArray.subList(0, maxPerCoulm).toCollection(ArrayList())
    markedArray.add(
      SupCategoriesUIItem(
        id = -1, name = "Show all \n( ${item.users?.data?.size} )", profilePic = "nil", cover = "nil"
      )
    )
  }
  return CategoryUIItem(
    id = item.id ?: 0, mainTitle = item.name ?: "", arrayList = markedArray
  )
}

//MARK:- handle categorySuccess
fun HomeViewModel.onCategoryReady(data: CategoryRequestModel?) {
  viewModelScope.launch(Dispatchers.IO)
  {
    val dataHolder = ArrayList<CategoryUIItem>()
    data?.data?.map { item ->
      item?.let { itemNonNull ->
        dataHolder.add(
          toCategoryUIITem(itemNonNull)
        )
      }
      categoryAdapterDataSrc.clear()
      categoryAdapterDataSrc.addAll(dataHolder)
    }
    withContext(Dispatchers.Main)
    {

      catAdapter.setList(categoryAdapterDataSrc)
    }
  }
}