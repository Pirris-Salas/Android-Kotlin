package com.pirris.view.adapter

import com.pirris.model.Speaker

interface SpeakerListener {

    fun onSpeakerClicked(speaker: Speaker, position: Int)

}