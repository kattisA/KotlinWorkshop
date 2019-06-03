package com.brainyful.kotlinworkshop


data class Recipe(
    var name: String,
    var description: String,
    var ingredients: Array<String>,
    var background: String,
    var icon:Int
)