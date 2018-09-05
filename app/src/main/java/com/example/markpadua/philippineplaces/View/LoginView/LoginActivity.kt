package com.example.markpadua.philippineplaces.View.LoginView

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.markpadua.philippineplaces.R
import kotlinx.android.synthetic.main.activity_login.*
import com.example.markpadua.philippineplaces.Contract.LoginContract.ILoginView
import com.example.markpadua.philippineplaces.Presenter.LoginPresenters.LoginPresenter
import com.example.markpadua.philippineplaces.View.RetroView.RetroActivity

open class  LoginActivity : AppCompatActivity(), ILoginView {



    private lateinit var loginView : LoginPresenter

    override fun loginsuccess() {
        Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()
        val nintent = Intent(this,RetroActivity::class.java)
        startActivity(nintent)


    }

    override fun loginfailed() {
        Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginView = LoginPresenter()
        loginView.setView(this)

        bt_Login.setOnClickListener{

            loginView.login(et_Username.text.toString(),et_Password.text.toString())
        }



    }


}
