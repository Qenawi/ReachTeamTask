package com.qm.reach.data.remote

import com.google.gson.JsonElement
import com.qm.reach.ui.fragment.home.HomeResponse
import com.qm.reach.ui.fragment.home.model.CategoryRequestModel
import com.qm.reach.ui.fragment.home.model.OffersGamesRequestModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Qenawi on 6/24/2020.
 **/

interface ApiService {

  @GET("timeline")
  fun getTimeLine(): Flowable<OffersGamesRequestModel>

  @GET("categories")
  fun getCategory(): Flowable<CategoryRequestModel>
}