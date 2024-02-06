package com.example.alpha.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alpha.R
import com.example.alpha.databinding.MyViewGroupBinding
import com.example.alpha.entity.SingleResultInterface

class PhotosAdapter(private val values: List<SingleResultInterface?>) :
    RecyclerView.Adapter<PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = MyViewGroupBinding.inflate(LayoutInflater.from(parent.context))
        return PhotosViewHolder(binding)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val items = values[position]
        if (items?.subsection.toString().isBlank()) {
            holder.binding.topText.text = "No info"
        } else holder.binding.topText.text = items?.subsection.toString()
        holder.binding.bottomText.text = items?.multimedia?.get(1)?.copyright
        val context = holder.binding.imageView.context
        Glide.with(context).load(items?.multimedia?.get(1)?.url.toString())
            .into(holder.binding.imageView)

        holder.binding.imageView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("param1", items?.multimedia?.get(1)?.url)
            }
            it.findNavController().navigate(R.id.action_mainFragment_to_photoFragment, bundle)
        }
    }
}

class PhotosViewHolder(val binding: MyViewGroupBinding) : RecyclerView.ViewHolder(binding.root)

