package com.example.projekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaZadan.layoutManager = LinearLayoutManager(this)

        //połączenie między bazą danych a widokiem
        listaZadan.adapter = Adapter()



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.dodaj){
            Toast.makeText(this, "Dodaj!", Toast.LENGTH_LONG).show();
            //Przejdź do fragmentu formularza dodania zadania
        }
        return super.onOptionsItemSelected(item)
    }
}
