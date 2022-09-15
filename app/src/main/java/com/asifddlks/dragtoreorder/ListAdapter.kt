package com.asifddlks.dragtoreorder

import com.asifddlks.dragtoreorder.databinding.ItemListBinding

//
// Created by Asif Ahmed on 15/9/22.
// Copyright (c) 2022 . All rights reserved.
//

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by
 * Asif Ahmed
 * Senior Software Engineer, TVL
 *27/06/22 - .
 */

class ListAdapter(
    private val dataList: List<Int>
) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.itemView.setBackgroundColor(if (dataList[position] % 2 == 0) 0xffff0000.toInt() else 0xff00ff00.toInt())
        holder.binding.textView.text = "${dataList[position]}"

        holder.binding.imageViewRemove.setOnClickListener {
            Toast.makeText(holder.itemView.context,"imageViewRemove",Toast.LENGTH_SHORT).show()
        }
        holder.binding.imageViewDrag.setOnClickListener {
            Toast.makeText(holder.itemView.context,"imageViewDrag",Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"itemView",Toast.LENGTH_SHORT).show()
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return dataList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface ItemInterface {
        fun onItemClick()
    }
}