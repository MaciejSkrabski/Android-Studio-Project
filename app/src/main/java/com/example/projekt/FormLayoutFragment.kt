package com.example.projekt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.formlayout.*

class FormLayoutFragment : Fragment()
{
    val con = activity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        
        buttonContinue.setOnClickListener {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.formlayout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val event = EventClass (
            0,
            title = editTextTitle.text.toString(),/*getText(event_prio.checkedRadioButtonId).toString()*/
            prio = (when(radioGroupPriority.checkedRadioButtonId){

                R.id.priority1 -> 1
                R.id.priority2 -> 2
                R.id.priority3 -> 3
                else -> 0
            }),
            desc = editTextDescription.text.toString()

        )
        if (event.desc == null  || event.title == null){
            Toast.makeText(con,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        }
        else {

            var db = DataBaseHelper(this.requireContext())
            db.add_event(event)
        }

    }


}