package ir.mshirdel.voidsprit

import ir.mshirdel.voidsprit.apimodels.ArticleApi
import ir.mshirdel.voidsprit.models.Article
import ir.mshirdel.voidsprit.models.Tag
import ir.mshirdel.voidsprit.models.TagsHolder
import retrofit2.Call
import retrofit2.http.GET

interface BackendService {
    @GET("/tags")
    fun getTags(): Call<TagsHolder>

    @GET("/articles")
    fun getArticles(): Call<ArticleApi>
}