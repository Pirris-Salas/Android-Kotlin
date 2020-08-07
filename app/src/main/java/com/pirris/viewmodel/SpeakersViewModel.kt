package com.pirris.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pirris.model.Speaker
import com.pirris.network.Callback
import com.pirris.network.FirestoreService
import java.lang.Exception

class SpeakersViewModel : ViewModel(){
    val firestoreService = FirestoreService()
    var getSpeaker: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakersFromFireBase()
    }

    fun getSpeakersFromFireBase(){
        firestoreService.getSpeakers(object: Callback<List<Speaker>>{
            override fun onSuccess(result: List<Speaker>) {
                getSpeaker.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }
}