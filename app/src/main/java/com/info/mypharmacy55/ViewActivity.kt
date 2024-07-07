package com.info.mypharmacy55

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val mydata=Database(this)
        val adapter=MedicineAdapter(this,mydata.all())
        list.adapter=adapter
    }
}