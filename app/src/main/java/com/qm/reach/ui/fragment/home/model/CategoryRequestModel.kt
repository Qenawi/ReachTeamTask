package com.qm.reach.ui.fragment.home.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryRequestModel(
    @SerializedName("data")
    val data: List<CategoryDataList?>?,
) : Parcelable

    @Parcelize
    data class CategoryDataList(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("slug")
        val slug: String?,
        @SerializedName("users")
        val users: Users?
    ) : Parcelable

        @Parcelize
        data class Users(
            @SerializedName("data")
            val data: List<Data>?
        ) : Parcelable

            @Parcelize
            data class Data(
                @SerializedName("background_image")
                val backgroundImage: String?,
                @SerializedName("bio")
                val bio: String?,
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