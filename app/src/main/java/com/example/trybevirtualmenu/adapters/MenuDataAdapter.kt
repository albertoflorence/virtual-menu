package com.example.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.interfaces.OnItemClickListener
import com.example.trybevirtualmenu.models.MenuData

class MenuDataAdapter (private val menuList: List<MenuData> ) : Adapter<MenuDataAdapter.MenuViewHolder>(){

    class MenuViewHolder(view: View, private val listener: OnItemClickListener?): ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_menu_name)
        val image: ImageView = view.findViewById(R.id.item_menu_image)

        init {
            view.setOnClickListener { listener?.onClickItem(it, bindingAdapterPosition)}
        }
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener (l: OnItemClickListener) {
        listener = l
    }

    override fun getItemCount(): Int = menuList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return MenuViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.name.text = menuList[position].name
        holder.image.setImageResource(menuList[position].image)
    }

}