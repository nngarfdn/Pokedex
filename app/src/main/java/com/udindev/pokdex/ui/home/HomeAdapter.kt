package com.udindev.pokdex.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udindev.pokdex.R
import com.udindev.pokdex.data.response.Result


class HomeAdapter(private val list: List<Result>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_home, parent, false)
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        val image : ImageView = holder.itemView.findViewById(R.id.img_news)
        val title : TextView = holder.itemView.findViewById(R.id.textView)
//        loadImageFromUrl(image, list[position].urlToImage)

        title.text = list[position].name

//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
//            intent.putExtra(DetailActivity.EXTRA_NEWS, list[position])
//            holder.itemView.context.startActivity(intent)
//        }
    }

//    fun loadImageFromUrl(imageView: ImageView?, url: String?) {
//        Picasso.get()
//            .load(url)
//            .placeholder(R.drawable.ic_empty)
//            .error(R.drawable.ic_empty)
//            .into(imageView)
//    }


}
