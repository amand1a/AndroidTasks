package com.example.workwithlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workwithlist.R
import com.example.workwithlist.data.User
import com.example.workwithlist.databinding.SecondCardViewBinding

class SecondAdapter: RecyclerView.Adapter<SecondAdapter.SecondHolder>() {
    private val userList: ArrayList<User> = arrayListOf()
    class  SecondHolder(view: View): RecyclerView.ViewHolder(view){

        val binding = SecondCardViewBinding.bind(view)

        fun bind(elem: User){
            val sex = if(elem.sex == "Male") R.drawable.manicon else R.drawable.womanicon
            binding.apply {
                textViewSecondFragmentSecondLine.setText( elem.age.toString())
                textViewSecondFragmentFirstLine.setText("${elem.firstName} ${elem.lastName}")
                textViewSecondFragmentThirdLine.setText(elem.description)
                imageViewSeconSex.setImageResource(sex)
                imageViewSecondFragment.setImageResource(elem.squareAvatarUri)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondHolder {
        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.second_card_view, parent , false)
        return SecondHolder(view1)
    }




    override fun getItemCount(): Int {
        return  userList.size
    }

    override fun onBindViewHolder(holder: SecondHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun addEleaddElems(arrayList: ArrayList<User>){
        userList.addAll(arrayList)
        notifyDataSetChanged()
    }

    

}