
package com.blackout.assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Black = Color(0xFF090A0C)
private val Panel = Color(0xFF15171B)
private val Red = Color(0xFFB51F2B)
private val White = Color(0xFFECECEC)
private val Muted = Color(0xFF858991)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BlackoutApp()
        }
    }
}

@Composable
fun BlackoutApp() {
    var online by remember { mutableStateOf(false) }
    var selectedMode by remember { mutableStateOf("STREET") }

    val modes = listOf("STREET", "GHOST", "REDLINE", "GARAGE")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "BLACKOUT",
                        color = White,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 3.sp
                    )
                    Text(
                        "PERSONAL INTELLIGENCE SYSTEM",
                        color = Muted,
                        fontSize = 9.sp,
                        letterSpacing = 2.sp
                    )
                }

                Text(
                    "V0.1",
                    color = Red,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            Box(
                modifier = Modifier
                    .size(190.dp)
                    .border(2.dp, Red, RoundedCornerShape(100.dp))
                    .padding(10.dp)
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(100.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "B",
                        color = White,
                        fontSize = 76.sp,
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        "SYSTEM CORE",
                        color = Red,
                        fontSize = 9.sp,
                        letterSpacing = 3.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                if (online) "SYSTEM INITIALIZED" else "SYSTEM STANDBY",
                color = if (online) Red else Muted,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                if (online) "BLACKOUT online. Awaiting orders."
                else "All systems ready. Awaiting ignition.",
                color = White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { online = !online },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red,
                    contentColor = White
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Text(
                    if (online) "SHUT DOWN SYSTEM" else "INITIALIZE BLACKOUT",
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(34.dp))

            Text(
                "OPERATIONAL MODES",
                color = Muted,
                fontSize = 11.sp,
                letterSpacing = 2.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(12.dp))

            modes.forEach { mode ->
                val active = selectedMode == mode

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .background(
                            if (active) Color(0xFF291316) else Panel,
                            RoundedCornerShape(8.dp)
                        )
                        .border(
                            1.dp,
                            if (active) Red else Color(0xFF292C32),
                            RoundedCornerShape(8.dp)
                        )
                        .clickable { selectedMode = mode }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        if (active) "●" else "○",
                        color = if (active) Red else Muted,
                        fontSize = 15.sp
                    )

                    Spacer(modifier = Modifier.width(14.dp))

                    Text(
                        mode,
                        color = White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        when (mode) {
                            "STREET" -> "EVERYDAY"
                            "GHOST" -> "DISCREET"
                            "REDLINE" -> "ADVANCED"
                            else -> "AUTOMOTIVE"
                        },
                        color = Muted,
                        fontSize = 9.sp
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "BLACKOUT // BUILT DIFFERENT",
                color = Color(0xFF555960),
                fontSize = 9.sp,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}
