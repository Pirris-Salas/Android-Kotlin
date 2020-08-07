package com.pirris.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pirris.R
import com.pirris.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener) : RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    var listSpeaker = ArrayList<Speaker>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false))
    }



    override fun getItemCount() = listSpeaker.size




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeaker[position] as com.pirris.model.Speaker


        /**
         * Con glide podemos cargar imágenes a raíz de links
         * Importante cargar la dependencia en build.gradle(Module:app)
         */
        Glide.with(holder.itemView.context)
            .load(speaker.image) //Acá asignamos el link de la imagen
            .apply(RequestOptions.circleCropTransform()) //Aplicamos un contorno circular a la imagen
            .into(holder.ivSpeakerPhoto) // Asignamos el Id del ImageView donde queremos cargar la imagen

        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerJob.text = speaker.jobtitle

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClicked(speaker, position)
        }
    }

    fun updateDatadata(data: List<Speaker>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivSpeakerPhoto = itemView.findViewById<ImageView>(R.id.ivItemSpeakerPhoto)
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvSpeakerJob = itemView.findViewById<TextView>(R.id.tvItemSpeakerJob)
    }

}

