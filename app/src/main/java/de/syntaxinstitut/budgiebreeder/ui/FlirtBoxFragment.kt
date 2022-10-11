package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.budgiebreeder.MainViewModel
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.adapter.FlirtAdapter
import de.syntaxinstitut.budgiebreeder.data.model.FlirtData
import de.syntaxinstitut.budgiebreeder.databinding.FragmentFlirtboxBinding


class FlirtBoxFragment : Fragment(R.layout.fragment_flirtbox) {
    private lateinit var binding: FragmentFlirtboxBinding
    private val viewModel: MainViewModel by activityViewModels()
    private var flirtId: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            flirtId = it.getLong("id")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flirtbox, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("flirtId:", viewModel.detailNest.value.toString())
        var currentFlirt = viewModel.flirtData.value!!.find { it.id == flirtId }

        // binding.flirtRv.
        // binding.textInputName2.setText(currentFlirt!!.value)

        var adapter = FlirtAdapter(listOf())

        binding.floatingActionButton3.setOnClickListener {
            viewModel.insertFlirtData(FlirtData(name1 = "", name2 = ""))


            for (item in adapter.getDataSet()) {
//                val name1 = item.flirtBox
//                val name2 = item.flirtBox
                viewModel.updateFlirtData(item)
            }
        }
        binding.flirtRv.adapter = adapter

        viewModel.flirtData.observe(
            viewLifecycleOwner

        ) {
            Log.e("test", viewModel.flirtData.value.toString())
            var flirtListe = mutableListOf<FlirtData>()
            for (flirt in it) {
                if (currentFlirt != null) {
                    if (
                        flirt.id == currentFlirt.id
                    ) {
                        flirtListe.add(flirt)
                    }
                }
            }
            adapter.submitList(flirtListe)
        }


        }
    private fun handleFlirtData (flirtData: FlirtData) {
        viewModel.deleteFlirt(flirtData.id)
    }
}