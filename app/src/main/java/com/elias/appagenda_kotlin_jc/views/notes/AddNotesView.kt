package com.elias.appagenda_kotlin_jc.views.notes

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.elias.appagenda_kotlin_jc.viewModels.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AddNotesView(navController: NavController, notesViewModel: NotesViewModel)
{
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var context = LocalContext.current

//Plantilla de telefono
    Scaffold(
        topBar = {
            TopAppBar(
                { Text(text = "Agregar Nota") },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack() //REGRESA A LA LISTA ANTERIOR
                    })
                    {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "")
                    }
                }
            )
        }


    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            //EVENTO ONCLICK // Sin definir
            Button(onClick = {} ) { }

            //DISEÑO PARA TITULO
            OutlinedTextField(
                value = title,
                onValueChange = {title = it},
                label ={Text("Titulo")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp))

            //DISEÑO PARA LA DESCRIPTION
            OutlinedTextField(
                value = description,
                onValueChange = {description = it},
                label ={Text("Descripcion")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp))

            //NEW BOTON GUARDAR NOTAS
            Button(onClick = { notesViewModel.saveNote(title, description)
            { Toast.makeText(context, "Nota guardad con exito", Toast.LENGTH_SHORT).show()
            navController.popBackStack()} },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp))
            {
                Text(text = "Agregar Nota")
            }

        }
    }
}