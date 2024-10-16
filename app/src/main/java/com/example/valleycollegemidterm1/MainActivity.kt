package com.example.valleycollegemidterm1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toastButton = findViewById<Button>(R.id.makeToast)
        toastButton.setOnClickListener {
            val text = getString(R.string.hello_sbvc)
            val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
            toast.show()
        }

        val mailButton = findViewById<Button>(R.id.junkMail)
        mailButton.setOnClickListener {
            intent = Intent(/* action = */ Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, "cire.ttalp@gmail.com")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                println(getString(R.string.failed_to_resolveactivity_for_email))
            }
        }

        val viewHomepage = findViewById<Button>(R.id.viewHomepage)
        viewHomepage.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.valleycollege.edu")
            }
            startActivity(intent)
        }
    }
}