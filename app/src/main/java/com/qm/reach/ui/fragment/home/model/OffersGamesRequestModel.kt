package com.qm.reach.ui.fragment.home.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class OffersGamesRequestModel(
  @PrimaryKey(autoGenerate = false)
  var id: Int? = 0,
  @SerializedName("data")
  val offerList: OfferList?
) : Parcelable

@Parcelize
data class OfferList(
  @SerializedName("offers")
  val offers: Offers?
) : Parcelable

@Parcelize
data class Offers(
  @SerializedName("data")
  val data: List<OfferData?>?
) : Parcelable

@Parcelize
data class OfferData(
  @SerializedName("banner_image")
  val bannerImage: String?,
  @SerializedName("categories")
  val categories: List<OfferCategory?>?,
  @SerializedName("cover_image")
  val coverImage: String?,
  @SerializedName("cta")
  val cta: String?,
  @SerializedName("cta_background_color")
  val ctaBackgroundColor: String?,
  @SerializedName("cta_text_color")
  val ctaTextColor: String?,
  @SerializedName("cta_url")
  val ctaUrl: String?,
  @SerializedName("due_date")
  val dueDate: String?,
  @SerializedName("id")
  val id: Int?,
  @SerializedName("title")
  val title: String?,
  @SerializedName("user")
  val user: OfferUser?
) : Parcelable

@Parcelize
data class OfferCategory(
  @SerializedName("id")
  val id: Int?,
  @SerializedName("name")
  val name: String?,
  @SerializedName("slug")
  val slug: String?
) : Parcelable

@Parcelize
data class OfferUser(
  @SerializedName("background_image")
  val backgroundImage: String?,
  @SerializedName("cover_photo")
  val coverPhoto: String?,
  @SerializedName("id")
  val id: Int?,
  @SerializedName("name")
  val name: String?,
  @SerializedName("object")
  val objectX: String?,
  @SerializedName("phone_background")
  val phoneBackground: String?,
  @SerializedName("profile_picture")
  val profilePicture: String?,
  @SerializedName("username")
  val username: String?
) : Parcelable

