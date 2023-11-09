package com.example.android_week12_guided_lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView

class SecondView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_view)

        val swDegreeCert = findViewById (R.id.lifeSwitch) as Switch
        val spnDegree = findViewById<Spinner>(R.id.degreeSpinner)
        val spnCertificate = findViewById<Spinner>(R.id.certsSpinner)
        val txtCertificate = findViewById<TextView>(R.id.cert2)
        val txtDegree = findViewById<TextView>(R.id.deg2)
        val btnNext = findViewById<Button>(R.id.nxtButton)

        val firstName = findViewById<EditText>(R.id.fnEntry)
        val lastName = findViewById<EditText>(R. id. lnEntry)
        val phone = findViewById<EditText>(R.id.pnEntry)
        val spMonth = findViewById<Spinner>(R.id.monthSpin)
        val txtDay = findViewById<EditText>(R.id.dayEntry)
        val txtYear = findViewById<EditText>(R.id.yearEntry)

        firstName.requestFocus()

        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE

                //hide certs
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE

            }else{
                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE

                //appear certs
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
            }



        }


        btnNext.setOnClickListener {
            if(checkData()){
                var doBirth = ""
                doBirth = spMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()

                val nextScreen = Intent(this@SecondView, ChooseClass::class.java)

                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("BirthDate", doBirth)

                if(spnDegree.visibility == View.VISIBLE){
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", spnDegree.selectedItem.toString())
                }else{
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", spnCertificate.selectedItem.toString())
                }
                startActivity(nextScreen)


            }
        }


    }
    private fun checkData():Boolean{

        val firstName = findViewById(R.id.fnEntry) as EditText
        val lastName = findViewById (R. id. lnEntry) as EditText
        val phone = findViewById(R.id.pnEntry) as EditText

        val txtDay = findViewById (R.id.dayEntry) as EditText
        val txtYear = findViewById(R.id.yearEntry) as EditText


        if(firstName.text.toString().isEmpty()){
            //Error
            firstName.error= "Enter First Name"
            firstName.requestFocus()
            return false
        }


        if(lastName.text.toString().isEmpty()){
            //Error
            lastName.error= "Enter Last Name"
            lastName.requestFocus()
            return false
        }

        if(phone.text.toString().isEmpty()){
            //Error
            phone.error= "Enter Phone Number"
            phone.requestFocus()
            return false
        }

        if(txtYear.text.toString().isEmpty()){
            //Error
            txtYear.error= "Enter Valid Year"
            txtYear.requestFocus()
            return false
        }

        if(txtDay.text.toString().isEmpty()){
            //Error
            txtDay.error= "Enter Valid Day"
            txtDay.requestFocus()
            return false
        }




        return true
    }
}