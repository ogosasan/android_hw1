package com.example.vk_hw1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ComponentActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    private val adapter = MyAdapter()
    var items = ArrayList<Int>()
    val KEY = "items"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.fab)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
            recyclerView.smoothScrollToPosition(adapter.itemCount)
            Log.d("ADD", "${adapter.itemCount + 1}")
        }


        if (savedInstanceState != null) {
            items = savedInstanceState.getIntegerArrayList(KEY) as ArrayList<Int>
            adapter.setItems(items)
        } else {
            adapter.setItems(items)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList(KEY, adapter.getItems())
        super.onSaveInstanceState(outState)
    }

}

