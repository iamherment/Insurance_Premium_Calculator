package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this,"Position "+position,
        Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener=this
        buttonCaculate.setOnClickListener{
            calculateInsurance()
        }
    }

    private fun calculateInsurance(){
        val position=spinnerAge.selectedItemPosition
        val age =spinnerAge.getChildAt(position)
        val gender=radioGroupGender.checkedRadioButtonId
        var basic_premiun: Int=0
        var total:Int=0
        var male_payment:Int=0
        var smoke_payment:Int=0

        basic_premiun= when(position){
            0 ->60
            1 ->70
            2 ->90
            3 ->120
            else -> 150

        }

        if(gender==R.id.radioButtonMale){


            male_payment=when(position){
                0 ->0
                1 ->50
                2 ->100
                3 ->150
                else -> 200
            }

        }

        if(checkBoxSmoker.isChecked){


            smoke_payment=when(position){
                0 ->0
                1 ->100
                2 ->150
                3 ->200
                4 ->250
                else -> 300
            }
        }
        total=basic_premiun+male_payment+smoke_payment
        val symbol= Currency.getInstance(Locale.getDefault()).symbol
        textViewinsurans.text=String.format("%s:%s %d", getString(R.string.insurance_premium),symbol,total)
    }
}
