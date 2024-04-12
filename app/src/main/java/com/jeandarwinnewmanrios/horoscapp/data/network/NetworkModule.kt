package com.jeandarwinnewmanrios.horoscapp.data.network

import com.jeandarwinnewmanrios.horoscapp.BuildConfig.BASE_URL
import com.jeandarwinnewmanrios.horoscapp.data.RepositoryImpl
import com.jeandarwinnewmanrios.horoscapp.data.core.interceptors.AuthInterceptor
import com.jeandarwinnewmanrios.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    //los interceptors funciona como para ver las peticiones que se hacen en la app
    // por ejemplo tomar el token de autenticacion y ponerlo en el header de la peticion
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
       return OkHttpClient
           .Builder()
           .addInterceptor(interceptor)
           .addInterceptor(authInterceptor)
           .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository {
        return RepositoryImpl(apiService)
    }
}