package com.example.projekt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_view_fragment.*


class MainActivity : AppCompatActivity() {

    var db = DataBaseHelper(this)
    val fm = supportFragmentManager
    val ft = fm.beginTransaction()

    fun openFragment(fragment: Fragment)   {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.addToBackStack(null)
        ft.commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        openFragment(RecyclerViewFragment(this))

        //fragmentTransaction.add(R.id.vertical_layout, fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.dodaj){
            Toast.makeText(this, "Dodaj!", Toast.LENGTH_LONG).show()

            //Przejdź do fragmentu formularza dodania zadania

            openFragment(FormLayoutFragment())



        }


        return super.onOptionsItemSelected(item)
    }


}
