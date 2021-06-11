package com.qm.reach.ui.fragment.home.model

import android.os.Parcelable
import com.qm.reach.base.view.BaseParcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class OfferUIItem(
  val id: Int,
  val text: String?,
  val fontColor: String?,
  val coverColor: String?,
  val image: String?,
  val urlClick:String?
) : Parcelable, BaseParcelable {
  override fun unique(): Any {
    return id
  }
}