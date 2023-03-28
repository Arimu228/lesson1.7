package com.example.lesson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lesson17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val data = arrayListOf(
        "https://img1.akspic.ru/previews/1/4/7/1/7/171741/171741-melodramaticheskij-noch-nizkij_ugol_vystrel-didzhej_nial_rmx-4_sekavan_h_aki_aki_remiks-x750.jpg",
        "https://img2.akspic.ru/previews/1/4/5/1/7/171541/171541-noch-zvezda-android-atmosfera-zelenyj-x750.jpg",
        "https://img3.akspic.ru/previews/6/0/7/6/6/166706/166706-priroda-voda-oblako-atmosfera-svet-x750.jpg",
        "https://img3.akspic.ru/previews/1/0/5/6/6/166501/166501-mikael_gustafsson_malenkaya_pamyat-oblako-rastenie-atmosfera-voda-x750.jpg"
    )
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
    }


    private fun listener() {

        binding.submitButton.setOnClickListener {
            if ( binding.mainEditText.text.isNotEmpty()&& Patterns.WEB_URL.matcher(binding.mainEditText.text.toString()).matches()){
                data.add(binding.mainEditText.text.toString())
                Toast.makeText(this, getString(R.string.valid), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, getString(R.string.invalid), Toast.LENGTH_SHORT).show()
            }
            binding.mainEditText.text.clear()
        }
        binding.randomButton.setOnClickListener {
            Glide.with(this).load(data.random()).into(binding.mainImageView)
        }
    }



}