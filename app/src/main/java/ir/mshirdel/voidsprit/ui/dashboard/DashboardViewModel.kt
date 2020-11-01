package ir.mshirdel.voidsprit.ui.dashboard

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

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.37:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        value = "loading..."
        val service: BackendService = retrofit.create(BackendService::class.java)
        val tagsCall = service.getTags()
        tagsCall.enqueue(object : Callback<TagsHolder> {
            override fun onResponse(call: Call<TagsHolder>, response: Response<TagsHolder>) {
                val tags = response.body()
                value = "${tags?.tags}"
            }

            override fun onFailure(call: Call<TagsHolder>, t: Throwable) {
                value = "fail ${t.message}"
            }

        })


    }
    val text: LiveData<String> = _text
}