package com.bignerdranch.android.application_19

import android.R.attr.button
import android.R.attr.localeConfig
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.text.DateFormat
import java.text.DateFormat.getDateInstance
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Locale
import java.util.UUID


class CrimeFragment : Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var dateButton: MaterialButton
    private lateinit var titleName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val date = Date()
        val locale = Locale.getDefault()
        val dateFormat = getDateFormat(locale)

        crime = Crime(
            id = UUID.randomUUID(),
            title = "Убийство",
            isSolved = true,
            date = dateFormat.format(date)
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime,container,false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as MaterialButton
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
        titleName = view.findViewById(R.id.textView)
        dateButton.apply {
            text = crime.date.toString()
        }
        return view;
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }


        }


        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply {
            setOnCheckedChangeListener{ _, isChecked -> crime.isSolved = isChecked}
        }
        solvedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            dateButton.isEnabled = isChecked
            view?.let { Snackbar.make(it, "Вы нажали на Checkbox", Snackbar.LENGTH_SHORT).show() }
        }
        dateButton.setOnClickListener {
            titleName.text = titleField.text.toString()


            val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                val intent = Intent(context, MainActivity2::class.java)
                startActivity(intent)
            }, 5000)
        }

    }

    private fun getDateFormat(locale: Locale): SimpleDateFormat {
        return when (locale.country) {
            "US" -> SimpleDateFormat("MM-dd-yyyy", locale)
            else -> SimpleDateFormat("dd/MM/yyyy", locale)
        }
    }


}