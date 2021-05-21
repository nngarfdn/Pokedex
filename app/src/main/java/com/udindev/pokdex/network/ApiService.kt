package com.nanang.berberita.data.api

import com.udindev.pokdex.data.response.PokemonResponse
import retrofit2.http.GET

interface ApiService {

    @GET("pokemon")
    suspend fun getPokemon(): PokemonResponse

}