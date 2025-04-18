package com.simats.harvesthaven

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LandCalculatorActivity : AppCompatActivity() {

    private lateinit var inputLength: EditText
    private lateinit var inputWidth: EditText
    private lateinit var unitGroup: RadioGroup
    private lateinit var btnCalculate: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landcalculator_activity)

        inputLength = findViewById(R.id.inputLength)
        inputWidth = findViewById(R.id.inputWidth)
        unitGroup = findViewById(R.id.unitGroup)
        btnCalculate = findViewById(R.id.btnCalculate)
        resultText = findViewById(R.id.resultText)

        btnCalculate.setOnClickListener {
            calculateArea()
        }
    }

    private fun calculateArea() {
        val lengthStr = inputLength.text.toString()
        val widthStr = inputWidth.text.toString()

        if (lengthStr.isEmpty() || widthStr.isEmpty()) {
            Toast.makeText(this, "Please enter both length and width", Toast.LENGTH_SHORT).show()
            return
        }

        val length = lengthStr.toFloat()
        val width = widthStr.toFloat()
        val areaInSqMeters = length * width

        val selectedUnitId = unitGroup.checkedRadioButtonId
        if (selectedUnitId == -1) {
            Toast.makeText(this, "Please select a unit", Toast.LENGTH_SHORT).show()
            return
        }

        val (convertedArea, unitLabel) = when (selectedUnitId) {
            R.id.rbAcres -> Pair(areaInSqMeters * 0.000247105f, "Acres")
            R.id.rbHectares -> Pair(areaInSqMeters * 0.0001f, "Hectares")
            R.id.rbSqft -> Pair(areaInSqMeters * 10.7639f, "Sq Ft")
            else -> Pair(areaInSqMeters, "Sq Meters")
        }

        resultText.text = "Area: %.2f $unitLabel".format(convertedArea)
        resultText.visibility = View.VISIBLE
    }
}
