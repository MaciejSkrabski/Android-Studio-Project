package com.example.projekt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter: RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(ViewGrop: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(ViewGrop.context)
        val list_item = layoutInflater.inflate(R.layout.list_item, ViewGrop, false)
        return MyViewHolder(list_item)
    }

    override fun getItemCount(): Int {
        // ile layoutów ma stworzyć? W moim przypadku: 4
        // jak to 4? a no tak:
        //1. Tytuł 2. Priorytet 3. status (czy wykonane) 4. data
       return placeHolderDataBase.titles.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //aktualizuje nasze widoki
        //recycler view ładuje tylko tyle ile jest w stanie wyświetlić. W trakcie przewijania będzie ładował kolejne elementy
        val title = holder.view.taskTitle
        val date = holder.view.taskDate
        val priority = holder.view.taskPriority
        val status = holder.view.taskStatus

        title.setText(placeHolderDataBase.titles[position])
        date.setText(placeHolderDataBase.dates[position].toString())
        priority.setText(placeHolderDataBase.priorities[position].toString())
        status.setText(placeHolderDataBase.statuses[position].toString())
    }


}


class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)