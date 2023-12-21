package com.example.clistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listview)
        val imageList = intArrayOf(
            R.drawable.bangladesh_img,
            R.drawable.india_img,
            R.drawable.pakistan_img,
            R.drawable.srilanka_img,
            R.drawable.mayanmar_img,
            R.drawable.maldiv_img,
            R.drawable.america_img
        )
        val ingredientList = intArrayOf(
            R.string.pastaIngredients,
            R.string.maggiIngredients,
            R.string.cakeIngredients,
            R.string.pancakeIngredients,
            R.string.pizzaIngredients,
            R.string.burgerIngredients,
            R.string.friesIngredients
        )
        val descList = intArrayOf(
            R.string.bangladeshDetails,
            R.string.IndiaDetails,
            R.string.PakistanDetails,
            R.string.SrilankaDetails,
            R.string.MayanmarDetails,
            R.string.MaldivsDetails,
            R.string.AmericaDetails
        )
        val nameList = arrayOf(
            "Bangladesh",
            "India",
            "Pakistan",
            "Srilanka",
            "Mayanmar",
            "Maldiv",
            "America",
            "Australia",
            "Bhutan",
            "Canada",
            "China",
            "Finland",
            "Indonesia",
            "Ireland",
            "Japan",
            "Korea",
            "Netherland",
            "Nigeria",
            "Portugal",


        )
        val timeList = arrayOf("30 mins", "2 mins", "45 mins", "10 mins", "60 mins", "45 mins", "30 mins")
        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                timeList[i], ingredientList[i], descList[i], imageList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
       listView.adapter = listAdapter
        listView.isClickable = true
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("time", timeList[i])
            intent.putExtra("ingredients", ingredientList[i])
            intent.putExtra("desc", descList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }
    }
}