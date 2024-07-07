package com.info.mypharmacy55

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_add.*
val CHANEEL="chaneel"
val id=123456
class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val mydata=Database(this)
        cancle.setOnClickListener {
            this.finish()
        }

        save.setOnClickListener {
            if (name.text.isNotEmpty()&& qua.text.isNotEmpty()&&price.text.isNotEmpty()&&(h.isChecked||sh.isChecked||q.isChecked)){

            val name =name.text.toString()
            val quantity=qua.text.toString()
            val price=price.text.toString()
            var type=""
            if (h.isChecked){
                type="h"
            }else if (sh.isChecked){
                type="sh"
            }else if (q.isChecked){
                type="q"
            }
            mydata.add(name,price.toInt(),quantity.toInt(),type)

                val importance=NotificationManager.IMPORTANCE_HIGH
                val mchaneel=NotificationChannel(CHANEEL,"gg",importance)
                val notification=NotificationCompat.Builder(this, CHANEEL)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("تنبيه")
                    .setContentText("تم إدخال بيانات الدواء $name")
                    .build()
                val m=getSystemService(Context.NOTIFICATION_SERVICE)  as NotificationManager
                m.createNotificationChannel(mchaneel)
                m.notify(id,notification)

                this.finish()
            }else {
                Toast.makeText(this, "الرجاء التأكد من إدخال جميع البيانات ", Toast.LENGTH_SHORT).show()
            }
        }

    }
}