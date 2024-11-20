package com.flickrsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flickrsearch.model.FlickrImageDomain
import com.flickrsearch.repo.SearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for managing Flickr search results and UI state.
 */
class FlickrViewModel(private val searchPhotosUseCase: SearchUseCase) : ViewModel() {

    private val _photos = MutableStateFlow<List<FlickrImageDomain>>(emptyList())
    val photos: StateFlow<List<FlickrImageDomain>> = _photos

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    /**
     * Executes a search query and updates the state with the results.
     */
    fun searchPhotos(query: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val results = searchPhotosUseCase.execute(query)
                if (results.isEmpty()) {
                    _error.value = "No photos found for the tag \"$query\""
                } else {
                    _photos.value = results
                }
            } catch (e: Exception) {
                _error.value = "Error fetching photos: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}
