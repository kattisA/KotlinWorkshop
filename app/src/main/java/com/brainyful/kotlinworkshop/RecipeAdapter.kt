package com.brainyful.kotlinworkshop

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecipeAdapter (val context: Context,
                     val dataSource:Array<Recipe>): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    val titleText: TextView = view.findViewById(R.id.recipe_title)
    val subtitleText: TextView = view.findViewById(R.id.recipe_subtitle)
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
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_recipe_item, parent, false)
        return RecipeViewHolder(view)
    }
}