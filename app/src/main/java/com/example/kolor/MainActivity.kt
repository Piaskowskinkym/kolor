package com.example.kolor

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var red = findViewById<ToggleButton>(R.id.tBred)
        var blue = findViewById<ToggleButton>(R.id.tBblue)
        var green = findViewById<ToggleButton>(R.id.tBgreen)
        var image = findViewById<ImageView>(R.id.iVork)
        
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.pobrane)
        val bitmapCzerwony = BitmapFactory.decodeResource(resources, R.drawable.czerwony)
        val bitmapNiebieski = BitmapFactory.decodeResource(resources,R.drawable.blue)
        val filterBitmap = Bitmap.createBitmap(bitmap.width,bitmap.height,Bitmap.Config.ARGB_8888)

      /*  red.setOnClickListener {
            val paint = Paint()
            paint.alpha = 100
            val canvas = Canvas(filterBitmap)
            canvas.drawARGB(0,0,0,0)
            canvas.drawBitmap(bitmapCzerwony, null, RectF(0f,0f,bitmap.width.toFloat(),bitmap.height.toFloat()),paint)
            canvas.drawBitmap(bitmap,0f,0f,paint)
            image.setImageBitmap(filterBitmap)
        }*/
        red.setOnCheckedChangeListener { _, isChecked ->
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
        blue.setOnCheckedChangeListener { _, isChecked ->
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

}