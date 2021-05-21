package com.udindev.pokdex.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.udindev.pokdex.data.repository.PokemonRepository
import com.udindev.pokdex.utils.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel (private val mainRepository: PokemonRepository): ViewModel() {
    fun  getPokemon() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        }catch (e : Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
}