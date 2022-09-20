package de.syntaxinstitut.budgiebreeder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.PicData
import de.syntaxinstitut.budgiebreeder.databinding.ItemFotosBinding

class PicAdapter (
    private val dataset: List<PicData>
        ) : RecyclerView.Adapter<PicAdapter.ItemViewHolder>(){

            inner class ItemViewHolder(val binding: ItemFotosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemFotosBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentPic = dataset[position]

        holder.binding.picIv.setImageResource(currentPic.pictures)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}