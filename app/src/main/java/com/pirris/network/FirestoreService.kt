package com.pirris.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.pirris.model.Conference
import com.pirris.model.Speaker
import java.lang.Exception

const val conferences_collection = "conference"
const val speakers_collection = "speakers"

class FirestoreService{

    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        //Esto permite que se descarguen los datos en el teléfono y se mantengan de manera persistente
        //Incluso a pesar de que el dispositivo no tenga conexión a internet
        //Básicamente tenemos los datos en modo offline una vez descargados
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFirestore.collection(speakers_collection)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
            }


            .addOnFailureListener{result ->
                result.runCatching {
                    val ex = callback.onFailed(result)
                    println(ex)
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>){
        firebaseFirestore.collection(conferences_collection)
            .get()
            .addOnSuccessListener { result ->
                   val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
            }
        }

    }
