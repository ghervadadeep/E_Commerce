package com.exampel.e_commerce

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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


                for (i in 1..products.length()) {
                    var job = products.getJSONObject(i)

                    var id = job.getString("title")

                    Log.e("===id", "onCreate: $id")
                }
            },
            {
                Log.e("error====", "onCreate: ${it.localizedMessage}")
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}