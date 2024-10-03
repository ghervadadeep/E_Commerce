package com.exampel.e_commerce

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Purchase : AppCompatActivity() {

    lateinit var purchaseimage: ImageView
    lateinit var purchasetitle: TextView
    lateinit var purchaseprice: TextView
    lateinit var purchasebutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)

        purchaseimage = findViewById(R.id.purchaseimage)
        purchasetitle = findViewById(R.id.purchasetitle)
        purchaseprice = findViewById(R.id.purchaseprice)
        purchasebutton = findViewById(R.id.purchasebutton)


        var gettitle = intent.getStringExtra("title")
        var getprice = intent.getStringExtra("price")
        var getimage = intent.getStringExtra("image")


        Glide.with(this@Purchase).load(getimage).into(purchaseimage);
        purchasetitle.setText(gettitle)
        purchaseprice.setText("$ ${getprice}")


    }
}