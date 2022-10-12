package de.syntaxinstitut.budgiebreeder.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.DetailNest

import de.syntaxinstitut.budgiebreeder.data.model.NestButton
import de.syntaxinstitut.budgiebreeder.databinding.ItemNesterBinding
import de.syntaxinstitut.budgiebreeder.ui.NesterFragment
import de.syntaxinstitut.budgiebreeder.ui.NesterFragmentDirections


class NestAdapter(
    private var dataset: List<DetailNest>,
    val handler: (DetailNest) -> Unit
) : RecyclerView.Adapter<NestAdapter.ItemViewHolder>(){

    @SuppressLint ("NotifyDataSetChanged")
    fun submitList(list: List<DetailNest>){
        dataset = list
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(val binding: ItemNesterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemNesterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentButton = dataset[position]

        holder.binding.name.text = currentButton.title

        holder.binding.nestButton.setOnClickListener{
            holder.itemView.findNavController()
                .navigate(NesterFragmentDirections.actionNesterFragmentToDetailNesterFragment(currentButton.id))
        }

        holder.binding.imageButtonLoeschen.setOnClickListener{
            handler(currentButton)
            notifyItemRemoved(position)
        }
//        holder.binding.imageButton.setOnClickListener{
//            handler(currentButton)
//          //  notifyItem(position)
//        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}
