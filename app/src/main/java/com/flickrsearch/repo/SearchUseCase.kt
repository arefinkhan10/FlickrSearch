package com.flickrsearch.repo

class SearchUseCase(private val repository: FlickrRepository) {
    suspend fun execute(tags: String) = repository.searchPhotos(tags)
}
