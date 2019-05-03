package com.brainyful.kotlinworkshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {


    var array = arrayOf("Martini", "Gin and Tonic", "Cosmopolitan", "Mohito", "Margherita", "Manhattan", "Appletini")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter(this,
            R.layout.listview_item, array)

        val listView: ListView = this.findViewById(R.id.drink_list)
        listView.adapter = adapter

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = listView.getItemAtPosition(position) as String

                // Toast the values
                toastMsg("Position :$position\nItem Value : $itemValue", applicationContext)

            }
        }

    }
}
