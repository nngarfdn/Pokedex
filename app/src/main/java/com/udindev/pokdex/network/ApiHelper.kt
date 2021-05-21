package com.udindev.pokdex.network

import com.nanang.berberita.data.api.ApiService

class ApiHelper(private val apiService: ApiService) {
    suspend fun getPokemon() = apiService.getPokemon()
}