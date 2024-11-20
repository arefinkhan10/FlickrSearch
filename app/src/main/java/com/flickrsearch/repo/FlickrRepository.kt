package com.flickrsearch.repo

import com.flickrsearch.model.FlickrImageDomain

interface FlickrRepository {
    suspend fun searchPhotos(tags: String): List<FlickrImageDomain>
}
