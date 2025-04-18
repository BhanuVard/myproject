package com.simats.harvesthaven.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simats.harvesthaven.R
import com.simats.harvesthaven.models.LandPost

class LandAdapter(
    private val lands: List<LandPost>,
    private val onItemClick: (LandPost) -> Unit
) : RecyclerView.Adapter<LandAdapter.LandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_land_listing, parent, false)
        return LandViewHolder(view)
    }

    override fun onBindViewHolder(holder: LandViewHolder, position: Int) {
        val land = lands[position]
        holder.bind(land)
    }

    override fun getItemCount(): Int = lands.size

    inner class LandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val landImage: ImageView = itemView.findViewById(R.id.landImage)
        private val landType: TextView = itemView.findViewById(R.id.landType)
        private val location: TextView = itemView.findViewById(R.id.location)
        private val price: TextView = itemView.findViewById(R.id.price)
        private val status: TextView = itemView.findViewById(R.id.status)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(lands[position])
                }
            }
        }

        fun bind(land: LandPost) {
            landType.text = land.landType
            location.text = "${land.location.city}, ${land.location.state}"
            price.text = "₹${land.price}"
            status.text = land.status

            // Load image using Glide
            Glide.with(itemView.context)
                .load(land.imageUrl)
                .placeholder(R.drawable.img_8)
                .error(R.drawable.img_8)
                .centerCrop()
                .into(landImage)
        }
    }
}