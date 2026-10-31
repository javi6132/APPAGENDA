package com.elias.appagenda_kotlin_jc.viewModels

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class NotesViewModel : ViewModel()
{
    private val auth: FirebaseAuth = Firebase.auth

    private val firestore = Firebase.firestore // Hacemos uso de los BD

// CREAR FUNCION QUE PERMITA GUARDAR UNA NOTA

fun saveNote(title: String, description: String, onSucces: () -> Unit)
{

}

    //CREAR FUNCION PARA OBTENER EL TIEMPO DEL DISPOSITIVO AL REGISTRAR UNA NOTA
    //(importaciones de Java.Unil)

    private fun formatDate(): String{
        val curretDate: Date = Calendar.getInstance().time
        val formatDate = SimpleDateFormat("dd/MM/yyyy hh:mm:a")
    }
    fun LogOut(){ // Creamos la funcion de salida
        auth.signOut() // Cerra la sesion
    }
}