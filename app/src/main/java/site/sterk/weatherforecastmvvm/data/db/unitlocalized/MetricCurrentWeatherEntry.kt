package site.sterk.weatherforecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

data class MetricCurrentWeatherEntry (
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double,
    @ColumnInfo(name = "weatherDescription")
    override val weatherDescription: String,
    @ColumnInfo(name = "weatherIcons")
    override val iconUrl: String
): UnitSpecificCurrentWeatherEntry{

}