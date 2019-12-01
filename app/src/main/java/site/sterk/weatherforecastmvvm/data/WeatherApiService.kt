package site.sterk.weatherforecastmvvm.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.sterk.weatherforecastmvvm.data.network.response.CurrentWeatherResponse

const val API_KEY ="e0fb4087156b42240c7f9a71064bf83e"
//http://api.weatherstack.com/current?access_key=e0fb4087156b42240c7f9a71064bf83e&query=London&Lang=en
interface WeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query" )location: String
    ): Deferred<CurrentWeatherResponse>

    companion object{
        operator fun invoke():WeatherApiService{
            val requesInterceptor = Interceptor{ chain ->
                val url =  chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requesInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)
        }
    }
}