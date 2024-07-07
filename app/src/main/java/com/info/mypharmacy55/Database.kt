package com.info.mypharmacy55

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context?) : SQLiteOpenHelper(context, DATANAME, null, VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $TABLENAME")
        onCreate(p0)
    }

    companion object{
        val ID="id"
        val NAME="name"
        val QUANTITY="quantity"
        val PRICE="price"
        val TYPE="type"

        val TABLENAME="medicine"
        private val DATANAME="Pharmacy.db"
        private val VERSION=1

        private val DATABASE_CREATE=
            "CREATE TABLE $TABLENAME($ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "$NAME TEXT NOT NULL, "+"$TYPE TEXT NOT NULL, "+"$QUANTITY INTEGER, "+
                    "$PRICE INTEGER);"

    }
    fun add(name:String,price:Int,quantity:Int,type:String){
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(NAME,name)
        values.put(PRICE,price)
        values.put(QUANTITY,quantity)
        values.put(TYPE,type)

        db.insert(TABLENAME,null,values)
        db. close()
    }
    fun delete(id:Int){
        val db =this.writableDatabase
        db.delete(TABLENAME,"$ID=?", arrayOf(id.toString()))
        db.close()
    }
    @SuppressLint("Range", "Recycle")
    fun all():ArrayList<Model>{
        val lst=ArrayList<Model>()
        val db =this.writableDatabase
        val query="select * from $TABLENAME where 1"
        val c=db.rawQuery(query,null)
        if (c.count!=0){
            c.moveToFirst()
            do {
                val mm=Model(
                    c.getInt(c.getColumnIndex(ID)),
                    c.getString(c.getColumnIndex(NAME)),
                    c.getInt(c.getColumnIndex(QUANTITY)),
                    c.getString(c.getColumnIndex(TYPE)),
                    c.getInt(c.getColumnIndex(PRICE))
                    )
                lst.add(mm)
            }while (c.moveToNext())
        }
        return lst
    }
    @SuppressLint("Range", "Recycle")
    fun find(type:String):ArrayList<Model>{
        val lst=ArrayList<Model>()
        val db =this.writableDatabase
        val query="select * from $TABLENAME where $TYPE=\"$type\";"
        val c=db.rawQuery(query,null)
        if (c.count!=0){
            c.moveToFirst()
            do {
                val mm=Model(
                    c.getInt(c.getColumnIndex(ID)),
                    c.getString(c.getColumnIndex(NAME)),
                    c.getInt(c.getColumnIndex(QUANTITY)),
                    c.getString(c.getColumnIndex(TYPE)),
                    c.getInt(c.getColumnIndex(PRICE))
                )
                lst.add(mm)
            }while (c.moveToNext())
        }
        return lst
    }
}






