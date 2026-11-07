package com.elias.appagenda_kotlin_jc.views.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun checksesion(navController: NavController)
{
    LaunchedEffect(Unit)  // parametro unico
    {
        if(!FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty())
        {
            navController.navigate("Home")
        }
        else
        {
            navController.navigate("Login")
        }
    }
}