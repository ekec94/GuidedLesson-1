package com.example.guidedlesson

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // define view variables
        // name info
        val firstName: EditText = findViewById(R.id.idFNeditText)
        val lastName: EditText = findViewById(R.id.idLNeditText)

        // phone
        val phone: EditText = findViewById(R.id.idPhoneET)

        // birthday
        val spnMonth: Spinner = findViewById(R.id.idBDmonthSpinner)
        val bdDay: EditText = findViewById(R.id.idBDdayET)
        val bdYear: EditText = findViewById(R.id.idBDyearET)

        // certification or degree info
        val swDegreeCert: Switch = findViewById(R.id.idCert_DegreeSW)
        val lblMajor: TextView = findViewById(R.id.idMajorTV)
        val spnMajor: Spinner = findViewById(R.id.idMajorSpinner)
        val lblCert: TextView = findViewById(R.id.idCertTV)
        val spnCert: Spinner = findViewById(R.id.idCertSpinner)

        // next button
        val nxtBTN: Button = findViewById(R.id.idNxtBtn)

        // set where the user should begin
        firstName.requestFocus()

        // switch listener
        swDegreeCert.setOnCheckedChangeListener {
                buttonView, isChecked ->

            if (isChecked) {
                // show majors for degree spinner
                spnMajor.visibility = View.VISIBLE
                lblMajor.visibility = View.VISIBLE
                // hide certificate option spinner
                spnCert.visibility = View.GONE
                lblCert.visibility = View.GONE
            } else {
                // show certificate option spinner
                spnCert.visibility = View.VISIBLE
                lblCert.visibility = View.VISIBLE
                // hide majors for degree spinner
                spnMajor.visibility = View.GONE
                lblMajor.visibility = View.GONE
            }
        }

        // button listener
        nxtBTN.setOnClickListener {
            if (checkData(
                    firstName, lastName,
                    phone,
                    bdDay, bdYear)
                ) {
                val birthDate: String =
                        spnMonth.selectedItem.toString() + "/" + bdDay.text.toString() + "/" + bdYear.text.toString()

                // next screen
                val intent = Intent(this, Activity3::class.java)

                // initialize what information is being passed to the next screen
                intent.putExtra(
                    "FirstName", firstName.text.toString()
                )
                intent.putExtra(
                    "LastName", lastName.text.toString()
                )
                intent.putExtra(
                    "Phone", phone.text.toString()
                )
                intent.putExtra("BirthDate", birthDate)

                if(spnMajor.visibility == View.VISIBLE){
                    // associates degree
                    intent.putExtra("isDegreeCert", "Degree")
                    intent.putExtra(
                        "degreeCert", spnMajor.selectedItem.toString()
                    )
                } else {
                    // certificate
                    intent.putExtra("isDegreeCert", "Certificate")
                    intent.putExtra(
                        "degreeCert", spnCert.selectedItem.toString()
                    )
                }

                // start activity
                startActivity(intent)

            }
        }
    }

    // verify that information was entered by user
    private fun checkData(
        fName: EditText, lName: EditText,
        phone: EditText,
        bdDay: EditText, bdYear: EditText): Boolean {

        if(fName.text.toString().isEmpty()){
            // error
            fName.error = "Invalid First Name"
            fName.requestFocus()
            return false
        }

        if(lName.text.toString().isEmpty()){
            // error
            lName.error = "Invalid Last Name"
            lName.requestFocus()
            return false
        }

        if(phone.text.toString().isEmpty()){
            // error
            phone.error = "Invalid Phone Number"
            phone.requestFocus()
            return false
        }

        if(bdDay.text.toString().isEmpty()){
            // error
            bdDay.error = "Invalid Birth Day"
            bdDay.requestFocus()
            return false
        }

        if(bdYear.text.toString().isEmpty()){
            // error
            bdYear.error = "Invalid Birth Year"
            bdYear.requestFocus()
            return false
        }

        return true
    }
}