package com.example.brianmejia.notas2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main3.view.*

class ADAPTADOR (con: Context, arrList:ArrayList<>): BaseAdapter() {

    var arrayList = ArrayList<>()
    var context: Context? = null
    var myInflater: LayoutInflater? = null

    init {

        this.context    = con
        this.myInflater = LayoutInflater.from(context)
        this.arrayList  = arrList
    }



    //colocando el INFLATER de donde se optiene el modelo para presentar las notas
    //con su respectivo diseno
    override fun getView(valor1: Int, valor2: View?, valor3: ViewGroup?): View {
        var myView = myInflater!!.inflate(R.layout.activity_main3,null)
        var elOBJETO = arrayList[valor1]

        //este va conectado con los elementos usados en la plantilla principal
        var plantillaTITULO:String=elOBJETO.Titulo.toString()
        var plantillaRESUMEN:String=elOBJETO.Descripcion.toString()
        myView.elemento1.text=plantillaTITULO
        myView.elemento2.text=plantillaRESUMEN

        //var plantillaTITULO : String = elOBJETO.Titulo.toString() +" "+ elOBJETO.Descripcion.toString()
        //myView.elemento1.text = plantillaTITULO

        return myView

    }

    override fun getItem(valor1: Int): Any {
        return arrayList[valor1]

    }

    override fun getItemId(valor1: Int): Long {
        return valor1.toLong()

    }

    override fun getCount(): Int {
        return arrayList.size

    }


}
