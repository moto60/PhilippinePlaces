package com.example.markpadua.philippineplaces.View.RetroView

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.markpadua.philippineplaces.R
import com.example.markpadua.philippineplaces.Contract.RetroContract.IListListener
import com.example.markpadua.philippineplaces.Model.places
import com.example.markpadua.philippineplaces.Presenter.RetroPresenters.RetroPresenter
import com.example.markpadua.philippineplaces.Contract.IRetroView
import com.example.markpadua.philippineplaces.View.LoginView.LoginActivity

class RetroActivity : LoginActivity(), IRetroView, IListListener {




    private var loading: ProgressDialog? = null
    private var recyclerView: RecyclerView? = null
    private var eAdapter: placeAdapter? = null
    private lateinit var loginView : RetroPresenter
    private var progressStatus = 0
    private val handler = Handler()



    override fun onNavClick(lat: String?, long: String?, name: String?) {

        val gmmIntentUri = Uri.parse("http://maps.google.com/maps?q=loc:$lat,$long($name)")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }

    }


    override fun onCallClick(phone: String?) {

        val mintent = Intent(Intent.ACTION_DIAL);
        mintent.data = Uri.parse("tel:$phone")
        startActivity(mintent)

    }


    override fun onEmailClick(email: String?) {

        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:$email")
        startActivity(emailIntent)

    }


    override fun onFailed() {

        loading?.dismiss()

    }


    override fun response(placelist: ArrayList<places>?) {

        recyclerView = findViewById(R.id.recyclerView)
        eAdapter = placeAdapter(placelist!!, this)
        val eLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = eLayoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?
        recyclerView?.adapter = eAdapter
        eAdapter!!.notifyDataSetChanged()

    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro)
        prog()
        loginView = RetroPresenter()
        loginView.setView(this)
        loginView.jsons()

    }
    fun prog(){

        val pd = ProgressDialog(this)
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        // Set the progress dialog title and message
        pd.setTitle("API is loading please wait.")
        pd.setMessage("Loading.........")
        // Set the progress dialog background color
        pd.getWindow().setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFD4D9D0")))
        pd.setIndeterminate(false)
        // Finally, show the progress dialog
        pd.show()
        // Set the progress status zero on each button click
        progressStatus = 0
        // Start the lengthy operation in a background thread
        Thread(object:Runnable {
            public override fun run() {
                while (progressStatus < 40)
                {
                    // Update the progress status
                    progressStatus += 2
                    // Try to sleep the thread for 20 milliseconds
                    try
                    {
                        Thread.sleep(250)
                    }
                    catch (e:InterruptedException) {
                        e.printStackTrace()
                    }
                    // Update the progress bar
                    handler.post(object:Runnable {
                        public override fun run() {
                            // Update the progress status
                            pd.setProgress(progressStatus)
                            // If task execution completed
                            if (progressStatus == 40)
                            {
                                // Dismiss/hide the progress dialog
                                pd.dismiss()



                            }
                        }
                    })
                }
            }
        }).start() // Start the operation
    }


}
