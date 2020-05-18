package com.krisnaputra.burunglangka

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBurungAdapter (private val listBurung: ArrayList<Burung>): RecyclerView.Adapter<ListBurungAdapter.ListViewHolder>(){
    private val context: Context? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_burung, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBurung.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val burung = listBurung[position]
        Glide.with(holder.itemView.context)
            .load(burung.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvNama.text = burung.nama
        holder.tvIlmiah.text = burung.nama_ilmiah



        holder.itemView.setOnClickListener {
            val keDetail=Intent(holder.itemView.context,DetailActivity::class.java)
            keDetail.putExtra("NAMA",burung.nama)
            keDetail.putExtra("ILMIAH",burung.nama_ilmiah)
            keDetail.putExtra("KONSERVASI",burung.konservasi)
            keDetail.putExtra("DESKRIPSI",burung.deskripsi)
            keDetail.putExtra("FOTO",burung.photo.toString())

            holder.itemView.context.startActivity(keDetail)

        }

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama: TextView = itemView.findViewById(R.id.tv_burung_name)
        var tvIlmiah: TextView = itemView.findViewById(R.id.tv_burung_nama_ilmiah)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_burung_photo)


    }
}
