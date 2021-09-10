package com.example.foodorderapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    /*Declaring the variable used for this activity*/
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var btnRegister: Button
    lateinit var etName: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etPassword: EditText
    lateinit var etEmail: EditText
    lateinit var etAddress: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var rlRegister: RelativeLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Linking the view*/
        setContentView(R.layout.activity_register)

        /*Initialising the toolbar and setting according our requirement*/
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Register Yourself"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        /*Initialising the views with the ones defined in the XML*/

        rlRegister = findViewById(R.id.rlRegister)
        etName = findViewById(R.id.etName)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etAddress = findViewById(R.id.etAddress)
        btnRegister = findViewById(R.id.btnRegister)

        /*Handling the click on the button using the setOnClickListener method */
        btnRegister.setOnClickListener {

            /*Declaring the intent which sets up the route for the navigation of the activity*/
            val intent = Intent(this@RegisterActivity, DashboardActivity::class.java)

            /*Declaring the bundle object which will carry the data*/
            val bundle = Bundle()

            /*Setting a value data which is activity specific. This will be used to identify from where the data was sent*/
            bundle.putString("data", "register")

            /*Putting the values in Bundle*/
            bundle.putString("name", etName.text.toString())
            bundle.putString("mobile", etPhoneNumber.text.toString())
            bundle.putString("password", etPassword.text.toString())
            bundle.putString("address", etAddress.text.toString())

            /*Putting the Bundle to be shipped with the intent*/
            intent.putExtra("details", bundle)

            /*Starting the new activity by sending the intent in the startActivity method*/
            startActivity(intent)

        }

    }


    /*setting onBackPressed() for back button*/

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}