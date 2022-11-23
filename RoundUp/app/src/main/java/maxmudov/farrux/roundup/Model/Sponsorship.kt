package maxmudov.farrux.roundup.Model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sponsorship(
    @SerialName("impression_urls")
    val impressionUrls: List<String>,
    @SerialName("tagline")
    val tagline: String,
    @SerialName("tagline_url")
    val taglineUrl: String,
    @SerialName("sponsor")
    val sponsor: Sponsor
)