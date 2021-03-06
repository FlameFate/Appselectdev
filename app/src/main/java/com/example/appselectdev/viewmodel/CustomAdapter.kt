package com.example.appselectdev.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appselectdev.R
import com.example.appselectdev.data.Result
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<Result>?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_items, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemViewModel = mList?.get(position)

        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemViewModel.image)

        Picasso.get().load( ItemViewModel?.multimedia?.src).into(holder.imageView);
        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemViewModel?.display_title
        holder.textView2.text = ItemViewModel?.summary_short


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList!!.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imView)
        val textView: TextView = itemView.findViewById(R.id.film_name)
        val textView2: TextView = itemView.findViewById(R.id.film_name1)
    }
}
