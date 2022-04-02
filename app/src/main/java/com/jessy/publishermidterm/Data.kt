package com.jessy.publishermidterm

import java.util.*

data class Data(
    var articleTitle: String,
    var authorName: String,
    var createdTime: Date,
    var articleContent: String,
    var category: String

)

data class createArticles(
    var createTitle:String,
    var createCategory: String,
    var createContent: String,
    var createId : String

)

data class categoryType(
    val food: String,
    val internationality: String,
    val pet :String,
    val travel :String
)
