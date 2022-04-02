package com.jessy.publishermidterm

import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.jessy.publishermidterm.databinding.FragmentDetailBinding
import java.util.*

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    var createTitle = ""
    var createCategory = ""
    var createContent = ""
    var createId = ""




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        var now = Calendar.getInstance().time
        Log.v("now","$now")
        binding.detailBtPublish.setOnClickListener {

            val db = Firebase.firestore
            createTitle = binding.detailEdTitle.text.toString()
            createCategory = binding.detailEdCategory.text.toString()
            createContent = binding.detailEdContent.text.toString()
            createId = binding.detailEdId.text.toString()

            db.collection("author")
                .whereEqualTo("author", createId)
                .get()
                .addOnSuccessListener { exception ->
//                    Log.w(ContentValues.TAG, "Error getting documents")
                    Toast.makeText(activity as Activity, "此作者已發過文章", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { documents ->
                    val addarticleAll= Data(createTitle,createId,now,createContent,createCategory)
                    db.collection("author").document()
                        .set(addarticleAll)
                }
        }
        return binding.root
    }


}