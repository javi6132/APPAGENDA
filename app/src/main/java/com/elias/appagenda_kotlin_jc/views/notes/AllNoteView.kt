package com.elias.appagenda_kotlin_jc.views.notes

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.elias.appagenda_kotlin_jc.viewModels.NotesViewModel

@Composable

fun AllNotesView(navController: NavController, notesViewModel: NotesViewModel)
{

    Scaffold(
        topBar =
            {
                TopAppBar(
                    { Text(text = "Mis Notas")}
                    ,
                    navigationIcon =
                        {
                            IconButton(onClick = {navController.popBackStack()
//REGRESAR A LA VISTA ANTERIOR
                            })

                            {
                                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack
                                    ,
                                    contentDescription = "")

                            }
                        }
                )

            }

    ) {padding ->
        Column(
            modifier = Modifier.padding(padding)
            ,
            horizontalAlignment = Alignment.CenterHorizontally)

        {
        }
    }

}