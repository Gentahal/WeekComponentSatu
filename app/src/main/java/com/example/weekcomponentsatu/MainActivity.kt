package com.example.weekcomponentsatu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.weekcomponentsatu.ui.login.LoginScreen
import com.example.weekcomponentsatu.ui.theme.WeekComponentSatuTheme

// Activity utama aplikasi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengaktifkan tampilan edge-to-edge (layar penuh)
        enableEdgeToEdge()

        // Menentukan konten utama aplikasi menggunakan Compose
        setContent {
            // Menerapkan tema global dari project
            WeekComponentSatuTheme {
                // Menampilkan layar login
                LoginScreen()
            }
        }
    }
}
