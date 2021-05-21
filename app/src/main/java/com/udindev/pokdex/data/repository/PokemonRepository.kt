package com.udindev.pokdex.data.repository

import com.udindev.pokdex.network.ApiHelper

class PokemonRepository(private val apiHelper : ApiHelper) {
    suspend fun getUsers() = apiHelper.getPokemon()
}