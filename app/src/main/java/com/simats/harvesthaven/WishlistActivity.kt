package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class WishlistItem(
    val imageUrl: String,
    val landType: String,
    val location: String,
    val price: String,
    val status: String
)

class WishlistActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyStateContainer: LinearLayout
    private lateinit var browseButton: Button

    private val wishlistItems = mutableListOf<WishlistItem>() // Replace with real data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        recyclerView = findViewById(R.id.wishlistRecyclerView)
        emptyStateContainer = findViewById(R.id.emptyStateContainer)
        browseButton = findViewById(R.id.browsePropertiesButton)

        recyclerView.layoutManager = LinearLayoutManager(this)

        if (wishlistItems.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyStateContainer.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyStateContainer.visibility = View.GONE
            recyclerView.adapter = WishlistAdapter(wishlistItems)
        }

        browseButton.setOnClickListener {
            startActivity(Intent(this, ActivityLandListings::class.java))
        }
    }

    // 👇 Inner Adapter Class
    inner class WishlistAdapter(private val items: List<WishlistItem>) :
        RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {

        inner class WishlistViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val landImage: ImageView = view.findViewById(R.id.landImage)
            val landType: TextView = view.findViewById(R.id.landType)
            val location: TextView = view.findViewById(R.id.location)
            val price: TextView = view.findViewById(R.id.price)
            val status: TextView = view.findViewById(R.id.status)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_wishlist_card, parent, false)
            return WishlistViewHolder(view)
        }

        override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
            val item = items[position]
            holder.landType.text = item.landType
            holder.location.text = item.location
            holder.price.text = item.price
            holder.status.text = item.status

            Glide.with(this@WishlistActivity)
                .load(item.imageUrl)
                .placeholder(R.drawable.img_8) // fallback image
                .into(holder.landImage)
        }

        override fun getItemCount() = items.size
    }
}
