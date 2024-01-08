package com.example.tipcalculatorv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculatorv2.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculatetip() }
    }


    private fun calculatetip() {
       val cost = binding.costOfService.text.toString().toDouble()
       val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId) {
            R.id.option_10_percent -> 0.1
            R.id.option_15_percent -> 0.15
            R.id.option_20_percent -> 0.2
            else -> (binding.customTipEnter.text.toString().toDouble())/100

        }
        var tip = cost*tipPercentage
        val roundUp = binding.roundTip.isChecked
        if (roundUp){
            tip = ceil(tip)
        }
        val currencyTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmmount.text = getString(R.string.tip_amount,currencyTip)


    }
}