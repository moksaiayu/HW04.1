package com.example.hw04

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class Main2Activity : AppCompatActivity() {

    private var send_btn: Button? = null
    private var set_drink: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null

    private var suger = "無糖"
    private val ice_opt = "微冰"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rg1 = findViewById(R.id.radioGroup)
        rg1!!.setOnCheckedChangeListener { radoGroup, i ->
            when (i) {
                R.id.radioButton1 -> suger = "無糖"
                R.id.radioButton2 -> suger = "少糖"
                R.id.radioButton3 -> suger = "半糖"
                R.id.radioButton4 -> suger = "全糖"
            }
        }
        rg2 = findViewById(R.id.radioGroup2)
        rg2!!.setOnCheckedChangeListener { group, i ->
            when (i) {
                R.id.radioButton5 -> suger = "微冰"
                R.id.radioButton6 -> suger = "少冰"
                R.id.radioButton7 -> suger = "正常冰"
            }
        }
        send_btn = findViewById(R.id.btn_send)
        send_btn!!.setOnClickListener {
            set_drink = findViewById(R.id.ed_drink)
            val drink = set_drink!!.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("suger", suger)
            b.putString("drink", drink)
            b.putString("ice", ice_opt)
            i.putExtras(b)
            setResult(101, i)
            finish()
        }


    }
}
