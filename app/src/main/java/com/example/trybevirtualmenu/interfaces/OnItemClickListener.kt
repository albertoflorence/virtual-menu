package com.example.trybevirtualmenu.interfaces

import android.view.View

interface OnItemClickListener {
    fun onClickItem(view: View, position: Int)
}