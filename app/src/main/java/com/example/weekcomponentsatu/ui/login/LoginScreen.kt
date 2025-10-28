package com.example.weekcomponentsatu.ui.login

// Import komponen UI yang dibutuhkan
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weekcomponentsatu.ui.theme.playwriteUsModern
import com.example.weekcomponentsatu.R
import com.example.weekcomponentsatu.ui.theme.ColorButtonRegister

@Composable
@Preview
fun LoginScreen() {
    // Mendapatkan context untuk menampilkan Toast
    val context = LocalContext.current

    // Layout utama berbentuk kolom (vertikal)
    Column(
        modifier = Modifier
            .fillMaxSize() // memenuhi seluruh layar
            .background(Color(0xFFFFFFFF)) // warna putih
            .systemBarsPadding() // agar tidak tertutup status bar
            .padding(16.dp), // jarak dari tepi
        verticalArrangement = Arrangement.Center, // isi di tengah vertikal
        horizontalAlignment = Alignment.CenterHorizontally // isi di tengah horizontal
    ) {
        // State untuk input username dan password
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) } // belum digunakan

        // Data dummy username & password
        val users = mapOf(
            "admin" to "admin",
            "member" to "member"
        )

        // Judul Aplikasi
        Text(
            text = "Motion Lab",
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
            fontFamily = playwriteUsModern
        )

        Spacer(Modifier.height(64.dp)) // jarak vertikal

        // Gambar logo
        Image(
            painter = painterResource(R.drawable.img_motion),
            contentDescription = "Logo Motion Lab",
            modifier = Modifier.size(256.dp)
        )

        Spacer(Modifier.height(64.dp))

        // Input Username
        TextField(
            value = username,
            onValueChange = { value -> username = value },
            label = { Text("username anda") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        // Input Password
        TextField(
            value = password,
            onValueChange = { value -> password = value },
            label = { Text("password anda") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(64.dp))

        // Baris untuk tombol Login dan Fingerprint
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tombol Login
            Button(
                onClick = {
                    // Logika login sederhana
                    if (username in users && password == users[username]) {
                        Toast.makeText(context, "Welcome $username 👋", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorButtonRegister, // warna tombol
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .weight(1f) // agar tombol memenuhi ruang yang tersisa
                    .height(50.dp)
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }

            Spacer(Modifier.width(8.dp))

            // Tombol Fingerprint
            FingerPrintButton(
                onClick = {
                    Toast.makeText(context, "Finger Print di coba", Toast.LENGTH_SHORT).show()
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Teks navigasi ke halaman Register
        Text(
            text = "Belum punya akun? Register",
            color = Color(0xFF007BFF),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.clickable {
                Toast.makeText(context, "Navigating to Register...", Toast.LENGTH_SHORT).show()
            }
        )
    }
}
