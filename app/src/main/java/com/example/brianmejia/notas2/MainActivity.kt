package com.example.brianmejia.notas2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val btnAGREGAR=findViewById<Button>(R.id.btnAGREGAR)
        val btnACTUALIZAR=findViewById<Button>(R.id.btnACTUALIZAR)

        /*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        */

        //********************************   botones de agregar y actualizar   **************************
        btnAGREGAR.setOnClickListener {
            val intent=Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(intent)
        }


        btnACTUALIZAR.setOnClickListener {
            Toast.makeText(this@MainActivity,"ACTUALIZAR LISTA",Toast.LENGTH_SHORT).show()
        }
        //**********************************************************************************************


        //inicio de las operaciones

        val toggle = ActionBarDrawerToggle(
                this,  drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        //FIN DEL OVERRIDE
    }



    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> Toast.makeText(this@MainActivity,"MENU AJUSTES",Toast.LENGTH_SHORT).show()
            else -> return super.onOptionsItemSelected(item)
        }
        return true //puesto a proposito
    }



    //opciones para la barra lateral
    //cuando se selecciona c/u de los items
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
                Toast.makeText(this@MainActivity,"NOTAS",Toast.LENGTH_SHORT).show()

            }
            R.id.nav_gallery -> {
                Toast.makeText(this@MainActivity,"AJUSTES",Toast.LENGTH_SHORT).show()

            }
            R.id.nav_slideshow -> {
                Toast.makeText(this@MainActivity,"CATEGORIAS",Toast.LENGTH_SHORT).show()

            }
            R.id.nav_manage -> {
                Toast.makeText(this@MainActivity,"ACERCA DE",Toast.LENGTH_SHORT).show()

            }


        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
