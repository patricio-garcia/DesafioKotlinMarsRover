package cl.serlitoral.desafiokotlinmarsrover.domain

import cl.serlitoral.desafiokotlinmarsrover.data.model.Photos
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("/mars-photos/api/v1/rovers/curiosity/photos/?sol=1000&{api_key}")
    suspend fun getPhotos(
            @Query("api_key") api_key: String = "f6QeDWXh5aQ7d5MiwleiWpWE4nToycARNscvv5g4"
    ): Photos

}