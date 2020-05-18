package com.krisnaputra.burunglangka

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val NAMA = "NAMA"
        const val ILMIAH = "ILMIAH"
        const val KONSERVASI = "KONSERVASI"
        const val DESKRIPSI = "DESKRIPSI"
        const val FOTO = "FOTO"
    }



    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Detail Burung")

        val name = intent.getStringExtra(NAMA)
        val ilmiah = intent.getStringExtra(ILMIAH)
        val konservasi = intent.getStringExtra(KONSERVASI)
        val deskripsi = intent.getStringExtra(DESKRIPSI)
        val foto = intent.getStringExtra(FOTO)

        val vNama: TextView = findViewById(R.id.nama_burung)
        val vNamaIlmiah: TextView = findViewById(R.id.nama_ilmiah_burung)
        val vKonservasi: TextView = findViewById(R.id.status_konservasi)
        val vDeskripsi: TextView = findViewById(R.id.burung_deskripsi)
        val vFoto: ImageView = findViewById(R.id.foto_burung)



        vNama.setText(name)
        vNamaIlmiah.setText(ilmiah)
        vKonservasi.setText(konservasi)
        vDeskripsi.setText(deskripsi)
        vFoto.setImageDrawable(getDrawable(foto.toInt()))

    }

}
