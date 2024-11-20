package com.flickrsearch.network

import com.flickrsearch.model.FlickrResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API service for fetching photos from the Flickr public feed.
 */
interface FlickrApiService {

    /**
     * Fetches photos based on the given search tags.
     * @param tags The tags to search for, separated by commas.
     * @return A list of photos matching the tags.
     */
    @GET("services/feeds/photos_public.gne?format=json&nojsoncallback=1")
    suspend fun getPhotosByTag(@Query("tags") tag: String): FlickrResponse

    companion object {
        /**
         * Creates an instance of the FlickrApiService with the base URL.
         */
        fun create(): FlickrApiService {
            return Retrofit.Builder()
                .baseUrl("https://api.flickr.com/")
                .addConverterFactory(GsonConverterFactory.create()) // Use GsonConverterFactory
                .build()
                .create(FlickrApiService::class.java)
        }
    }
}
