package de.syntaxinstitut.budgiebreeder.adapter

import android.annotation.SuppressLint
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.EiData
import de.syntaxinstitut.budgiebreeder.data.model.FlirtData
import de.syntaxinstitut.budgiebreeder.databinding.ItemFlirtboxBinding
import de.syntaxinstitut.budgiebreeder.ui.FlirtBoxFragment

class FlirtAdapter(
    private var dataset: List<FlirtData>
) : RecyclerView.Adapter<FlirtAdapter.ItemViewHolder>() {


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<FlirtData>) {
        dataset = list
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(val binding: ItemFlirtboxBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemFlirtboxBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlirtAdapter.ItemViewHolder,@SuppressLint("RecyclerView") position: Int) {

        val currentFlirt = dataset[position]

        holder.binding.textInputName.setText(currentFlirt.name1)
        holder.binding.textInputName.inputType = InputType.TYPE_CLASS_TEXT
        holder.binding.textInputName2.setText(currentFlirt.name2)
        holder.binding.textInputName2.inputType = InputType.TYPE_CLASS_TEXT

        holder.binding.textInputName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                dataset[position].name1 = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

    holder.binding.textInputName2.addTextChangedListener(object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            dataset[position].name2 = p0.toString()
        }

        override fun afterTextChanged(p0: Editable?) {

        }
    })

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun getDataSet(): List<FlirtData>{
        return dataset
    }

}