package com.udindev.pokdex.data.response

data class PokemonResponse(
    var count: Int? = null,
    var next: String? = null,
    var previous: Any? = null,
    var results: List<Result>? = null
)