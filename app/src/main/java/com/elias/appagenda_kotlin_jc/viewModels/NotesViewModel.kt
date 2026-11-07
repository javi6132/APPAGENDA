package com.elias.appagenda_kotlin_jc.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class NotesViewModel : ViewModel()
{
    private val auth: FirebaseAuth = Firebase.auth

    private val firestore = Firebase.firestore // Hacemos uso de los BD

// CREAR FUNCION QUE PERMITA GUARDAR UNA NOTA

fun saveNote(title: String, description: String, onSucces: () -> Unit)
{
val email = auth.currentUser?.email // Obtenemos el correo de un user
    viewModelScope.launch(Dispatchers.IO)
    {
     try
     {

         val note = hashMapOf(
             "title" to title, // crea el campo en la BD
             "Description" to description, // crea el mapa, asigna el contenido de la variable
             "date" to formatDate(), //llamamos la funcion formatDate
             "email" to email.toString().trim() // tomamos la variable email y la convertimos a txt

         )

         firestore.collection("Notes").add(note) // "Notes" sera la BD
             .addOnSuccessListener { onSucces() }
             .addOnFailureListener { e -> Log.d("Error","${e.message}")}

     } catch(e: Exception){
         Log.d("Error","No se pudo registrar la nota" )
     }
    }
}

    //CREAR FUNCION PARA OBTENER EL TIEMPO DEL DISPOSITIVO AL REGISTRAR UNA NOTA
    //(importaciones de Java.Unil)
    private fun formatDate(): String{
        val curretDate: Date = Calendar.getInstance().time
        val formatDate = SimpleDateFormat("dd/MM/yyyy hh:mm:a", Locale.getDefault())
        return formatDate.format(curretDate)
    }
    fun LogOut(){ // Creamos la funcion de salida
        auth.signOut() // Cerra la sesion
    }
}