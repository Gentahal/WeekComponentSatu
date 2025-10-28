package com.example.weekcomponentsatu.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weekcomponentsatu.R
import com.example.weekcomponentsatu.ui.theme.ColorButtonRegister

@Composable
fun FingerPrintStackExample() {
    /**
     * 🧱 Box = stacking layout.
     * Semua elemen di dalam Box akan ditumpuk dari atas ke bawah.
     * Elemen yang ditulis belakangan akan berada di lapisan paling atas.
     */
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(ColorButtonRegister),
        contentAlignment = Alignment.Center // menaruh konten utama (ikon) di tengah
    ) {
        // ✅ 1. Lapisan pertama → background sudah ada di Box (warna oranye)

        // ✅ 2. Lapisan kedua → icon fingerprint di tengah
        Icon(
            painter = painterResource(id = R.drawable.fingerprint),
            contentDescription = "Fingerprint Icon",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )

        // ✅ 3. Lapisan ketiga → lingkaran kecil di pojok kanan atas (badge notifikasi)
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(Color.Red)
                .align(Alignment.TopEnd) // posisikan di kanan atas
                .offset(x = (-6).dp, y = 6.dp) // sedikit ke dalam agar tidak keluar kotak
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FingerPrintStackExamplePreview() {
    FingerPrintStackExample()
}
