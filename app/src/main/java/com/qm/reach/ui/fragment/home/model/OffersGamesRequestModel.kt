package com.qm.reach.ui.fragment.home.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class OffersGamesRequestModel(
    @SerializedName("data")
    val `data`: Data?
) : Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("offers")
        val offers: Offers?
    ) : Parcelable {


        @Parcelize
        data class Offers(
            @SerializedName("data")
            val `data`: List<Data?>?
        ) : Parcelable {
            @Parcelize
            data class Data(
                @SerializedName("banner_image")
                val bannerImage: String?,
                @SerializedName("categories")
                val categories: List<Category?>?,
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
                val user: User?
            ) : Parcelable {
                @Parcelize
                data class Category(
                    @SerializedName("id")
                    val id: Int?,
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("slug")
                    val slug: String?
                ) : Parcelable

                @Parcelize
                data class User(
                    @SerializedName("background_image")
                    val backgroundImage: Any?,
                    @SerializedName("cover_photo")
                    val coverPhoto: Any?,
                    @SerializedName("id")
                    val id: Int?,
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("object")
                    val objectX: String?,
                    @SerializedName("phone_background")
                    val phoneBackground: Any?,
                    @SerializedName("profile_picture")
                    val profilePicture: String?,
                    @SerializedName("username")
                    val username: String?
                ) : Parcelable
            }
        }
    }
}