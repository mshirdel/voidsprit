package ir.mshirdel.voidsprit.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.mshirdel.voidsprit.BackendService
import ir.mshirdel.voidsprit.models.User
import ir.mshirdel.voidsprit.models.UserApiHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Profile screen"
    }

    private val _user = MutableLiveData<User>().apply {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.37:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(BackendService::class.java)
        val userCall =
            service.getCurrentUser("Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyM2YzMmYzYi1mOWQ2LTQ1MmItOGJlOC01ZTQ5MWQyODhjZWUiLCJleHAiOjE2MDQ1ODYwNTR9.9LNTta2I9FwXv3BlaRHNTWXtE-M4D-Ck1W1jYalg6w-oVo226CTYisKRWaRDDKfvH4EqHfNabVfai7_vm1OXmg")
        userCall.enqueue(object : Callback<UserApiHolder> {
            override fun onResponse(call: Call<UserApiHolder>, response: Response<UserApiHolder>) {
                value = response.body()?.user
            }

            override fun onFailure(call: Call<UserApiHolder>, t: Throwable) {
                Log.d("APPERRORS", t.message ?: "error in calling user profile api")
            }

        })
    }

    val text: LiveData<String> = _text
    val user: LiveData<User> = _user
}