package com.example.mp_exam

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        Toast.makeText(this,B(""))
        setContentView(R.layout.activity_main)
        var sp:Spinner=findViewById(R.id.spinner)
        var input1:EditText=findViewById(R.id.input1)
        var input2:EditText=findViewById(R.id.input2)
        var submit:Button=findViewById(R.id.submit)
        var answer:TextView=findViewById(R.id.answer)
        var opt=arrayOf("Add", "Sub", "Mul", "Div");
        var flag:String="Add"
        sp.adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,opt)
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = opt.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        submit.setOnClickListener { view ->
            var x=input1.text.toString().toInt()
            var y=input2.text.toString().toInt()
            answer.text=operate(x,y,flag).toString();
        }
    }
    fun operate(x:Int,y:Int,flag:String):String{
        var ans:String="";
        when(flag){
            "Add"->{
                ans=(x+y).toString()
            }
            "Sub"->{
                ans=(x-y).toString()
            }
            "Mul"->{
                ans=(x*y).toString()
            }
            "Div"->{
                ans=(x.toFloat()/y.toFloat()).toString()
            }
        }
        return ans;
    }
}