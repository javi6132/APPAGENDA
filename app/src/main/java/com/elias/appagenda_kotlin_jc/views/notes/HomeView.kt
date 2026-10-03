package com.elias.appagenda_kotlin_jc.views.notes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.elias.appagenda_kotlin_jc.viewModels.NotesViewModel

@Composable
fun HomeView(navController: NavController, notesVM: NotesViewModel){
    Text(text = "Inicio")
}