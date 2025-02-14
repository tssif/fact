package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val number = editTextNumber.text.toString().toIntOrNull()
            if (number != null && number >= 0) {
                val factorial = calculateFactorial(number)
                textViewResult.text = "Факториал $number = $factorial"
            } else {
                textViewResult.text = "Пожалуйста, введите натуральное число."
            }
        }
    }

    private fun calculateFactorial(n: Int): Long {
        return if (n == 0) 1 else n * calculateFactorial(n - 1)
    }
}