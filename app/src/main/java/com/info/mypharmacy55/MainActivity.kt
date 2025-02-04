package com.info.mypharmacy55

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show.setOnClickListener {
            val intent=Intent(this,ChooseActivity::class.java)
            startActivity(intent)
        }
        add.setOnClickListener {
            val intent=Intent(this,AddActivity::class.java)
            startActivity(intent)
        }
    }
}