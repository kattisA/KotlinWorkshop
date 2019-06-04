package com.brainyful.kotlinworkshop

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    private val myList: MutableList<Recipe> = mutableListOf()
    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = RecipeAdapter(this,
            myList)

        val recyclerView: RecyclerView = this.findViewById(R.id.drink_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        //Only use to add recipes to the app from the main activity
        //addRecipe()

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

    private fun addRecipe() {
        val listOfColors: Array<String> = resources.getStringArray(R.array.background_colors)
        var recipe1 = Recipe("Mojito", "Delicious mint & lime",
            arrayListOf<String>("Lime", "Sugar", "White rum", "Mint leaves", "Soda water"), listOfColors[0] ,R.drawable.coctail)
        val recipe = HashMap<String, Any>()
        recipe["name"] = recipe1.name
        recipe["description"] = recipe1.description
        recipe["ingredients"] = recipe1.ingredients
        recipe["background"] = recipe1.background
        recipe["icon"] = recipe1.icon

        db.collection("recipes")
            .add(recipe)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
}
