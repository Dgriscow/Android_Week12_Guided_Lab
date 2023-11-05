package com.example.android_week12_guided_lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginState
        constructor(val code:Int){
            login(1),
            password(2),
            success(0),

        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginEntry = findViewById<TextView>(R.id.userNameEntry)
        val passwordEntry = findViewById<TextView>(R.id.passwordEntry)

        val loginButton = findViewById<Button>(R.id.goLogin)



        //When goLogin is pressed, do the following
        loginButton.setOnClickListener {
            when(check_login(loginEntry.text.toString(), passwordEntry.text.toString())){
                LoginState.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_LONG).show()
                    loginEntry.requestFocus()
                }

                LoginState.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errPass), Toast.LENGTH_LONG).show()
                    loginEntry.requestFocus()

                }
                else ->{
                    Toast.makeText(applicationContext, "Success!", Toast.LENGTH_LONG).show()

                }
            }
        }


    }

    fun check_login(username:String, password:String):LoginState{
        val adminLogin = "DevinTAG"
        val adminPassword = "10112002"


        return if (username != adminLogin){
            LoginState.login
        }else if(password != adminPassword){
            LoginState.password
        }else{
            LoginState.success
        }

    }
}