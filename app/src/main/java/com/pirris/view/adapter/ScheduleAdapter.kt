package com.pirris.view.adapter

import android.telecom.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.pirris.R

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>(){

    var listConference = ArrayList<Conference>()
    /**
     * Esta es la estructura básica de cualquier RecyclerView
     */

    /**
     * Método para crear o indicar el diseño a utilizar para nuestra lista, es decir el archivo que
     * contendrá la lista, es decir item_schedule.xml
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder {

       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))
    }

    /**
     * Método para determinar la cantidad de elementos en la lista
     * Instanciamos la clase Conference mediante una variable tipo vector y asignamos el tamaño del vector a la función
     * que determinará la cantidad de elementos en la lista
     * Función Linear
     */
    override fun getItemCount() = listConference.size

    /**
     * Método que indicará los elementos que vamos a cargar
     * Acá vinculamos las variabes de la clase ViewHolder con los datos que traemos de firebase
     */
    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
      
    }

    /**
     * Clase interna
     * Para indicar como podemos enlazar cada uno de nuestros elementos visuales
     * Acá es donde enlazamos los id de cada TextView a una variable
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
    }
}