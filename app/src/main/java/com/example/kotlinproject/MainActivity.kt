package com.example.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
   lateinit var fragmentManager: FragmentManager
   lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = MainFragment()
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }
}