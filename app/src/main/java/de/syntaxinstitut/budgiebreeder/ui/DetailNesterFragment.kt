package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.room.Database
import com.google.android.material.textfield.TextInputEditText
import de.syntaxinstitut.budgiebreeder.MainViewModel
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.adapter.DetailNestAdapter
import de.syntaxinstitut.budgiebreeder.adapter.NestAdapter
import de.syntaxinstitut.budgiebreeder.data.model.DetailNest
import de.syntaxinstitut.budgiebreeder.data.model.EiData
import de.syntaxinstitut.budgiebreeder.databinding.FragmentDetailNesterBinding



class DetailNesterFragment : Fragment() {
    private lateinit var binding: FragmentDetailNesterBinding
    private val viewModel: MainViewModel by activityViewModels()
    private var nestId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nestId = it.getLong("id")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_nester, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        var currentNest = viewModel.detailNest.value!!.find { it.id == nestId }
        binding.nameText.setText(currentNest!!.name)

        var adapter = DetailNestAdapter(listOf())

        binding.buttonName.setOnClickListener {

            val name = binding.nameText.text.toString()

            for (item in adapter.getDataSet()){
//                val gelegt = item.gelegt
//                val geschluepft = item.geschluepft
                viewModel.updateEiData(item)
            }

                Log.d("test", "${name}")
                currentNest!!.name = name
                viewModel.updatedetailNest(currentNest)



//            viewModel.insertEiData(EiData(gelegt = "22.04", geschluepft = "15.05", nestId = currentNest.id))


//            val vogelName: Editable = SpannableStringBuilder(name)
//
//            binding.nameText.text = vogelName
        }

        binding.floatingActionButton2.setOnClickListener {
            viewModel.insertEiData(EiData(gelegt = "", geschluepft = "", nestId = currentNest.id))

        }

        binding.eierRv.adapter = adapter

        viewModel.eiData.observe(
            viewLifecycleOwner,

            Observer {
                Log.e("test",viewModel.eiData.value.toString())
        var eierListe = mutableListOf<EiData>()
                for (ei in it) {
                    if (
                        ei.nestId == currentNest.id
                    ){
                        eierListe.add(ei)
                    }
                }
                adapter.submitList(eierListe)
//                binding.eierRv.adapter = DetailNestAdapter(viewModel.eiData.value!!) { eiData ->
//                    handleEiData(eiData)
//
//                }
            }
        )

    }

    private fun handleEiData(eiData: EiData) {
        viewModel.deleteEi(eiData.id)
    }
}

