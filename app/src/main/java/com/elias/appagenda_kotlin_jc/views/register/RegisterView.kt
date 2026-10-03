package com.elias.appagenda_kotlin_jc.views.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.elias.appagenda_kotlin_jc.R
import com.elias.appagenda_kotlin_jc.viewModels.RegisterViewModel

@Composable
fun RegisterView(navController: NavController, registerVM: RegisterViewModel){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Tres variables
        var email by remember { mutableStateOf(value = "") } //email
        var password by remember { mutableStateOf(value = "") } // password
        var username by remember { mutableStateOf(value = "") } // password

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Registro de Usuario",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp)

        Image(
            modifier = Modifier.height(150.dp).width(150.dp).padding(all = 15.dp),
            painter = painterResource(id = R.drawable.registro),
            contentDescription = "Logo de Registro")

        //CAMPO USERNAME
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label ={Text("Usename")},
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp))

        //CAMPO EMAIL
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label ={Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp))

        //CAMPO PASSWORD
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label ={Text("Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp))

        Spacer(modifier = Modifier.height(20.dp))

        // BOTON DE REGISTRO
        Button(onClick = {registerVM.createUser(username, email, password = password)
        {navController.navigate(route = "Home")} },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp))
        {
            Text(text = "Registrar")
        }

    }
}