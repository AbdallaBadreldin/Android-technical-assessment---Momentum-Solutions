package com.Momentum.store.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.Momentum.store.R
import com.bumptech.glide.Glide
import com.momentum.domain.model.ProductListItem

class ProductsAdapter(
    private var list: ArrayList<ProductListItem>,
    private val onRootClicked: (item: ProductListItem) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (list.isNotEmpty()) {
            val item = list[position]
            holder.root.setOnClickListener {
                if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                    onRootClicked.invoke(item)
                }
            }
            holder.title.text = item.title.toString()
            holder.price.text = item.price.toString()
            Glide.with(holder.image.context).load(item.image.toString())
                .error(com.google.android.material.R.drawable.mtrl_ic_error)
                .into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val root: CardView = itemView.findViewById(R.id.rootCard)
        val title: TextView = itemView.findViewById(R.id.productTitle)
        val price: TextView = itemView.findViewById(R.id.productPrice)
        val image: ImageView = itemView.findViewById(R.id.productImage)
    }
}