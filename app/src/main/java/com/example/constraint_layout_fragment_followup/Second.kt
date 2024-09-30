package com.example.constraint_layout_fragment_followup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.example.constraint_layout_fragment_followup.databinding.FragmentSecondBinding


class Second : Fragment() {

    private val args: SecondArgs by navArgs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_second, container, false)

        val nextButton = root.findViewById<Button>(R.id.Nextbutton)
        val prevButton = root.findViewById<Button>(R.id.prevButton)
        val msg = root.findViewById<TextView>(R.id.msg)

        msg.text = args.message


        nextButton.setOnClickListener{
            findNavController().navigate(SecondDirections.actionSecondToThird(message = msg.text.toString()))
        }

        prevButton.setOnClickListener{
            findNavController().navigate(SecondDirections.actionSecondToFirst2(message = msg.text.toString()))
        }

        return root
    }


}