package com.krisnaputra.burunglangka

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvBurung: RecyclerView
    private val list: ArrayList<Burung> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBurung = findViewById(R.id.rv_burung)
        rvBurung.setHasFixedSize(true)

        list.addAll(BurungData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvBurung.layoutManager = LinearLayoutManager(this)
        val listBurungAdapter = ListBurungAdapter(list)
        rvBurung.adapter = listBurungAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.action_tentang) {
            val keTentang= Intent(this@MainActivity,AboutActivity::class.java)
            startActivity(keTentang)
        }

        return super.onOptionsItemSelected(item)

    }


}
