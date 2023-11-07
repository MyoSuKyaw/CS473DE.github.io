package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var editTextVersion: EditText
    private lateinit var editTextCodeName: EditText
    private lateinit var addButton: Button
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextVersion = findViewById(R.id.editTextVersion)
        editTextCodeName = findViewById(R.id.editTextCodeName)
        addButton = findViewById(R.id.addButton)
        tableLayout = findViewById(R.id.tableLayout)

        // Add two static rows to the table
        addStaticRow("Android Version", "Code Name")
        addStaticRow("Android 12", "Snow Cone")

        addButton.setOnClickListener {
            // Get the entered values from EditText fields
            val version = editTextVersion.text.toString()
            val codeName = editTextCodeName.text.toString()

            // Add a new row to the table
            addDynamicRow(version, codeName)

            // Clear EditText fields
            editTextVersion.text.clear()
            editTextCodeName.text.clear()
        }
    }

    private fun addStaticRow(version: String, codeName: String) {
        val row = TableRow(this)
        val versionTextView = TextView(this)
        val codeNameTextView = TextView(this)

        versionTextView.text = version
        codeNameTextView.text = codeName

        row.addView(versionTextView)
        row.addView(codeNameTextView)

        tableLayout.addView(row)
    }

    private fun addDynamicRow(version: String, codeName: String) {
        val row = TableRow(this)
        val versionTextView = TextView(this)
        val codeNameTextView = TextView(this)

        versionTextView.text = version
        codeNameTextView.text = codeName

        row.addView(versionTextView)
        row.addView(codeNameTextView)

        tableLayout.addView(row)
    }

}

