package ir.mshirdel.voidsprit.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.mshirdel.voidsprit.BackendService
import ir.mshirdel.voidsprit.apimodels.ArticleApi
import ir.mshirdel.voidsprit.models.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>().apply {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.37:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(BackendService::class.java)
        val tagsCall = service.getArticles()
        value = listOf()
        tagsCall.enqueue(object : Callback<ArticleApi>{
            override fun onResponse(call: Call<ArticleApi>, response: Response<ArticleApi>) {
                value = response.body()?.articles
            }

            override fun onFailure(call: Call<ArticleApi>, t: Throwable) {
                Log.d("ARTICLE_API", t.message ?: "error")
            }

        })
    }
    val tags: LiveData<List<Article>> = _articles
}