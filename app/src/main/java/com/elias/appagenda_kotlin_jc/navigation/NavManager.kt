package com.elias.appagenda_kotlin_jc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.elias.appagenda_kotlin_jc.viewModels.NotesViewModel
import com.elias.appagenda_kotlin_jc.viewModels.RegisterViewModel
import com.elias.appagenda_kotlin_jc.viewModels.loginViewModel
import com.elias.appagenda_kotlin_jc.views.login.LoginView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elias.appagenda_kotlin_jc.views.notes.HomeView
import com.elias.appagenda_kotlin_jc.views.register.RegisterView

@Composable
fun NavManager(loginVM : loginViewModel, registerVM : RegisterViewModel, notesVM : NotesViewModel

){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){

        composable(route = "Login"){
            LoginView(navController, loginVM)
        }

        composable(route = "Register"){
            RegisterView(navController, registerVM)
        }

        composable(route = "Home")
        {
            HomeView(navController, notesVM)
        }
    }

}