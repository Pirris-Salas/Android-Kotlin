package com.pirris.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.pirris.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Reemplezamos el toolbar por defecto de la aplicación por el toolbar creado
        setActionBar(findViewById(R.id.toolbarMain))
        configNav()

/**
        var cargar = Crear_Colecciones_En_Firebase()
        cargar.agregarColeccionesFireStore()
*/
    }

    //Función para mostrar todos los fragmentos dentro del fragmento del activity_main.xml
    fun configNav(){
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }
}