package com.example.projekt

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view_fragment.*

class RecyclerViewFragment : Fragment()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listaZadan.layoutManager = LinearLayoutManager(this.context) //not sure

        //połączenie między bazą danych a widokiem
        listaZadan.adapter = Adapter()



        val dbHelper = DataBaseHelper(this.context!!) // not sure either
        val db = dbHelper.writableDatabase
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_view_fragment, container, false)
    }
}