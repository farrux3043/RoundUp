package maxmudov.farrux.roundup.Model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class modelItem(
    @SerialName("id")
    val id: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("promoted_at")
    val promotedAt: String,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("color")
    val color: String,
    @SerialName("blur_hash")
    val blurHash: String,
    @SerialName("description")
    val description: String,
    @SerialName("alt_description")
    val altDescription: Any,
    @SerialName("urls")
    val urls: Urls,
    @SerialName("links")
    val links: Links,
    @SerialName("likes")
    val likes: Int,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    @SerialName("current_user_collections")
    val currentUserCollections: List<Any>,
    @SerialName("sponsorship")
    val sponsorship: Sponsorship,
    @SerialName("topic_submissions")
    val topicSubmissions: TopicSubmissions,
    @SerialName("user")
    val user: User
)