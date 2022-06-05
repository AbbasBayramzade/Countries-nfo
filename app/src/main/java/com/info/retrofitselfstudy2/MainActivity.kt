package com.info.retrofitselfstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var listCountries:MutableList<CountriesItem> = mutableListOf<CountriesItem>()
    private val adapter:CountriesAdapter by lazy { CountriesAdapter(this,listCountries) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listCountries = mutableListOf()
        rv_main.layoutManager = LinearLayoutManager(this@MainActivity)
        rv_main.adapter = adapter

        getCountiesData()

    }

    private fun getCountiesData(){

        ApiClient.apiService.getCountries().enqueue(object :Callback<List<CountriesItem>>{

            override fun onFailure(call: Call<List<CountriesItem>>, t: Throwable) {
                Log.e("error",t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<CountriesItem>>,
                response: Response<List<CountriesItem>>,
            ) {
                val CountriesResponse = response.body()
                listCountries.clear()
                CountriesResponse?.let {
                    listCountries.addAll(it)
                    adapter.notifyDataSetChanged()
                }
            }


            })
    }
}

