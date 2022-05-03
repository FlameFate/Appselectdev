package com.example.appselectdev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.items)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..10) {
            data.add(ItemViewModel(R.drawable.ic_film, "Item " + i))
        }

        // This will pass the ArrayList to our Adapter


        // Setting the Adapter with the recyclerview

        val apiInterface = ApiInterface.create().getMovies()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<TestDC> {
            override fun onResponse(call: Call<TestDC>?, response: Response<TestDC>?) {
                Log.d("testlogs", "onResponse Success ${response?.body()?.results}")
                //if(response?.body() != null)
                    //recyclerAdapter.setMovieListItems(response.body()!!)
                val adapter = CustomAdapter(response?.body()?.results)
                recyclerview.adapter = adapter

            }

            override fun onFailure(call: Call<TestDC>?, t: Throwable?) {

            }
        })}}



