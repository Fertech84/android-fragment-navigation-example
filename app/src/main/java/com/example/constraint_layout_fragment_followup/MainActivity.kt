package com.example.constraint_layout_fragment_followup

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.constraint_layout_fragment_followup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainActivityBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var index = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mainActivityBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                setReorderingAllowed(true)
                add<First>(R.id.fragmentContainerView)

            }
        }

        mainActivityBinding.Nextbutton.setOnClickListener{
            index++
            if (index == 10) index = 1
            changeFragment()
        }

        mainActivityBinding.prevButton.setOnClickListener{
            index --
            if (index == 0) index = 9

            changeFragment()
        }
    }

    private fun changeFragment(){
        supportFragmentManager.commit {
            when (index){
                1 -> replace<First>(R.id.fragmentContainerView)
                2 -> replace<Second>(R.id.fragmentContainerView)
                3 -> replace<Third>(R.id.fragmentContainerView)
                4 -> replace<Fourth>(R.id.fragmentContainerView)
                5 -> replace<Fifth>(R.id.fragmentContainerView)
                6 -> replace<Sixth>(R.id.fragmentContainerView)
                7 -> replace<Seventh>(R.id.fragmentContainerView)
                8 -> replace<Eight>(R.id.fragmentContainerView)
                9 -> replace<Last>(R.id.fragmentContainerView)
                else -> replace<First>(R.id.fragmentContainerView)
            }
        }
    }
}