package de.syntaxinstitut.budgiebreeder.adapter

import android.annotation.SuppressLint
import android.text.Editable
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.EiData
import de.syntaxinstitut.budgiebreeder.databinding.ItemEiBinding
import de.syntaxinstitut.budgiebreeder.databinding.ItemNesterBinding
import de.syntaxinstitut.budgiebreeder.ui.NesterFragmentDirections

class DetailNestAdapter (

        private var dataset: List<EiData>,
        val handler: (EiData) -> Unit
) : RecyclerView.Adapter<DetailNestAdapter.ItemViewHolder>(){

        @SuppressLint("NotifyDataSetChanged")
        fun submitList(list: List<EiData>){
                dataset = list
                notifyDataSetChanged()
        }

        inner class ItemViewHolder(val binding: ItemEiBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailNestAdapter.ItemViewHolder {
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
                return dataset.size
        }

}

