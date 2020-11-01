package ir.mshirdel.voidsprit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.mshirdel.voidsprit.BackendService
import ir.mshirdel.voidsprit.models.TagsHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {

    private val _tags = MutableLiveData<List<String>>().apply {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.37:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(BackendService::class.java)
        val tagsCall = service.getTags()
        value = listOf()
        tagsCall.enqueue(object : Callback<TagsHolder>{
            override fun onResponse(call: Call<TagsHolder>, response: Response<TagsHolder>) {
                value = response.body()?.tags
            }

            override fun onFailure(call: Call<TagsHolder>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    val tags: LiveData<List<String>> = _tags
}