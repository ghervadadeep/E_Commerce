package com.exampel.e_commerce

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyRecycler(var mainActivity: MainActivity, var data: ArrayList<Pclass>) :
    RecyclerView.Adapter<MyRecycler.myclass>() {
    class myclass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var title: TextView = itemView.findViewById(R.id.title)
        var price: TextView = itemView.findViewById(R.id.price)
        var layout: ConstraintLayout = itemView.findViewById(R.id.layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.productitem, parent, false)

        return myclass(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: myclass, position: Int) {
        holder.price.text = "$ ${data.get(position).price}"
        holder.title.text = data.get(position).name
//        holder.price.text = data.get(position).price
        Glide.with(mainActivity).load(data.get(position).image).into(holder.image);

        holder.layout.setOnClickListener { v ->
            val intent = Intent(mainActivity, Purchase::class.java)
            intent.putExtra("title", data.get(position).name)
            intent.putExtra("price", data.get(position).price)
            intent.putExtra("image", data.get(position).image)
            v.context.startActivity(intent)
        }

    }

}
