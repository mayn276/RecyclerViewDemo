package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf<fruit>(
        fruit("banana","joe"),
        fruit("banana","joe"),
        fruit("banana","joe"),
        fruit("banana","joe"),
        fruit("banana","joe"),
        fruit("banana","joe"),
        fruit("banana","joe"),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.MyRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedItem: fruit ->
            fruitListClicked(
                selectedItem
            )
        }
    }

    private fun fruitListClicked(fruit: fruit){
        Toast.makeText(
            this@MainActivity,
            "supplier is : ${fruit.supplier}",
            Toast.LENGTH_LONG
        ).show()
    }
}