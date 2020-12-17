package com.example.uipart1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.uipart1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TEXT_VIEW_TEXT_KEY = "TEXT_VIEW_TEXT_KEY"
        private const val IMAGE_VIEW_IMAGE_KEY = "IMAGE_VIEW_IMAGE_KEY"
    }
    private var currentImageID = R.drawable.butter_robot_picture

    private val binding: ActivityMainBinding by lazy {
        val tmpBiding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tmpBiding.root)
        tmpBiding
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.button.setOnClickListener {
            if(binding.editText.text.isNotEmpty()) {
                binding.textView.text = "${binding.editText.text}? Oh my God!"
                binding.image.setImageResource(R.drawable.butter_robot_picture_upset)
                currentImageID = R.drawable.butter_robot_picture_upset
            } else {
                R.string.purpose_string.toString()
                binding.image.setImageResource(R.drawable.butter_robot_picture)
                currentImageID = R.drawable.butter_robot_picture
            }
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TEXT_VIEW_TEXT_KEY, binding.textView.text.toString())
        outState.putInt(IMAGE_VIEW_IMAGE_KEY, currentImageID)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.getString(TEXT_VIEW_TEXT_KEY)?.let {
            binding.textView.text = it
        }
        savedInstanceState.getInt(IMAGE_VIEW_IMAGE_KEY).let {
            binding.image.setImageResource(it)
        }
        super.onRestoreInstanceState(savedInstanceState)
    }

}