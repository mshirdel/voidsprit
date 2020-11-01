package ir.mshirdel.voidsprit

import ir.mshirdel.voidsprit.models.Tag
import ir.mshirdel.voidsprit.models.TagsHolder
import retrofit2.Call
import retrofit2.http.GET

interface BackendService {
    @GET("/tags")
    fun getTags(): Call<TagsHolder>
}