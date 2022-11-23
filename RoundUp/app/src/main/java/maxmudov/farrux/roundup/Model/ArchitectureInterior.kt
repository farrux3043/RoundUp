package maxmudov.farrux.roundup.Model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArchitectureInterior(
    @SerialName("status")
    val status: String
)