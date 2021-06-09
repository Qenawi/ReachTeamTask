package com.qm.reach.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorResponse(

//	@field:SerializedName("code")
	val code: Int? = null,

//	@field:SerializedName("message")
	val message: String? = null,

//	@field:SerializedName("validation")
	val validation: List<String?>? = null,
) : Parcelable
