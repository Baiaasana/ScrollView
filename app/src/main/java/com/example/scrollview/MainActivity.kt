package com.example.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.scrollview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddField.setOnClickListener {

            if (checkIfFieldIsEmpty()) {
                Toast.makeText(this, getString(R.string.empty_field_toast), Toast.LENGTH_SHORT)
                    .show()
            } else {

//                val scrollView = ScrollView(this)
//                val layoutParams = LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT)
//                scrollView.layoutParams = layoutParams
//
//                val linearLayout1 = LinearLayout(this)
//                val linearParams1 = LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT)
//                linearLayout.orientation = LinearLayout.VERTICAL
//                linearLayout.layoutParams = linearParams1
//                scrollView.addView(linearLayout)

                val newField = AppCompatEditText(this)
                val scrollView = binding.mainActivityLayout
                val layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                if (binding.checkBox.isChecked) {
                    newField.inputType = InputType.TYPE_CLASS_NUMBER
                    newField.hint = "${binding.edtFieldValue.text} - Numeric field"
                    scrollView.addView(newField, layoutParams)
                    fieldClear()
                } else {
                    newField.inputType = InputType.TYPE_CLASS_TEXT
                    newField.hint = "${binding.edtFieldValue.text} - Text field"
                    scrollView.addView(newField, layoutParams)
                    fieldClear()
                }
            }
        }
    }

    private fun checkIfFieldIsEmpty(): Boolean = with(binding) {

        if (binding.edtFieldValue.text.toString().isEmpty()) {
            return@with true
        }
        return@with false
    }

    private fun fieldClear() {
        binding.edtFieldValue.text?.clear()
    }


}