package com.example.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pindahkanan = findViewById<Button>(R.id.next)
        val pindahkiri = findViewById<Button>(R.id.back)
        showFragmentOne()

        pindahkanan.setOnClickListener({
            if (isFragmentOneLoaded)
                showFragmentThree()
            else
                showFragmentOne()
        })
        pindahkiri.setOnClickListener({
            if (isFragmentOneLoaded)
                showFragmentTwo()
            else
                showFragmentOne()
        })
    }

    fun showFragmentOne (){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true

    }

    fun showFragmentTwo (){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false

    }

    fun showFragmentThree (){
        val transaction = manager.beginTransaction()
        val fragment = FragmentThree()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false

    }

}
