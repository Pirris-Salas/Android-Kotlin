package com.pirris.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pirris.R
import com.pirris.model.Speaker

class SpeakerAdapter(onSpeakerListener: SpeakerListener) : RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    var listSpeaker = ArrayList<Speaker>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false))
    }



    override fun getItemCount() = listSpeaker.size




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeaker[position] as com.pirris.model.Speaker

        holder.ivSpeakerPhoto.setImageURI(Uri.parse(speaker.image))
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerJob.text = speaker.jobtitle

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

