package com.brainyful.kotlinworkshop

import android.content.Context
import android.widget.Toast

fun toastMsg(msg: String, context: Context) {
    val toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
    toast.show()
}

fun getRecipes(): Array<Recipe>
{
    var recipe1 = Recipe("Mojito", "Delicious mint & lime", arrayOf("Lime", "Sugar", "White rum", "Mint leaves", "Soda water"))
    var recipe2 = Recipe("Old fashioned", "Classic and classy", arrayOf("Sugar", "Angostura bitters", "Water", "Bourbon", "Orange peel"))
    var recipes = arrayOf(recipe1, recipe2)
    return recipes
}