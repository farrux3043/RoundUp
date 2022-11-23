package maxmudov.farrux.roundup.Model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopicSubmissions(
    @SerialName("architecture-interior")
    val architectureInterior: ArchitectureInterior,
    @SerialName("people")
    val people: People
)