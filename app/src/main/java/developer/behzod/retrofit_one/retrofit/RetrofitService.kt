package developer.behzod.retrofit_one.retrofit

import developer.behzod.retrofit_one.models.MyToDoGetResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("plan")
    fun getAllTodo(): Call<List<MyToDoGetResponse>>



}