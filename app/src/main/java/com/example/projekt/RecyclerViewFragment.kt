package com.example.projekt

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_fragment.*


class RecyclerViewFragment(context: Context) : Fragment()
{
    val con = context

    internal var llstEvent:List<EventClass> = ArrayList<EventClass>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listaZadan.layoutManager = LinearLayoutManager(context) //not sure

        //połączenie między bazą danych a widokiem
        listaZadan.adapter = Adapter()
        val ac = (activity as MainActivity)
        ac.db = DataBaseHelper(ac)
        //var db = ac.db

        refreshdata(context!!, ac.db)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaZadan.layoutManager = LinearLayoutManager(this.context) //not sure

        //połączenie między bazą danych a widokiem
        listaZadan.adapter = Adapter()

        val ac = (activity as MainActivity)
        ac.db = DataBaseHelper(context!!)

        //val dbHelper = DataBaseHelper(this.context!!) // not sure either
        //val db = dbHelper.writableDatabase

        refreshdata(context!!, ac.db)
    }


    fun refreshdata(context: Context, db: DataBaseHelper){
        llstEvent=db.List
        listaZadan.layoutManager=LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        val adapter =Adapter()
        listaZadan.adapter = adapter
    }
}