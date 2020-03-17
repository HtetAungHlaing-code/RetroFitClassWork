package com.example.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit1.API.PostApiInterface
import com.example.retrofit1.Adapter.PostAdapter
import com.example.retrofit1.Model.Post
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       getpost()
    }
    fun loadPostlist(postlist:List<Post>){
        retrofitRecycler.apply {
            layoutManager =LinearLayoutManager(context)
            val postadapter= PostAdapter(postlist,context)
            adapter=postadapter
        }
    }
    fun getpost(){
        var BASE_URL="https://jsonplaceholder.typicode.com/"
        var retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var retrofitService=retrofit.create(PostApiInterface::class.java)
        var apiCall=retrofitService.getPost()
        apiCall.enqueue(object :Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                var postlist=response.body()
                Log.d("Response>>>>>",postlist.toString())
                if (postlist != null)
                loadPostlist(postlist)
            }

        }
        )
    }
}
