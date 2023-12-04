package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MyRecyclerViewAdapter(private val fruitsList:List<fruit>,
    private val ClickListener:(fruit)->Unit
) : RecyclerView.Adapter<MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_items,parent,false)

        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     val fruit = fruitsList[position]
        holder.bind(fruit,ClickListener)
    }
}


class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(fruit: fruit, clickListener: (fruit) -> Unit) {
        val  myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener {
            clickListener(fruit)
        }

    }


}
