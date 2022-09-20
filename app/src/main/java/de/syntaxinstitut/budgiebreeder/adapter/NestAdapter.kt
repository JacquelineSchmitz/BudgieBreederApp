package de.syntaxinstitut.budgiebreeder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import de.syntaxinstitut.budgiebreeder.data.model.NestButton
import de.syntaxinstitut.budgiebreeder.databinding.ItemNesterBinding


class NestAdapter(
    private val dataset: List<NestButton>
) : RecyclerView.Adapter<NestAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding: ItemNesterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemNesterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentButton = dataset[position]

        holder.binding.name.text = currentButton.name

        // todo navigation einfügen
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}
