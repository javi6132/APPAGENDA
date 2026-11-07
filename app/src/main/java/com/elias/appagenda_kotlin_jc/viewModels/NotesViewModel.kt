package com.elias.appagenda_kotlin_jc.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elias.appagenda_kotlin_jc.models.NoteModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class NotesViewModel : ViewModel()
{
    private val auth: FirebaseAuth = Firebase.auth

    private val firestore = Firebase.firestore // Hacemos uso de los BD

    private val _noteData = MutableStateFlow<List<NoteModel>>(emptyList())
    val noteData : StateFlow<List<NoteModel>> = _noteData // por que estamos trabajando con una base de datos en tiempo real

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

    fun getNotes() // funcion para obtener notas de la base de datos
    {
        val email = auth.currentUser?.email // Verificar si esta autenticado ese usuario
        firestore.collection("Notes")
            .whereEqualTo("email", email.toString())
            .orderBy("date", Query.Direction.DESCENDING)
            .addSnapshotListener { query, error ->
                if (error != null)
                {
                    return@addSnapshotListener // Se realizo con exito
                }
                val notes = mutableListOf<NoteModel>()
                if (query != null)
                {
                    for (note in query)
                    {
                        val myNote = note.toObject(NoteModel :: class.java) //recorre la lista de notas
                            .copy(idNote = note.id)
                        notes.add(myNote)
                    }
                }
                _noteData.value = notes // recorre la lista de nuestras notas
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