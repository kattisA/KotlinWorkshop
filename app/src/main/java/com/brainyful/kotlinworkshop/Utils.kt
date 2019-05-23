package com.brainyful.kotlinworkshop

import android.content.Context
import android.widget.Toast

fun toastMsg(msg: String, context: Context) {
    val toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
    toast.show()
}

fun getRecipes(context: Context): Array<Recipe>
{
    val listOfColors: Array<String> = context.resources.getStringArray(R.array.background_colors)
    var recipe1 = Recipe("Mojito", "Delicious mint & lime",
        arrayOf("Lime", "Sugar", "White rum", "Mint leaves", "Soda water"), listOfColors[0] ,R.drawable.coctail)
    var recipe2 = Recipe("Old fashioned", "Classic and classy",
        arrayOf("Sugar", "Angostura bitters", "Water", "Bourbon", "Orange peel"),listOfColors[1], R.drawable.coctail)
    var recipes = arrayOf(recipe1, recipe2)
    return recipes
}