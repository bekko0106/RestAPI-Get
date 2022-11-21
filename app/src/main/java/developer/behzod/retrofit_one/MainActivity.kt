package developer.behzod.retrofit_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import developer.behzod.retrofit_one.adapters.MyGetTodoAdapter
import developer.behzod.retrofit_one.databinding.ActivityMainBinding
import developer.behzod.retrofit_one.models.MyToDoGetResponse
import developer.behzod.retrofit_one.retrofit.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var myGetTodoAdapter: MyGetTodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APIClient.getRetrofitService().getAllTodo()
            .enqueue(object : Callback<List<MyToDoGetResponse>> {
                override fun onResponse(
                    call: Call<List<MyToDoGetResponse>>,
                    response: Response<List<MyToDoGetResponse>>
                ) {
                    if (response.isSuccessful) {

                        myGetTodoAdapter = MyGetTodoAdapter(response.body()!!)
                        binding.myRv.adapter = myGetTodoAdapter
                    }

                }

                override fun onFailure(call: Call<List<MyToDoGetResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Internet bilan muammo", Toast.LENGTH_SHORT)
                        .show()
                }

            })


    }
}