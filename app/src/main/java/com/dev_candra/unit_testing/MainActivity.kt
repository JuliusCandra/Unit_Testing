package com.dev_candra.unit_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var mainViewModel: MainViewModel

    private lateinit var editWidth : EditText
    private lateinit var editLength : EditText
    private lateinit var editHeight : EditText
    private lateinit var tvResult : TextView
    private lateinit var btnCalculateVolume : Button
    private lateinit var btnCalculateSurfaceArea : Button
    private lateinit var btnCalculateCircumference : Button
    private lateinit var btnSave : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboiModel())
        editWidth = findViewById(R.id.EditWidth)
        editLength = findViewById(R.id.EditLength)
        editHeight = findViewById(R.id.EditHeight)
        tvResult = findViewById(R.id.tv_result)
        btnCalculateCircumference = findViewById(R.id.bnt_calculate_circumference)
        btnCalculateSurfaceArea = findViewById(R.id.bnt_calculate_surface_area)
        btnCalculateVolume = findViewById(R.id.bnt_calculate_volume)
        btnSave = findViewById(R.id.btnSave)
        initWidget()
    }
    
    private fun initWidget(){
        btnSave.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateCircumference.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = editLength.text.toString().trim()
        val width = editWidth.text.toString().trim()
        val height = editHeight.text.toString().trim()

        when {
            length.isEmpty() -> editLength.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> editWidth.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> editHeight.error = "Field ini tidak boleh kosong"
            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()

                when (v?.id) {
                    R.id.btnSave -> {
                        mainViewModel.save(l,w,h)
                        visible()
                    }
                    R.id.bnt_calculate_volume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                    R.id.bnt_calculate_circumference -> {
                        tvResult.text = mainViewModel.getCicumference().toString()
                        gone()
                    }
                    R.id.bnt_calculate_surface_area -> {
                        tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible(){
        btnCalculateCircumference.visibility = View.VISIBLE
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone(){
        btnCalculateVolume.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnCalculateCircumference.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}