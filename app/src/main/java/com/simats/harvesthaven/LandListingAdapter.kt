package com.simats.harvesthaven

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simats.harvesthaven.api.Land
import java.text.NumberFormat
import java.util.Locale

class LandListingAdapter(
    private val lands: List<Land>,
    private val onItemClick: (Land) -> Unit
) : RecyclerView.Adapter<LandListingAdapter.LandViewHolder>() {

    class LandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.findViewById(R.id.landCardView)
        val landImage: ImageView = view.findViewById(R.id.landImage)
        val landType: TextView = view.findViewById(R.id.landType)
        val location: TextView = view.findViewById(R.id.location)
        val price: TextView = view.findViewById(R.id.price)
        val status: TextView = view.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_land_listing, parent, false)
        return LandViewHolder(view)
    }

    override fun onBindViewHolder(holder: LandViewHolder, position: Int) {
        val land = lands[position]
        
        holder.landType.text = land.landType
        holder.location.text = "${land.location.city}, ${land.location.state}"
        holder.status.text = land.status
        
        // Format price with Indian Rupee symbol
        val formattedPrice = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
            .format(land.price)
        holder.price.text = formattedPrice

        // Load first image using Glide
        land.images?.firstOrNull()?.url?.let { url ->
            Glide.with(holder.landImage.context)
                .load(url)
                .placeholder(R.drawable.placeholder_land)
                .error(R.drawable.error_land)
                .centerCrop()
                .into(holder.landImage)
        } ?: run {
            holder.landImage.setImageResource(R.drawable.placeholder_land)
        }

        // Set click listener
        holder.cardView.setOnClickListener { onItemClick(land) }
    }

    override fun getItemCount() = lands.size
}