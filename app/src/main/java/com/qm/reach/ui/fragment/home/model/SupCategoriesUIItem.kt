package com.qm.reach.ui.fragment.home.model

import android.os.Parcelable
import com.qm.reach.base.view.BaseParcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class SupCategoriesUIItem(
  val id: Int,
  val name: String,
  val profilePic: String,
  val cover: String,
) : Parcelable, BaseParcelable {
  override fun unique(): Any {

    return id
  }
}
