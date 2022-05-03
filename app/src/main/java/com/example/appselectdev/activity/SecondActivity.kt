package com.example.appselectdev.activity

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appselectdev.R
import com.example.appselectdev.data.TestDC
import com.example.appselectdev.viewmodel.ApiInterface
import com.example.appselectdev.viewmodel.CustomAdapter
import com.example.appselectdev.viewmodel.ItemViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val recyclerview = findViewById<RecyclerView>(R.id.items)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemViewModel>()


        val apiInterface = ApiInterface.create().getMovies()

        apiInterface.enqueue( object : Callback<TestDC> {
            override fun onResponse(call: Call<TestDC>?, response: Response<TestDC>?) {
                Log.d("testlogs", "onResponse Success ${response?.body()?.results}")

                val adapter = CustomAdapter(response?.body()?.results)
                recyclerview.adapter = adapter

            }

            override fun onFailure(call: Call<TestDC>?, t: Throwable?) {

            }

        })

    }}



