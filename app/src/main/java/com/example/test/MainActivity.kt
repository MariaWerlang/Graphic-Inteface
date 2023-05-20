package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.ui.theme.TestTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var minhaViewModelQueEuCrieiAgoraPouco : MinhaViewModelBemSimples

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        minhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewModelBemSimples::class.java)

        setContent {
            Main(minhaViewModelQueEuCrieiAgoraPouco)
        }
    }
}

/*
@Composable
fun Main(){
    TestTheme {
        Column(modifier = Modifier.fillMaxSize().background(color = Color.Cyan)) {
            MinhaSaudacao("SÁBADO",
                "ANIMADO",
                modificador = Modifier
                    .border(
                        border = BorderStroke(
                            width = 5.dp,
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color.Red, Color.Blue)
                            )
                        ),
                    shape = MaterialTheme.shapes.medium
                    )
                    .padding(16.dp))
            Greeting("Android")
            MinhaSaudacao("SÁBADO","ANIMADO",
                modificador = Modifier
                    .border(border = BorderStroke(
                        width = 5.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Red, Color.Blue)
                        )
                    ),
                    shape = MaterialTheme.shapes.medium
                    )
                    .padding(16.dp)
                    )
            Greeting("Android")
        }
    }
}

@Composable
fun MinhaSaudacao(nomeX: String = "WORLD", adjetivoDoNomeX: String, modificador: Modifier){
    Text(text = "HELLO $nomeX $adjetivoDoNomeX!", modifier = modificador)
}

@Composable
fun Greeting(name: String, modificador: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modificador
    )
}*/

@Composable
fun Main(umaViewModel: MinhaViewModelBemSimples){

    //responsável por mostrar os números nas próximas telas
    var contadorNaView by remember {
        mutableStateOf(0)
    }

    val contadorProvenienteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()

    Column() {
        Button(onClick = {
            contadorNaView = contadorNaView + 1
            umaViewModel.incrementaContador()
            //Log.i("NOSSA_LOG", "Valor do Contador $contador")
        }) {
            Text(text = "INCREMENTAR CONTADOR")
        }
        Button(onClick = {
            contadorNaView = contadorNaView - 1
            //Log.i("NOSSA_LOG", "Valor do Contador $contador")
        }) {
            Text(text = "DECREMENTAR CONTADOR")
        }
        Text(text = "Valor do Contador Controlado pela View = $contadorNaView")
        Text(text = "Valor do Contador Controlado pela ViewModel = $contadorProvenienteDaMinhaModelView")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}