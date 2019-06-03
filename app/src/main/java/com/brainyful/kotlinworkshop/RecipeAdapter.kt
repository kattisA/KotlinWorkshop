package com.brainyful.kotlinworkshop

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter (val context: Context,
                     val dataSource:Array<Recipe>): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    val titleText: TextView = view.findViewById(R.id.recipe_title)
    val subtitleText: TextView = view.findViewById(R.id.recipe_subtitle)
    val image: ImageView = view.findViewById(R.id.Imageview)
}

    override fun getItemCount(): Int
    {
        return dataSource.size
    }
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int)
    {
        val recipe = dataSource.get(position)
        val recipeViewHolder = viewHolder as RecipeViewHolder
        recipeViewHolder.titleText.text = recipe.name
        recipeViewHolder.subtitleText.text = recipe.description
        recipeViewHolder.image.setImageResource(recipe.icon)
        recipeViewHolder.image.setBackgroundColor(Color.parseColor(recipe.background))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_recipe_item, parent, false)
        return RecipeViewHolder(view)
    }
}