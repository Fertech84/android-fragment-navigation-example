package com.example.constraint_layout_fragment_followup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater


class Fifth : Fragment() {


    private val args : FifthArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_fifth, container, false)

        val nextButton = root.findViewById<Button>(R.id.Nextbutton)
        val prevButton = root.findViewById<Button>(R.id.prevButton)
        val msg = root.findViewById<TextView>(R.id.msg)

        msg.text = args.message

        nextButton.setOnClickListener{
            findNavController().navigate(FifthDirections.actionFifthToSixth(message = msg.text.toString()))
        }

        prevButton.setOnClickListener{
            findNavController().navigate(FifthDirections.actionFifthToFourth(message = msg.text.toString()))
        }

        return root
    }


}