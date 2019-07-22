package com.bakan.circlecitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val helloProcessor by lazy { HelloProcessor() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            helloProcessor.sayHello(name.text.toString())?.let { hello ->
                Snackbar.make(view, hello, Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
