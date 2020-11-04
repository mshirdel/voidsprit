package ir.mshirdel.voidsprit

import ir.mshirdel.voidsprit.apimodels.ArticleApi
import ir.mshirdel.voidsprit.apimodels.UserApi
import ir.mshirdel.voidsprit.models.TagApiHolder
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface BackendService {
    @GET("/tags")
    fun getTags(): Call<TagApiHolder>

    @GET("/articles")
    fun getArticles(): Call<ArticleApi>

    @GET("/user")
    fun getCurrentUser(@Header("Authorization") authorization: String): Call<UserApi>
}