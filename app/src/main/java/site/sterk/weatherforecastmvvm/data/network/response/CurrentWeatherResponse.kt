package site.sterk.weatherforecastmvvm.data.network.response

import com.google.gson.annotations.SerializedName
import site.sterk.weatherforecastmvvm.data.db.entity.CurrentWeatherEntry
import site.sterk.weatherforecastmvvm.data.db.entity.Location
import site.sterk.weatherforecastmvvm.data.db.entity.Request


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)