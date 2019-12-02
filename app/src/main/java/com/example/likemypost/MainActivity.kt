package com.example.likemypost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    var up: Int = 0
    var down: Int = 0

    lateinit var  sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","OnCreate")

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        imageViewLike.setOnClickListener(){
            up++
            textViewUp.text = up.toString()
        }

        imageViewDislike.setOnClickListener(){
            down++
            textViewDown.text = down.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","OnStart")
    }

    override fun onResume(){
        super.onResume()
        Log.d("MainActivity","OnResume")

        //Retrieve counters from sharedPref


        up = sharedPreferences.getInt(getString(R.string.thumbs_up), 0)
        down = sharedPreferences.getInt(getString(R.string.thumbs_down), 0)
        textViewUp.text = up.toString()
        textViewDown.text = down.toString()

    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","OnPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.thumbs_up), up)
            putInt(getString(R.string.thumbs_down), down)
            apply()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","OnDestroy")
    }
}
