package site.sterk.weatherforecastmvvm.data.db.unitlocalized


interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val weatherDescription: String
    val iconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}