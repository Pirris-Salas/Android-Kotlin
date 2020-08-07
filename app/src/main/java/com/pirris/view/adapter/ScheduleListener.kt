package com.pirris.view.adapter

import com.pirris.model.Conference


interface ScheduleListener {

    fun onConferenceClicked(conference: Conference, position: Int)
}