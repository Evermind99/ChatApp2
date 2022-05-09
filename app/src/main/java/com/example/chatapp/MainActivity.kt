package com.example.chatapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createMembers()
    }

    fun createMembers(){
        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)

        imageView1.setColorFilter(Color.parseColor(getRandomColor()))
        imageView2.setColorFilter(Color.parseColor(getRandomColor()))
        imageView3.setColorFilter(Color.parseColor(getRandomColor()))
        imageView4.setColorFilter(Color.parseColor(getRandomColor()))

        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)

        textView1.text = getRandomName()
        textView2.text = getRandomName()
        textView3.text = getRandomName()
        textView4.text = getRandomName()

    }

    fun openMessenger(view: View) {
        val TextView = findViewById<TextView>(R.id.textView1)
        val intent = Intent(this, MessengerActivity::class.java)

        startActivity(intent)
    }

    private fun getRandomName(): String? {
        val firstNames = arrayOf("James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth",
                "Mary", "Patricia", "Jennifer", "Linda" , "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen", "Nancy", "Lisa", "Margaret", "Betty", "Sandra", "Ashley", "Dorothy", "Kiberly", "Emily", "Donna")
        val lastNames = arrayOf("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzales", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin")
        return firstNames[Math.floor(Math.random() * firstNames.size).toInt()] +
                " " +
                lastNames[Math.floor(Math.random() * lastNames.size).toInt()]
    }

    private fun getRandomColor(): String? {
        val r = Random()
        val sb = StringBuffer("#")
        while (sb.length < 7) {
            sb.append(Integer.toHexString(r.nextInt()))
        }
        return sb.toString().substring(0, 7)
    }


}
