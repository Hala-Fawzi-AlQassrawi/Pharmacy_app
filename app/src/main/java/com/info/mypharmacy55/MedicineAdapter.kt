package com.info.mypharmacy55

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item.view.*

class MedicineAdapter(context: Context, objects: MutableList<Model>) :
    ArrayAdapter<Model>(context, 0, objects) {

    var lst = objects
    val mydata = Database(context)
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view=LayoutInflater.from(context).inflate(R.layout.item,parent,false)

        view.name1.text=getItem(position)!!.name
        view.price1.text=getItem(position)!!.price.toString()
        view.qua1.text=getItem(position)!!.quantity.toString()
        val image= arrayOf(R.drawable.syrp,R.drawable.niddle3,R.drawable.tablets)

        if (getItem(position)!!.type=="sh"){
            view.imageView3.setImageResource(image[0])
        }else if (getItem(position)!!.type=="h"){
            view.imageView3.setImageResource(image[2])
        }else{(getItem(position)!!.type=="q")
            view.imageView3.setImageResource(image[1])
        }
        view.delet.setOnClickListener {
            val dialog=AlertDialog.Builder(context)
                .setTitle("تنبيه")
                .setMessage("هل انت متأكد أنك تريد حذف بيانات الدواء ${getItem(position)!!.name}")
                .setPositiveButton("موافق"){_:DialogInterface,_:Int->
                    mydata.delete(getItem(position)!!.id)
                    lst.removeAt(position)
                    notifyDataSetChanged()
                }
                .setNegativeButton("إلغاء"){_:DialogInterface,_:Int->}
                .create()
                .show()
        }
        return view
    }
}