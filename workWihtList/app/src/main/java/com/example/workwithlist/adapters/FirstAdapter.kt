package com.example.workwithlist.adapters

import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workwithlist.R

import com.example.workwithlist.data.User
import com.example.workwithlist.databinding.FirstCardViewBinding

class FirstAdapter: RecyclerView.Adapter<FirstAdapter.FirstHolder>() {
    private val userList: ArrayList<User> = arrayListOf()
    class  FirstHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = FirstCardViewBinding.bind(view)

        fun bind(elem: User){
            val icon = if(elem.sex == "Male") R.drawable.manicon else R.drawable.womanicon
            binding.apply {
                imageViewFirstCardSex.setImageResource(icon)
                imageViewFirstCard.setImageResource(elem.squareAvatarUri)
                textViewFirstCardBig.setText("${elem.firstName} ${elem.lastName}")
                textViewFirstCardSmall.setText(elem.description)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.first_card_view , parent , false)
        return FirstHolder(view)
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    override fun onBindViewHolder(holder: FirstHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun addElem(users: ArrayList<User>){
        userList.addAll(users)
        notifyDataSetChanged()
    }

    fun deleteAll(){
        userList.clear()
        notifyDataSetChanged()
    }
}