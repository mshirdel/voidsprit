package ir.mshirdel.voidsprit

import ir.mshirdel.voidsprit.models.ArticleApiHolder
import ir.mshirdel.voidsprit.models.TagApiHolder
import ir.mshirdel.voidsprit.models.UserApiHolder
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface BackendService {
    @GET("/tags")
    fun getTags(): Call<TagApiHolder>

    @GET("/articles")
    fun getArticles(): Call<ArticleApiHolder>

    @GET("/user")
    fun getCurrentUser(@Header("Authorization") authorization: String): Call<UserApiHolder>
}