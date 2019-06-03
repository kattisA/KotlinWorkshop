package com.brainyful.kotlinworkshop

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    private val myList: MutableList<Recipe> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = RecipeAdapter(this,
            myList)

        val recyclerView: RecyclerView = this.findViewById(R.id.drink_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val db = FirebaseFirestore.getInstance()

        db.collection("drinks")
            .get()
            .addOnSuccessListener { result ->
                for (documentSnapshot in result) {
                    val recipe = documentSnapshot.toObject(Recipe::class.java)
                    myList.add(recipe)
                    Log.d(javaClass.name, "${documentSnapshot.id} => ${documentSnapshot.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(javaClass.name, "Error getting documents.", exception)
            }



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
