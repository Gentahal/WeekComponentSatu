package com.example.weekcomponentsatu.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
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
fun FingerPrintButton(
    onClick: () -> Unit // aksi ketika tombol ditekan
) {
    // Box digunakan untuk menempatkan satu komponen di tengah
    Box(
        modifier = Modifier
            .size(80.dp) // ukuran kotak
            .clip(RoundedCornerShape(16.dp)) // ujung kotak melengkung
            .background(ColorButtonRegister) // warna tombol
            .clickable { onClick() }, // aksi klik
        contentAlignment = Alignment.Center // isi di tengah
    ) {
        // Icon fingerprint di tengah box
        Icon(
            painter = painterResource(id = R.drawable.fingerprint),
            contentDescription = "Fingerprint Icon",
            tint = Color.White, // warna putih
            modifier = Modifier.size(48.dp)
        )
    }
}

// Preview untuk menampilkan tampilan tombol di Android Studio
@Preview(showBackground = true)
@Composable
private fun FingerPrintButtonPreview() {
    FingerPrintButton(onClick = {})
}
