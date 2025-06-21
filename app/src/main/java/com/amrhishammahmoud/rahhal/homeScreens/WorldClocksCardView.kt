package com.amrhishammahmoud.rahhal.homeScreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import kotlinx.coroutines.delay
import java.time.ZoneId
import java.time.ZonedDateTime
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun WorldClocksCardViewFun(
    modifier: Modifier = Modifier,
    timeZone: String
) {
    val currentTime = remember { mutableStateOf(ZonedDateTime.now(ZoneId.of(timeZone))) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            currentTime.value = ZonedDateTime.now(ZoneId.of(timeZone))
        }
    }

    val hour = currentTime.value.hour % 12
    val minute = currentTime.value.minute
    val hourAngle = (hour + minute / 60f) * 30f
    val second = currentTime.value.second

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(90.dp)
            .clip(CircleShape)
            .background(Color(0xF28BA6C9).copy(alpha = 0.2f))
            .padding(12.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2

            // ⏱ رسم الأرقام حول الدائرة
            for (i in 1..12) {
                val angle = Math.toRadians((i * 30 - 90).toDouble())
                val numberOffset = Offset(
                    x = center.x + cos(angle).toFloat() * radius * 0.82f,
                    y = center.y + sin(angle).toFloat() * radius * 0.82f
                )
                drawContext.canvas.nativeCanvas.drawText(
                    i.toString(),
                    numberOffset.x,
                    numberOffset.y + 10, // slight vertical adjustment
                    android.graphics.Paint().apply {
                        color = android.graphics.Color.DKGRAY
                        textSize = 24f
                        textAlign = android.graphics.Paint.Align.CENTER
                        isAntiAlias = true
                    }
                )
            }

            // 🕒 عقرب الساعات (دقيق)
            drawLine(
                color = Color.DarkGray,
                start = center,
                end = center + Offset(
                    x = cos(Math.toRadians((hourAngle - 90).toDouble())).toFloat() * radius * 0.5f,
                    y = sin(Math.toRadians((hourAngle - 90).toDouble())).toFloat() * radius * 0.5f
                ),
                strokeWidth = 6f
            )

            // 🕓 عقرب الدقائق
            drawLine(
                color = Color.Gray,
                start = center,
                end = center + Offset(
                    x = cos(Math.toRadians((minute * 6 - 90).toDouble())).toFloat() * radius * 0.7f,
                    y = sin(Math.toRadians((minute * 6 - 90).toDouble())).toFloat() * radius * 0.7f
                ),
                strokeWidth = 4f
            )

            // ⏱ عقرب الثواني
            drawLine(
                color = Color(0xffD57817),
                start = center,
                end = center + Offset(
                    x = cos(Math.toRadians((second * 6 - 90).toDouble())).toFloat() * radius * 0.9f,
                    y = sin(Math.toRadians((second * 6 - 90).toDouble())).toFloat() * radius * 0.9f
                ),
                strokeWidth = 2f
            )

            // ⚪ دائرة مركزية
            drawCircle(color = Color.White, radius = 5f, center = center)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WorldClocksCardViewFunPreview() {
    WorldClocksCardViewFun(
        timeZone = TODO()
    )
}