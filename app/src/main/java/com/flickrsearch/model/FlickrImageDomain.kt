package com.flickrsearch.model

data class FlickrImageDomain(
    val title: String,
    val link: String,
    val imageUrl: String,
    val dateTaken: String,
    val description: String,
    val published: String,
    val author: String,
    val tags: String
)
