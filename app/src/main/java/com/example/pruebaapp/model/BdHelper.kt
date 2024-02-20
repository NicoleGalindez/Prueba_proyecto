package com.example.pruebaapp.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BdHelper (context: Context) : SQLiteOpenHelper(context, Constantes.NOM_BD, null, Constantes.VERSION_BD) {

        //extender de la clase SqliteOpenHelper

        override fun onCreate(db: SQLiteDatabase?) {

            db?.execSQL(Constantes.DatosMenor)


        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS DatosMenor")
                onCreate(db)


       }
}