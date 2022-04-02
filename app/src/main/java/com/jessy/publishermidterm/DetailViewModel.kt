package com.jessy.publishermidterm

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DetailViewModel : ViewModel() {
//    var createTitle = ""
//    var createCategory = ""
//    var createContent = ""
//    var createId = ""





//    fun addArticles() {
//
//        val db = Firebase.firestore
//
//
//        db.collection("author")
//            .whereEqualTo("author", "紅茶")
//            .get()
//            .addOnSuccessListener { exception ->
////                    Log.w(ContentValues.TAG, "Error getting documents")
//                Toast.makeText(activity as Activity, "此作者已發過文章", Toast.LENGTH_LONG).show()
//            }
//            .addOnFailureListener { documents ->
//                val addarticleAll = Data(createTitle, createId, now, createContent, createCategory)
//                db.collection("author").document()
//                    .set(addarticleAll)
//            }
//    }

}