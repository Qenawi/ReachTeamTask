package com.qm.reach.di.dataBase

import androidx.room.TypeConverter
import com.qm.reach.ui.fragment.home.model.CategoryDataList
import com.qm.reach.ui.fragment.home.model.OfferList
import com.qm.reach.util.MapUtils.mAnyToJsonElement
import com.qm.reach.util.MapUtils.mMapToArrayListFix
import com.qm.reach.util.MapUtils.mMapToObject
import com.qm.reach.util.MapUtils.mStringToJsonElement

class Converters {
  // MARK:- CategoryDataList
  @TypeConverter
  fun fromCategoryDataList(value: List<CategoryDataList?>): String? {
    return value?.let {
      value.mAnyToJsonElement().toString()
      // @-> = ->
    }
  }

  @TypeConverter
  fun stringToCategoryDataList(date: String?): List<CategoryDataList?>? {
    return date?.mStringToJsonElement()?.asJsonArray?.mMapToArrayListFix<CategoryDataList>()
  }

  @TypeConverter
  fun fromOfferList(value: OfferList?): String? {
    return value?.let {
      value.mAnyToJsonElement().toString()
      // @-> = ->
    }
  }

  @TypeConverter
  fun stringToOfferList(date: String?):OfferList? {
    return date?.mStringToJsonElement()?.mMapToObject()
  }
}
