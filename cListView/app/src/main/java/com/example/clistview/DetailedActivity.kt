package com.example.clistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DetailedActivity : AppCompatActivity() {
    private lateinit var countryName: TextView
    private lateinit var countryImage: ImageView
    private lateinit var countryDetails: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        countryName = findViewById(R.id.countryName)
        countryImage = findViewById(R.id.countryImage)
        countryDetails = findViewById(R.id.countryDetails)

        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val image = intent.getIntExtra("image", R.drawable.bangladesh_img)
            val desc = intent.getIntExtra("desc", R.string.IndiaDetails)
            countryName.text = name
            countryImage.setImageResource(image)
          countryDetails.setText(desc)
        }
    }
}
