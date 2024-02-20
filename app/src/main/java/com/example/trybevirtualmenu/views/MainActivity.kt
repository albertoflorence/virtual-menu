package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.MenuDataAdapter
import com.example.trybevirtualmenu.data.MenuDatabase
import com.example.trybevirtualmenu.interfaces.OnItemClickListener
import com.example.trybevirtualmenu.models.MenuData

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val mMenuList: RecyclerView by lazy { findViewById(R.id.main_menu)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuList = MenuDatabase.getAll()
        mMenuList.layoutManager = LinearLayoutManager(this)
        val adapter = MenuDataAdapter(menuList)
        adapter.setOnItemClickListener(this)
        mMenuList.adapter = adapter
    }
    override fun onClickItem(view: View, position: Int) {
        val intent = Intent(baseContext, MenuItemDetailActivity::class.java)
        intent.putExtra("menu_position", position)
        startActivity(intent)
    }
}
