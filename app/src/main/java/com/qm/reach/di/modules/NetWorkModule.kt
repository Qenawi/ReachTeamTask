package com.qm.reach.di.modules

import androidx.databinding.library.BuildConfig
import com.qm.reach.data.remote.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetWorkModule {
  private val BaseUrl = "AjaxMonku"

  @Singleton
  @Provides
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .apply {
        if (BuildConfig.DEBUG) {
          this.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        readTimeout(120, TimeUnit.SECONDS)
        connectTimeout(120, TimeUnit.SECONDS)
        writeTimeout(120, TimeUnit.SECONDS)
      }
      .build()
  }

  @Singleton
  @Provides
  fun provideApiService(okHttpClient: OkHttpClient): ApiService {
    return Retrofit.Builder()
      .baseUrl(BaseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
      .client(okHttpClient)
      .build()
      .create(ApiService::class.java)
  }
}