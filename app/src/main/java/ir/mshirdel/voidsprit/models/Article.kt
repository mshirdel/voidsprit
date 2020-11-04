package ir.mshirdel.voidsprit.models

import java.util.*

data class ArticleApiHolder(val articles: List<Article>, val articleCount: Int)

data class Article(
    val userId: String,
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val favorited: Boolean,
    val favoritesCount: Int,
    val createdAt: Date,
    val updatedAt: Date,
    val tagList: List<String>,
    val author: Author
)