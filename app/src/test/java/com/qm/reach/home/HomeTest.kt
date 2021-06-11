package com.qm.reach.home

import com.qm.reach.data.remote.ApiService
import com.qm.reach.mock_server.MockServer
import com.qm.reach.ui.fragment.home.model.CategoryRequestModel
import com.qm.reach.ui.fragment.home.model.OffersGamesRequestModel
import com.qm.reach.util.MapUtils.mMapToObject
import com.qm.reach.util.MapUtils.mStringToJsonElement
import io.reactivex.rxjava3.core.Flowable
import org.junit.Assert
import org.junit.Before
import org.junit.Test

//MARK:- Api Service Mock
class MocAPiService : ApiService {
  override fun getTimeLine(): Flowable<OffersGamesRequestModel> {
    val js = MockServer.sucessOffersJson
    val res = js.mStringToJsonElement().asJsonObject.mMapToObject<OffersGamesRequestModel>()
    return Flowable.just(res)
  }

  override fun getCategory(): Flowable<CategoryRequestModel> {
    val js = MockServer.sucessCategoryJson
    val res = js.mStringToJsonElement().asJsonObject.mMapToObject<CategoryRequestModel>()
    return Flowable.just(res)
  }
}

//MARK:- todo add Mockito (Application / viewModel)
class HomeTest {
  private lateinit var repo: ApiService

  @Before
  fun setup() {
    repo = MocAPiService()
  }

  @Test
  fun mainTestFunction() {
    Assert.assertEquals(4, 4)
  }

  @Test
  fun parseOffers() {
    var result: OffersGamesRequestModel? = null
    repo.getTimeLine().subscribe { result = it }
    Assert.assertNotNull(result)
  }

  @Test
  fun parseCategories() {
    var result: CategoryRequestModel? = null
    repo.getCategory().subscribe { result = it }
    Assert.assertNotNull(result)
  }
}