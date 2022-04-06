package com.example.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener(View.OnClickListener { rollDice() })
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceImage: ImageView = findViewById(R.id.value)

        val drawable = when(dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawable)
        diceImage.contentDescription = dice.roll().toString()
    }
}

class Dice(val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }
}