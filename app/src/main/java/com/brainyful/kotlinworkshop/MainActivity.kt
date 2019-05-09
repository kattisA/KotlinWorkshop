package com.brainyful.kotlinworkshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = RecipeAdapter(this,
            getRecipes())

        val recyclerView: RecyclerView = this.findViewById(R.id.drink_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        /*recyclerView = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = recyclerView.getItemDecorationAt(position) as String

                // Toast the values
                toastMsg("Position :$position\nItem Value : $itemValue", applicationContext)

            }
        }*/

    }
}
