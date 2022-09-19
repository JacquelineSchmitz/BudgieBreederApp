package de.syntaxinstitut.budgiebreeder.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.BirthDate
import de.syntaxinstitut.budgiebreeder.databinding.FragmentNesterBinding
import de.syntaxinstitut.budgiebreeder.databinding.FragmentOneBinding
import de.syntaxinstitut.budgiebreeder.ui.home.OneFragment
import de.syntaxinstitut.budgiebreeder.ui.home.OneFragmentDirections


class BudgieAdapter (
    private var dataset: List<BirthDate>
) : RecyclerView.Adapter<BudgieAdapter.ItemViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
        fun submitList(list: List<BirthDate>) {
            dataset = list
            notifyDataSetChanged()
        }

    class ItemViewHolder(val binding: FragmentOneBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = FragmentOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.btnNestFragmentOne.setOnClickListener(){
            holder.itemView.findNavController()
                .navigate(OneFragmentDirections.actionOneFragmentToTwoFragment())
        }

        holder.binding.btnFotosFragmentOne.setOnClickListener() {
            holder.itemView.findNavController()
                .navigate(OneFragmentDirections.actionOneFragmentToFotoFragment())
        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}

