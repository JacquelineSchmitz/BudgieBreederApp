package de.syntaxinstitut.budgiebreeder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.FlirtData
import de.syntaxinstitut.budgiebreeder.databinding.ItemFlirtboxBinding

class FlirtAdapter (
    private val dataset: List<FlirtData>
        ) : RecyclerView.Adapter<FlirtAdapter.ItemViewHolder>(){

            inner class ItemViewHolder(val binding: ItemFlirtboxBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemFlirtboxBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentFlirt = dataset[position]

    //todo funktioniert nicht weil editable.umsetzten bei datenbank

        //holder.binding.textInputName.text = currentFlirt.name1
        //holder.binding.textInputName2.text = currentFlirt.name2
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}