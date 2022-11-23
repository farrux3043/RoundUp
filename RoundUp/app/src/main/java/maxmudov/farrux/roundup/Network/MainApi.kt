package maxmudov.farrux.roundup.Network

import io.reactivex.rxjava3.core.Observable
import maxmudov.farrux.roundup.Model.model
import retrofit2.http.GET
import retrofit2.http.Query


interface MainApi {

    //https://api.unsplash.com/photos/mT8hj53DywChJkbscZAN5aHio9v2M9impW_i-VIc7vs
    @GET("photos")
    fun getPhotos(
      @Query("API_KEY") api_key:String
    ):Observable<model>


}