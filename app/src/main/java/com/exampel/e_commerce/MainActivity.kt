package com.exampel.e_commerce

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview : RecyclerView

    var myarraylist = ArrayList<Pclass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)

        callapi()

    }

    fun callapi() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://dummyjson.com/products"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.e("====", "onCreate: $response")
                var job = JSONObject(response)
                var products = job.getJSONArray("products")


                for (i in 0 until  products.length()) {
                    var job = products.getJSONObject(i)

                    var name = job.getString("title")
                    var price = job.getString("price")
                    var image = job.getString("thumbnail")

                    Log.e("===title", "onCreate: $name")
                    Log.e("===price", "onCreate: $price")
                    Log.e("===price", "onCreate: $image")

                    var data = Pclass(name,image,price)
                    myarraylist.add(data)

                }

                var myrecycler = MyRecycler(this@MainActivity,myarraylist)
                recyclerview.adapter = myrecycler

            },
            {
                Log.e("error====", "onCreate: ${it.localizedMessage}")
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}