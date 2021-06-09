package com.qm.reach.data.remote

import com.qm.reach.ui.fragment.home.HomeResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Qenawi on 6/24/2020.
 **/

interface ApiService {

  @GET("character")
  fun getChars(@Query("page") page: Int): Flowable<HomeResponse>
}