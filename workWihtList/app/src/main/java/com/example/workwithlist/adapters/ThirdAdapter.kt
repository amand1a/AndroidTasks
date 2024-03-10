package com.example.workwithlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workwithlist.R
import com.example.workwithlist.data.MedicalCard
import com.example.workwithlist.databinding.ThirdCardViewBinding

class ThirdAdapter: RecyclerView.Adapter<ThirdAdapter.ThirdHolder>() {

    private  val medicalCArdList: ArrayList<MedicalCard> = arrayListOf()

    class ThirdHolder(view: View): RecyclerView.ViewHolder(view){
            val binding = ThirdCardViewBinding.bind(view)
        fun bind(item: MedicalCard){
            binding.apply{
                textViewThirdCard.setText(item.type)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.third_card_view , parent , false)
        return ThirdHolder(view)
    }

    override fun getItemCount(): Int {
          return  medicalCArdList.size
    }

    override fun onBindViewHolder(holder: ThirdHolder, position: Int) {
        holder.bind(medicalCArdList[position])
    }

     fun addItems(array: ArrayList<MedicalCard>){
         medicalCArdList.addAll(array)
         notifyDataSetChanged()
     }
}