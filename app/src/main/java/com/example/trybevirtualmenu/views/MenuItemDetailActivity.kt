package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.data.MenuDatabase

class MenuItemDetailActivity : AppCompatActivity() {

    private val mMenuName: TextView by lazy {findViewById(R.id.detail_name) }
    private val mMenuImage: ImageView by lazy {findViewById(R.id.detail_image) }
    private val mMenuDescription: TextView by lazy {findViewById(R.id.detail_description) }
    private val mBackButton: Button by lazy {findViewById(R.id.detail_back)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        handleDetails()
        handleBackDetails()

    }

    private fun handleDetails() {
        if(intent == null) return

        val id = intent.getIntExtra("menu_position", -1)
        if(id < 0) return

        val menu = MenuDatabase.getById(id + 1) ?: return

        mMenuName.text = menu.name
        mMenuDescription.text = menu.description
        mMenuImage.setImageResource(menu.image)
    }

    private fun handleBackDetails() {
        mBackButton.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
