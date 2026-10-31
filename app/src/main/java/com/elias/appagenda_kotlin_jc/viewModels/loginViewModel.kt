package com.elias.appagenda_kotlin_jc.viewModels

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class loginViewModel : ViewModel()
{
    private val auth : FirebaseAuth = Firebase.auth

    // CREAR UNA FUNCION PARA LOGEO
    fun login(email: String, password: String, onSucces : () -> Unit)
    {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task -> //manejamos una tarea
                        if(task.isSuccessful){ // Si la tarea exitosa llama a
                            onSucces()
                        }
                    }
                    .addOnFailureListener {
                        Log.d("Error", "NO SE PUDO INICIAR SESION")
                    }
            }catch (e: Exception){
                Log.d("Error", "${e.message}")

            }

        }

    }

}