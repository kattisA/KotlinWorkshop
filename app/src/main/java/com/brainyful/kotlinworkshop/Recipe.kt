package com.brainyful.kotlinworkshop

import android.graphics.drawable.Drawable

data class Recipe(
    var name: String,
    var description: String,
    var ingredients: Array<String>,
    var background: String,
    var icon:Int
)