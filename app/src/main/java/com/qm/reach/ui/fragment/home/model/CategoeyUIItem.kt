package com.qm.reach.ui.fragment.home.model

import android.os.Parcelable
import com.qm.reach.base.view.BaseParcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryUIItem(
  val id: Int,
  val mainTitle: String,
  val arrayList: ArrayList<SupCategoriesUIItem>
) : Parcelable, BaseParcelable {
  override fun unique(): Any {
    return id
  }
}