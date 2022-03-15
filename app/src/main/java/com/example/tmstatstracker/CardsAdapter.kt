package com.example.tmstatstracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CardsAdapter(private val mCards: List<ProjectCard>) : RecyclerView.Adapter<CardsAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.tv_card_name)
        val valueTextView = itemView.findViewById<TextView>(R.id.tv_card_value)
        val clCardItem = itemView.findViewById<ConstraintLayout>(R.id.cl_card_item)
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.card_list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: CardsAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val card: ProjectCard = mCards.get(position)
        // Set item views based on your views and data model
        val textViewName = viewHolder.nameTextView
        textViewName.setText(card.name)
        val textViewValue = viewHolder.valueTextView
        textViewValue.setText(card.basicCost)
        val clCardItem = viewHolder.clCardItem
        when (card.type) {
            "Red" -> clCardItem.setBackgroundColor(Color.parseColor("#FF0000"))
            "Blue" -> clCardItem.setBackgroundColor(Color.parseColor("#0000FF"))
            "Green" -> clCardItem.setBackgroundColor(Color.parseColor("#00FF00"))
            else -> {
                //Should not happen
            }
        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mCards.size
    }
}