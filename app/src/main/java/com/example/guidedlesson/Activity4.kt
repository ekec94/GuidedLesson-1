package com.example.guidedlesson

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.StringBuilder

class Activity4 : AppCompatActivity() {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCert: String? = ""
    private var class1: String? = ""
    private var selected1: String? = ""
    private var class2: String? = ""
    private var selected2: String? = ""
    private var class3: String? = ""
    private var selected3: String? = ""
    private var class4: String? = ""
    private var selected4: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val extras = intent.extras

        if (extras != null) {
            firstName = extras.getString("FirstName")
            lastName = extras.getString("LastName")
            phone = extras.getString("Phone")
            birthDate = extras.getString("BirthDate")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCert = extras.getString("degreeCert")
            class1 = extras.getString("Class1")
            selected1 = extras.getString("Selected1")
            class2 = extras.getString("Class2")
            selected2 = extras.getString("Selected2")
            class3 = extras.getString("Class3")
            selected3 = extras.getString("Selected3")
            class4 = extras.getString("Class4")
            selected4 = extras.getString("Selected4")

            val stuNameTxt: TextView = findViewById(R.id.idStuNameOutput)
            val bdTxt: TextView  = findViewById(R.id.idStuBDayOutput)
            val phoneTxt: TextView = findViewById(R.id.idPhoneOutput)
            val degreeTxt: TextView  = findViewById(R.id.idDegreeOutput)
            val majorTxt: TextView  = findViewById(R.id.idMajorOutput)
            val classScheduleTxt: TextView  = findViewById(R.id.idClassSchedule)

            stuNameTxt.text = "$firstName $lastName"
            bdTxt.text = birthDate
            phoneTxt.text = phone
            degreeTxt.text = isDegreeCert
            majorTxt.text = degreeCert

            val classSchedule = StringBuilder(250)
            if (class1 != ""){
                classSchedule.append("""
                    
                    $class1: $selected1
                    
                """.trimIndent())
            }
            if (class2 != ""){
                classSchedule.append("""
                    
                    $class2: $selected2
                    
                """.trimIndent())
            }
            if (class3 != ""){
                classSchedule.append("""
                    
                    $class3: $selected3
                    
                """.trimIndent())
            }
            if (class4 != ""){
                classSchedule.append("""
                    
                    $class4: $selected4
                    
                """.trimIndent())
            }
            classScheduleTxt.text = classSchedule
        }
    } // onCreate
}