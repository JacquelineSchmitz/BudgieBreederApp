package de.syntaxinstitut.budgiebreeder.adapter

import android.annotation.SuppressLint
import android.text.Editable
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.EiData
import de.syntaxinstitut.budgiebreeder.databinding.ItemEiBinding


class DetailNestAdapter() : RecyclerView.Adapter<DetailNestAdapter.ItemViewHolder>() {
    private var dataset: List<EiData> = listOf()
    // val handler: (EiData) -> Unit

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<EiData>) {
        dataset = list
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(val binding: ItemEiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailNestAdapter.ItemViewHolder {
        val binding = ItemEiBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailNestAdapter.ItemViewHolder, position: Int) {
        val currentEi = dataset[position]


        val editableGelegt: Editable = SpannableStringBuilder(currentEi.gelegt)
        holder.binding.textInputGelegt.text = editableGelegt

        val editableGeschluepft: Editable = SpannableStringBuilder(currentEi.geschluepft)
        holder.binding.textInputGeschluepft.text = editableGeschluepft

    }

    override fun getItemCount(): Int {
        Log.e("test",dataset.size.toString())

        return dataset.size
    }

}

