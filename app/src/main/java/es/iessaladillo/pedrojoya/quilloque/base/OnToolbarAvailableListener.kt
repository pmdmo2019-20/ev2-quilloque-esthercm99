package es.iessaladillo.pedrojoya.quilloque.base

import androidx.appcompat.widget.Toolbar

interface OnToolbarAvailableListener {

    fun onToolbarCreated(toolbar: Toolbar)

    fun onToolbarDestroyed()

}