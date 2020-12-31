package com.tugasakhirsemester.farhan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.tugasakhirsemester.farhan.api.RetrofitClient
import com.tugasakhirsemester.farhan.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showIndonesia()
    }
    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object : Callback<ArrayList<IndonesiaResponse>> {
            override fun onResponse(call: Call<ArrayList<IndonesiaResponse>>, response: Response<ArrayList<IndonesiaResponse>>) {
                val indonesiaResponse = response.body()?.get(0)
                val positive = indonesiaResponse?.positif
                val hospitalized = indonesiaResponse?.dirawat
                val recover = indonesiaResponse?.sembuh
                val death = indonesiaResponse?.meninggal

                val cassPositive : TextView = findViewById(R.id.tvPositive)
                cassPositive.text= positive
                val cassHospitalized : TextView = findViewById(R.id.tvHospitalized)
                cassHospitalized.text= hospitalized
                val cassRecover : TextView = findViewById(R.id.tvRecover)
                cassRecover.text= recover
                val cassDeath : TextView = findViewById(R.id.tvDeath)
                cassDeath.text= death


            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}