package com.example.hellotopets.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hellotopets.R
import com.example.hellotopets.const.Layout
import com.example.hellotopets.data.DataSource

class DogCardAdapter(private val context: Context?,private val layout: Int):RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>()
{
    val dogList = DataSource.dogs
    class DogCardViewHolder(view:View?):RecyclerView.ViewHolder(view!!)
    {
        val dogImageView : ImageView? = view?.findViewById(R.id.dog_img)
        val dogNameText : TextView? = view?.findViewById(R.id.dog_name)
        val dogAgeText : TextView? = view?.findViewById(R.id.dog_age)
        val dogHobbyText : TextView? = view?.findViewById(R.id.dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
       val adapterLayout= when(layout){
            Layout.GRID->LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
            else->LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)


        }
        return DogCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dogData = dogList[position]
        holder.dogImageView?.setImageResource(dogData.imageResourceId)
        holder.dogNameText?.text = dogData.name
        val resources = context?.resources
        holder.dogAgeText?.text = resources?.getString(R.string.dog_age, dogData.age)
        holder.dogHobbyText?.text = resources?.getString(R.string.dog_hobbies, dogData.hobbies)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }


}