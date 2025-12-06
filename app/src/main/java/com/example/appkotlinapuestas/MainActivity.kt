package com.example.appkotlinapuestas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { // Aquí defines toda la interfaz de usuario con Jetpack Compose.
            MaterialTheme {
                val navController = rememberNavController() // Crea y recuerda un NavController, que es el objeto que gestiona la navegación entre pantallas
                NavHost( // Define el contenedor de navegacion
                    navController = navController,
                    startDestination = "principal" // indica la primera pantalla
                ) {
                    composable("principal") { PantallaPrincipal(navController) } // crea pantalla 1
                    composable("segunda") { PantallaSecundaria(navController) } // crea pantalla 2
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(navController: NavController) { //recibe el NavController, el objeto que gestiona la navegación entre pantallas.

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) { // Organiza los elementos en una columna vertical.
        Text("Pantalla Principal")
        Button(onClick = { navController.navigate("segunda") }) { // Crea un botón, al pulsarlo, se ejecuta la navegación hacia la ruta "segunda", que corresponde a la pantalla secundaria definida en tu NavHost

            Text("Ir a segunda pantalla")
        }
    }
}

@Composable
fun PantallaSecundaria(navController: NavController) { //recibe el NavController, el objeto que gestiona la navegación entre pantallas.
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Pantalla Secundaria")
        Button(onClick = { navController.popBackStack() }) { // Crea un botón, al pulsarlo, se ejecuta popBackStack(), que retrocede a la pantalla anterior en la pila de navegación.

            Text("Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}