package com.info.mypharmacy55

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        kl.setOnClickListener {
            val intent=Intent(this,ViewActivity::class.java)
            startActivity(intent)
        }
        iff.setOnClickListener {
            val intent=Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }
    }
}