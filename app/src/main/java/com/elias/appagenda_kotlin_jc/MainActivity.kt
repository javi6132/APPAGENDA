package com.elias.appagenda_kotlin_jc

//import android.annotation.SuppressLint //nuevo
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface //SURFACE
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elias.appagenda_kotlin_jc.navigation.NavManager
import com.elias.appagenda_kotlin_jc.ui.theme.AppAgendaKotlinJCTheme
import com.elias.appagenda_kotlin_jc.viewModels.NotesViewModel
import com.elias.appagenda_kotlin_jc.viewModels.RegisterViewModel
import com.elias.appagenda_kotlin_jc.viewModels.loginViewModel
import com.elias.appagenda_kotlin_jc.views.login.LoginView

class MainActivity : ComponentActivity() {

    val loginVM : loginViewModel by viewModels()
    val registerVM : RegisterViewModel by viewModels()
    val notesVM : NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppAgendaKotlinJCTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    //Mandemos a llamar el archivo LoginView
                    NavManager(loginVM, registerVM, notesVM)

                }
            }
        }
    }
}



