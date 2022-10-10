package de.syntaxinstitut.budgiebreeder.adapter

import android.annotation.SuppressLint
import android.text.Editable
import android.text.InputType
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.data.model.EiData
import de.syntaxinstitut.budgiebreeder.databinding.ItemEiBinding
import de.syntaxinstitut.budgiebreeder.ui.NesterFragmentDirections


class DetailNestAdapter(
     var dataset: List<EiData>
) : RecyclerView.Adapter<DetailNestAdapter.ItemViewHolder>() {

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

    override fun onBindViewHolder(holder: DetailNestAdapter.ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {


            val currentEi = dataset[position]
            /* var gelegt = holder.binding.textInputGelegt.text.toString()
             var geschluepft = holder.binding.textInputGeschluepft.text.toString()*/


            holder.binding.textInputGelegt.setText(currentEi.gelegt)
        holder.binding.textInputGelegt.inputType = InputType.TYPE_CLASS_TEXT
            holder.binding.textInputGeschluepft.setText(currentEi.geschluepft)
        holder.binding.textInputGeschluepft.inputType = InputType.TYPE_CLASS_TEXT

        holder.binding.textInputGelegt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                dataset[position].gelegt = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        holder.binding.textInputGeschluepft.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               dataset[position].geschluepft = p0.toString()
            }


            override fun afterTextChanged(p0: Editable?) {

            }


        })





//        val currentEi = dataset[position]
//
//        holder.binding.textInputGelegt.setText(currentEi.gelegt)
//        holder.binding.textInputGeschluepft.setText(currentEi.gelegt)

//        val editableGelegt: Editable = SpannableStringBuilder(currentEi.gelegt)
//        holder.binding.textInputGelegt.text = editableGelegt
//
//        val editableGeschluepft: Editable = SpannableStringBuilder(currentEi.geschluepft)
//        holder.binding.textInputGeschluepft.text = editableGeschluepft

    }

    override fun getItemCount(): Int {
        Log.e("test",dataset.size.toString())

        return dataset.size
    }

    fun getDataSet(): List<EiData> {
        return dataset
    }
}

