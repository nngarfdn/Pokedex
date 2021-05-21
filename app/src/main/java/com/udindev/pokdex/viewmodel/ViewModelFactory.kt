package com.nanang.retrocoro.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udindev.pokdex.data.repository.PokemonRepository
import com.udindev.pokdex.network.ApiHelper
import com.udindev.pokdex.ui.home.HomeViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(PokemonRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}