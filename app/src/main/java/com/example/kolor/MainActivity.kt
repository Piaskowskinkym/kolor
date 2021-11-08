package com.example.kolor

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var red = findViewById<ToggleButton>(R.id.tBred)
        var blue = findViewById<ToggleButton>(R.id.tBblue)
        var green = findViewById<ToggleButton>(R.id.tBgreen)
        var image = findViewById<ImageView>(R.id.iVork)
        var text = findViewById<TextView>(R.id.tVkontrolny)
        
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.pobrane)
        val bitmapCzerwony = BitmapFactory.decodeResource(resources, R.drawable.czerwony)
        val bitmapNiebieski = BitmapFactory.decodeResource(resources,R.drawable.blue)
        val bitmapZielony = BitmapFactory.decodeResource(resources,R.drawable.green)
        val filterBitmap = Bitmap.createBitmap(bitmap.width,bitmap.height,Bitmap.Config.ARGB_8888)


        red.setOnCheckedChangeListener { _, isChecked ->
            if (blue.isChecked || green.isChecked) {
                text.text = " Odznacz niebieski lub zielony!"
            } else {
                if (isChecked) {
                    val paint = Paint()
                    paint.alpha = 100
                    val canvas = Canvas(filterBitmap)
                    canvas.drawARGB(0, 0, 0, 0)
                    canvas.drawBitmap(
                        bitmapCzerwony,
                        null,
                        RectF(0f, 0f, bitmap.width.toFloat(), bitmap.height.toFloat()),
                        paint
                    )
                    canvas.drawBitmap(bitmap, 0f, 0f, paint)
                    image.setImageBitmap(filterBitmap)
                } else {
                    image.setImageBitmap(bitmap)
                }
            }
        }
        blue.setOnCheckedChangeListener { _, isChecked ->
            if (red.isChecked || green.isChecked) {
                text.text = " Odznacz czerwony lub zielony!"
            } else {
                if (isChecked) {
                    val paint = Paint()
                    paint.alpha = 100
                    val canvas = Canvas(filterBitmap)
                    canvas.drawARGB(0, 0, 0, 0)
                    canvas.drawBitmap(
                        bitmapNiebieski,
                        null,
                        RectF(0f, 0f, bitmap.width.toFloat(), bitmap.height.toFloat()),
                        paint
                    )
                    canvas.drawBitmap(bitmap, 0f, 0f, paint)
                    image.setImageBitmap(filterBitmap)
                } else {
                    image.setImageBitmap(bitmap)
                }

            }
        }
        green.setOnCheckedChangeListener { _, isChecked ->
            if (red.isChecked || blue.isChecked) {
                text.text = " Odznacz czerwony lub niebieski!"
            } else {
                if (isChecked) {
                    val paint = Paint()
                    paint.alpha = 100
                    val canvas = Canvas(filterBitmap)
                    canvas.drawARGB(0, 0, 0, 0)
                    canvas.drawBitmap(
                        bitmapZielony,
                        null,
                        RectF(0f, 0f, bitmap.width.toFloat(), bitmap.height.toFloat()),
                        paint
                    )
                    canvas.drawBitmap(bitmap, 0f, 0f, paint)
                    image.setImageBitmap(filterBitmap)
                } else {
                    image.setImageBitmap(bitmap)
                }

            }
        }
    }

}