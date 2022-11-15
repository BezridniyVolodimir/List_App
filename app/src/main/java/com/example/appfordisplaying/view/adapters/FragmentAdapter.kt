package com.example.appfordisplaying.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appfordisplaying.databinding.ItemBinding
import com.example.appfordisplaying.view.models.Item

class FragmentAdapter :
    ListAdapter<Item, FragmentAdapter.ItemViewHolder>(object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var itemBinding: ItemBinding? = null

        init {
            itemBinding = binding
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            with(itemBinding!!) {
                descriptionItem.text = " Name: " + item.name + " Body: " + item.body
            }
        }
    }
}