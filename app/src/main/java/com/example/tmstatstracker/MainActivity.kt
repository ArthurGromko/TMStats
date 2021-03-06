package com.example.tmstatstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ...
        // Lookup the recyclerview in activity layout
        val rvContacts = findViewById<View>(R.id.rv_project_cards) as RecyclerView
        // Initialize contacts
        val cards = ArrayList<ProjectCard>()
        cards.add(ProjectCard("Earth Catapult", "23", "Blue"))
        cards.add(ProjectCard("Large Convoy", "36", "Red"))
        cards.add(ProjectCard("Lake Marineris", "18", "Green"))
        // Create adapter passing in the sample user data
        val adapter = CardsAdapter(cards)
        // Attach the adapter to the recyclerview to populate items
        rvContacts.adapter = adapter
        // Set layout manager to position the items
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    fun onFilterButtonClicked(view: View){
        val button =  view as Button
        val tv_value = findViewById<View>(R.id.tv_cost_filter) as TextView
        when(button.id){
            R.id.bt_filter_clear ->{
                tv_value.text = ""
            }
            R.id.bt_filter_del ->{
                tv_value.text = tv_value.text.substring(0, tv_value.text.length - 1)
            }
            else ->{
                tv_value.text = (tv_value.text as String).plus(button.text)
            }
        }

    }
}

