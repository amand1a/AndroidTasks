package com.example.navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.databinding.ViewCardBinding

class ImageAdapter: RecyclerView.Adapter<ImageAdapter.ImageHolder>() {
    val arrayImage = arrayListOf<Image>()
    class  ImageHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ViewCardBinding.bind(view)

        fun bind(image: Image){
            binding.imageView2.setImageResource(image.id)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_card, parent , false)
        return ImageHolder(view)
    }

    override fun getItemCount(): Int {
        return  arrayImage.size
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
         holder.bind(arrayImage[position])
    }

    public fun addImage(image: Image){
        arrayImage.add(image)
        notifyDataSetChanged()
    }

    public fun deleteImage(){
        val index = arrayImage.size
        if(index < 0){
            return
        }
        arrayImage.removeAt(index-1)
        notifyItemRemoved(index-1)
    }
}