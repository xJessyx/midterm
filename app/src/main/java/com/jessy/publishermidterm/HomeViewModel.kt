package com.jessy.publishermidterm

import android.app.Activity
import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.HashMap

class HomeViewModel : ViewModel(){
    var collection = hashMapOf<String,Any>()
    val db = Firebase.firestore
    var articleTitle: String =""
    var authorName: String=""
    lateinit var createdTime: Date
    var articleContent: String=""
    var category: String=""


    init {
        getCollection()
    }









fun getCollection(){

    db.collection("author")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.d("result", "${document.id} => ${document.data}")
                val
                articleTitle = document.data?.get(articleTitle)
                authorName = document.data?.get(authorName) as String
                createdTime = document.data?.get(createdTime) as Date
                articleContent = document.data?.get(articleContent) as String
                category= document.data?.get(category) as String

                collection = document.data as HashMap<String, Any>
            }
        }
        .addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "Error getting documents: ", exception)
        }
}



}