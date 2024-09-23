package com.example.memphisdeapp.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.memphisdeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CorinthiansScreen(viewModel: CorinthiansViewModel) {
    var tecnico by remember { mutableStateOf("") }
    var ataque by remember { mutableStateOf("") }
    var meio by remember { mutableStateOf("") }
    var defesa by remember { mutableStateOf("") }
    var ano by remember { mutableStateOf("") }
    var selectedTimeId by remember { mutableStateOf<Int?>(null) }

    val timeList by viewModel.timeList.collectAsState(initial = emptyList())

    val isFormValid = tecnico.isNotBlank() && ataque.isNotBlank() && meio.isNotBlank() && defesa.isNotBlank() && ano.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color(0xFFFFFFFF), Color(0xFF000000)))) // Gradiente Azul e Vermelho
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.background(Color.White.copy(alpha = 0.9f), RoundedCornerShape(16.dp)) // Fundo branco translúcido
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Escale o Timão",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB71C1C),
                    fontSize = 28.sp
                )
            )

            TextField(
                value = tecnico,
                onValueChange = { tecnico = it },
                label = { Text("Técnico", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = ataque,
                onValueChange = { ataque = it },
                label = { Text("Ataque", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = meio,
                onValueChange = { meio = it },
                label = { Text("Meio-Campo", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = defesa,
                onValueChange = { defesa = it },
                label = { Text("Defesa", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = ano,
                onValueChange = { ano = it },
                label = { Text("Ano", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Button(
                onClick = {
                    if (isFormValid) {
                        viewModel.addOrUpdateSpider(selectedTimeId, tecnico, ataque, meio, defesa, ano.toIntOrNull() ?: 1)
                        tecnico = ""
                        ataque = ""
                        meio = ""
                        defesa = ""
                        ano = ""
                        selectedTimeId = null
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB71C1C), disabledContainerColor = Color(0xFFB71C1C).copy(alpha = 0.5f)),
                enabled = isFormValid
            ) {
                Text(if (selectedTimeId == null) "Criar Equipe" else "Atualizar Equipe", color = Color.White)
            }

            Text("Equipes salvas:", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFFB71C1C)))

            LazyColumn (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(timeList) { time ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Técnico: ${time.tecnico}", color = Color.Black)
                            Text(text = "Ataque: ${time.ataque}", color = Color.Black)
                            Text(text = "Meio-Campo: ${time.meio}", color = Color.Black)
                            Text(text = "Defesa: ${time.defesa}", color = Color.Black)
                            Text(text = "Ano: ${time.ano}", color = Color.Black)
                        }

                        Row {
                            // Botão de editar
                            IconButton(onClick = {
                                tecnico = time.tecnico
                                ataque = time.ataque
                                meio = time.meio
                                defesa = time.defesa
                                ano = time.ano.toString()
                                selectedTimeId = time.id
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    modifier = Modifier.size(32.dp),
                                    contentDescription = "Editar Equipe",
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        IconButton(onClick = { viewModel.deleteSpider(time) }) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                modifier = Modifier.size(32.dp),
                                contentDescription = "Excluir Equipe",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}
