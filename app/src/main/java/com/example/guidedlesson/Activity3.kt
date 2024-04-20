package com.example.guidedlesson

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity3 : AppCompatActivity() {

    private var firstName: String = ""
    private var lastName: String = ""
    private var phone: String = ""
    private var birthDate: String = ""
    private var isDegreeCert: String = ""
    private var degreeCertification: String = ""

    private var ctv1: CheckedTextView? = null
    private var ctv2: CheckedTextView? = null
    private var ctv3: CheckedTextView? = null
    private var ctv4: CheckedTextView? = null

    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var rb4: RadioButton? = null
    private var rb5: RadioButton? = null
    private var rb6: RadioButton? = null
    private var rb7: RadioButton? = null
    private var rb8: RadioButton? = null

    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var rg3: RadioGroup? = null
    private var rg4: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ctv1 = findViewById(R.id.idClassOne_ChTV) // iOS I
        ctv2 = findViewById(R.id.idClassTwo_ChTV) // Android II
        ctv3 = findViewById(R.id.idClassThree_ChTV) // iOS II
        ctv4 = findViewById(R.id.idClassFour_ChTV) // Capstone

        rb1 = findViewById(R.id.idClassOne_RB1)
        rb2 = findViewById(R.id.idClassOne_RB2)
        rb3 = findViewById(R.id.idClassTwo_RB1)
        rb4 = findViewById(R.id.idClassTwo_RB2)
        rb5 = findViewById(R.id.idClassThree_RB1)
        rb6 = findViewById(R.id.idClassThree_RB2)
        rb7 = findViewById(R.id.idClassFour_RB1)
        rb8 = findViewById(R.id.idClassFour_RB2)

        val nxtBTN: Button = findViewById(R.id.idNxtBTN)

        val extras = intent.extras
        if (extras != null) {
            firstName = extras.getString("FirstName").toString()
            lastName = extras.getString("LastName").toString()
            phone = extras.getString("Phone").toString()
            birthDate = extras.getString("BirthDate").toString()
            isDegreeCert = extras.getString("isDegreeCert").toString()
            degreeCertification = extras.getString("degreeCert").toString()
        }

        nxtBTN.setOnClickListener {
            var radioBtn: RadioButton

            var ctv1Text = ""
            var ctv2Text = ""
            var ctv3Text = ""
            var ctv4Text = ""

            var radio1Text = ""
            var radio2Text = ""
            var radio3Text = ""
            var radio4Text = ""

            rg1 = findViewById(R.id.radioGroup)
            rg2 = findViewById(R.id.radioGroup2)
            rg3 = findViewById(R.id.radioGroup3)
            rg4 = findViewById(R.id.radioGroup4)

            var selectedTime1 = 0
            var selectedTime2 = 0
            var selectedTime3 = 0
            var selectedTime4 = 0

            if (ctv1!!.isChecked){
                ctv1Text = ctv1!!.text.toString()

                selectedTime1 = rg1!!.checkedRadioButtonId
                radioBtn = findViewById(selectedTime1)

                radio1Text = radioBtn.text.toString()
            }

            if (ctv2!!.isChecked){
                ctv2Text = ctv2!!.text.toString()

                selectedTime2 = rg2!!.checkedRadioButtonId
                radioBtn = findViewById(selectedTime2)

                radio2Text = radioBtn.text.toString()
            }

            if (ctv3!!.isChecked){
                ctv3Text = ctv3!!.text.toString()

                selectedTime3 = rg3!!.checkedRadioButtonId
                radioBtn = findViewById(selectedTime3)

                radio3Text = radioBtn.text.toString()
            }

            if (ctv4!!.isChecked){
                ctv4Text = ctv4!!.text.toString()

                selectedTime4 = rg4!!.checkedRadioButtonId
                radioBtn = findViewById(selectedTime4)

                radio4Text = radioBtn.text.toString()
            }
            if (radioCheck(selectedTime1, selectedTime2, selectedTime3, selectedTime4)){

                // intent to next screen
                val intent = Intent(this, Activity4::class.java).apply {
                    putExtra("FirstName", firstName)
                    putExtra("LastName", lastName)
                    putExtra("Phone", phone)
                    putExtra("BirthDate", birthDate)
                    putExtra("isDegreeCert", isDegreeCert)
                    putExtra("degreeCert", degreeCertification)
                    putExtra("Class1", ctv1Text)
                    putExtra("Selected1", radio1Text)
                    putExtra("Class2", ctv2Text)
                    putExtra("Selected2", radio2Text)
                    putExtra("Class3", ctv3Text)
                    putExtra("Selected3", radio3Text)
                    putExtra("Class4", ctv4Text)
                    putExtra("Selected4", radio4Text)
                }
                startActivity(intent)

            } else {
                Toast.makeText(applicationContext, "Time Slot Conflict", Toast.LENGTH_LONG).show()
            }
        } // button listener

        rb1!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb2!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb3!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb4!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb5!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb6!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb7!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb8!!.setOnCheckedChangeListener { _, _ ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        ctv1!!.setOnClickListener{
            if (ctv1!!.isChecked){
                enableDisable(ctv1, rb1, rb2, Color.WHITE, false )
            } else{
                enableDisable(ctv1, rb1, rb2, Color.GRAY, true)
            }
        }

        ctv2!!.setOnClickListener{
            if (ctv2!!.isChecked){
                enableDisable(ctv2, rb3, rb4, Color.WHITE, false )
            } else{
                enableDisable(ctv2, rb3, rb4, Color.GRAY, true)
            }
        }

        ctv3!!.setOnClickListener{
            if (ctv3!!.isChecked){
                enableDisable(ctv3, rb5, rb6, Color.WHITE, false )
            } else{
                enableDisable(ctv3, rb5, rb6, Color.GRAY, true)
            }
        }

        ctv4!!.setOnClickListener{
            if (ctv4!!.isChecked){
                enableDisable(ctv4, rb7, rb8, Color.WHITE, false )
            } else{
                enableDisable(ctv4, rb7, rb8, Color.GRAY, true)
            }
        }

    } // onCreate
    private fun radioCheck(
        selectedTime1: Int,
        selectedTime2: Int,
        selectedTime3: Int,
        selectedTime4: Int)
            : Boolean {
        if (selectedTime1 == R.id.idClassOne_RB1 && selectedTime4 == R.id.idClassFour_RB1){
            rb1!!.error = "Time Slot Conflict"
            rb7!!.error = "Time Slot Conflict"
            return false
        }
        if (selectedTime1 == R.id.idClassOne_RB2 && selectedTime2 == R.id.idClassTwo_RB1){
            rb2!!.error = "Time Slot Conflict"
            rb3!!.error = "Time Slot Conflict"
            return false
        }
        if (selectedTime3 == R.id.idClassThree_RB2 && selectedTime4 == R.id.idClassFour_RB2){
            rb6!!.error = "Time Slot Conflict"
            rb8!!.error = "Time Slot Conflict"
            return false
        }
        return true
    } // radioCheck function

    private fun enableDisable(
        ctv: CheckedTextView?,
        rb1: RadioButton?,
        rb2: RadioButton?,
        bgColor: Int?,
        state: Boolean){

        ctv!!.isChecked = state
        ctv.setBackgroundColor(bgColor!!)
        rb1!!.isEnabled = state
        rb2!!.isEnabled = state

        rb1.isChecked = state

        if (!state){
            rb2.isChecked = state
        }
    }
} // activity class