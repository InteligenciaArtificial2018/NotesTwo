package com.example.brianmejia.notas2

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteQueryBuilder

import android.util.Log
import java.util.ArrayList


class DatabaseHandler : SQLiteOpenHelper {


    //elementos requeridos para la creacion de una BD en SQLITE

    companion object {

        val DBName = "notas2DB"
        val DBVersion = 1
        val tabla1 = "notas"
        val nID = "id"
        val elTitulo = "titulo"
        val laDescripcion = "descripcion"
        val elColor = "color"
        val laCategoria = "categoria"
    }

    var elContexto: Context? = null;
    var objetoSQL: SQLiteDatabase;


    constructor(Contexto: Context) : super(Contexto, DBName, null, DBVersion) {

        this.elContexto = Contexto;
        objetoSQL = this.writableDatabase;

    }

    //funcion para crear la tabla notas en el evento onCreate
    //donde viene incluido los campos de la tabla ID, Titulo, Descripcion, Categoria, Color
    override fun onCreate(MBASE: SQLiteDatabase?) {

        //comando para crear la tabla principal
        var QUERY1: String = "CREATE TABLE IF NOT EXISTS " + tabla1 + " " +
                "(" + nID + " INTEGER PRIMARY KEY," +
                elTitulo + " TEXT, " + laDescripcion + " TEXT, " + laCategoria +
                " TEXT," + elColor + " TEXT );"
        MBASE!!.execSQL(QUERY1);
        

    }


    //la funcion onIpdate se ejecutara en caso de que ya se encuentre la tabla
    override fun onUpgrade(MBASE: SQLiteDatabase?, p1: Int, p2: Int) {

        MBASE!!.execSQL("Drop table IF EXISTS " + tabla1)
        onCreate(MBASE)
    }



    fun agregarNOTA(cadenaVALORES: ContentValues): String {
        var Msg: String = "0";
        val ID = objetoSQL!!.insert(tabla1, "", cadenaVALORES)

        if (ID > 0) {
            Msg = "1"
        }
        return Msg
    }



    fun ajustarVALORES(claveAJUNTAR: String): ArrayList<clsNOTAS> {

        var listaVALORES = ArrayList<clsNOTAS>()
        val constructorBD = SQLiteQueryBuilder()
        constructorBD.tables = tabla1
        val propiedades = arrayOf("id", "titulo", "descripcion", "color", "categoria")
        val filas = arrayOf(claveAJUNTAR)

        val apuntador = constructorBD.query(objetoSQL, propiedades, "titulo like ?", filas, null, null, "titulo")

        //mediante la funcion de apuntador podemos encontrar los valores referentes corresponden a 1 ID
        //permite avanzar al sieguiente
        if (apuntador.moveToFirst()) {

            do {
                val elID = apuntador.getInt(apuntador.getColumnIndex("id"))
                val elTitulo = apuntador.getString(apuntador.getColumnIndex("titulo"))
                val laDescripcion = apuntador.getString(apuntador.getColumnIndex("descripcion"))
                val elColor = apuntador.getString(apuntador.getColumnIndex("color"))
                val laCategoria = apuntador.getString(apuntador.getColumnIndex("categoria"))

                listaVALORES.add(clsNOTAS(elID, elTitulo, laDescripcion, elColor, laCategoria))

            } while (apuntador.moveToNext())
        }

        return listaVALORES
    }


    //funcion para actualizar una NOTA en donde requerimos el valor de los elementos que corresponden a 1 ID
    //GENERA UN ERROR DESCONOCIDO
    fun actualizarNOTA(elementos: ContentValues, id: Int): String {

        var valoresID = arrayOf(id.toString())

        val i = objetoSQL!!.update(tabla1, elementos, "id=?", valoresID)
        if (i > 0) {
            return "ACTUALIZO";
        } else {

            return "nACTUALIZO";
        }
    }

    //funcion de eliminar notas mediante el cual apuntando a 1 ID se logra eliminar todos los valores
    //almacenados mediante esete ID
    fun ELIMINAR(id: Int): String {
        var valoresID = arrayOf(id.toString())
        val i = objetoSQL!!.delete(tabla1, "id=?", valoresID)
        if (i > 0) {
            return "BORRO";
        } else {

            return "nBORRO";
        }
    }


}