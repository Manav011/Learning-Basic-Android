package com.example.learning.misc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.learning.R
import java.util.Calendar
import android.app.DatePickerDialog
import android.app.TimePickerDialog

class DateTimePicker : AppCompatActivity() {
    private lateinit var btnDate: Button
    private lateinit var btnTime: Button
    private lateinit var txtDate: EditText
    private lateinit var txtTime: EditText
    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    private var mHour:Int = 0
    private var mMinute:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_picker)

        btnDate = findViewById(R.id.datebtn)
        btnTime = findViewById(R.id.timebtn)
        txtDate = findViewById(R.id.datetext)
        txtTime = findViewById(R.id.timetext)

        btnDate.setOnClickListener{
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]

            val datePickerDialog = DatePickerDialog(this@DateTimePicker, {
                view, year, monthOfYear, dayOfMonth ->
                txtDate.setText(dayOfMonth.toString() + "-" + (monthOfYear+1) + "-" + year) },
                mYear, mMonth, mDay )
            datePickerDialog.show()
        }

        btnTime.setOnClickListener {
            val c = Calendar.getInstance()
            mHour = c[Calendar.HOUR_OF_DAY]
            mMinute = c[Calendar.MINUTE]

            val timePickerDialog = TimePickerDialog(this@DateTimePicker,
                { view, hourOfDay, minute ->
                    var hourOfDay = hourOfDay
                    val Am_Pm = if (hourOfDay < 12) {
                        "AM"
                    } else {
                        "PM"
                    }
                    if (Am_Pm === "PM") hourOfDay -= 12
                    if (hourOfDay == 0) hourOfDay += 12
                    if (minute < 10) {
                        txtTime.setText("$hourOfDay:0$minute $Am_Pm")
                    } else {
                        txtTime.setText("$hourOfDay:$minute $Am_Pm")
                    }
                }, mHour, mMinute, false
            )
            timePickerDialog.show()
        }
    }
}