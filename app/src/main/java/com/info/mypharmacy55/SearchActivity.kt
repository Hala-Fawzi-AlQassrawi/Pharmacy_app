package com.info.mypharmacy55

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val mydata=Database(this)
        var type=""
        search.setOnClickListener {
        if (h1.isChecked){
            type="h"
        }else if (sh1.isChecked){
            type="sh"
        } else if (q1.isChecked){
            type="q"
        }

        val a=MedicineAdapter(this,mydata.find(type))
        llist.adapter=a
    }
    }
}