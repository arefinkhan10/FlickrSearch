package com.flickrsearch.model

import com.google.gson.annotations.SerializedName

/**
 * Data model for Flickr API response.
 * Represents a single photo entry from the public feed.
 */
data class FlickrResponse(
    val title: String,
    val link: String,
    val description: String?,
    val modified: String,
    val generator: String,
    val items: List<FlickrItem>
)

data class FlickrItem(
    val title: String,
    val link: String,
    val media: Media,
    val date_taken: String,
    val description: String,
    val published: String,
    val author: String,
    val author_id: String,
    val tags: String
)

/**
 * Nested data model representing media information.
 * Contains the direct URL to the image.
 */
data class Media(
    @SerializedName("m") val imageUrl: String
)
