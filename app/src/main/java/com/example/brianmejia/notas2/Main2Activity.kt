package com.example.brianmejia.notas2

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    //inicio de las propiedades
    lateinit var fondoPANTALLA:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fondoPANTALLA=findViewById<LinearLayout>(R.id.fondo) as LinearLayout


        //inicio de las propiedades
        var btnGUARDAR=findViewById<Button>(R.id.btnGUARDAR)
        var btnACTUALIZAR=findViewById<Button>(R.id.btnACTUALIZAR)


        //inicio de las operaciones
        btnGUARDAR.setOnClickListener {
            Toast.makeText(this@Main2Activity,"NOTA GUARDADA",Toast.LENGTH_SHORT).show()
            val irPANTALLA1=Intent(this@Main2Activity,MainActivity::class.java)
            startActivity(irPANTALLA1)
        }

        btnACTUALIZAR.setOnClickListener {
            Toast.makeText(this@Main2Activity,"NOTA ACTUALIZADA",Toast.LENGTH_SHORT).show()
            val irPANTALLA1=Intent(this@Main2Activity,MainActivity::class.java)
            startActivity(irPANTALLA1)
        }
    }


    //con el metodo onCreate agregamos el menu disenado para cargar los colores
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mcolores,menu)
        return true
    }

    //los colores que voy a utilizar son: colorA-> morado, colorB-> Verde, colorC-> Gris, colorD-> Naranja, ColorE-> Azul
    //de manera que cuando el usuario clickee cualquiera de estos colores mediante la propiedad graphics color se pueda guardar el color

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId)
        {
            R.id.colorA->fondoPANTALLA.setBackgroundColor(Color.parseColor("#74C2aa"))

            R.id.colorB->fondoPANTALLA.setBackgroundColor(Color.parseColor("#d1c60f"))

            R.id.colorC->fondoPANTALLA.setBackgroundColor(Color.parseColor("#7eae9d"))

            R.id.colorD->fondoPANTALLA.setBackgroundColor(Color.parseColor("#227e5f"))

            R.id.colorE->fondoPANTALLA.setBackgroundColor(Color.parseColor("#87bf6a"))
        }
        return super.onOptionsItemSelected(item)
    }


}
