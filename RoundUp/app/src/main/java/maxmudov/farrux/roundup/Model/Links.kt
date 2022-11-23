package maxmudov.farrux.roundup.Model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("self")
    val self: String,
    @SerialName("html")
    val html: String,
    @SerialName("download")
    val download: String,
    @SerialName("download_location")
    val downloadLocation: String
)