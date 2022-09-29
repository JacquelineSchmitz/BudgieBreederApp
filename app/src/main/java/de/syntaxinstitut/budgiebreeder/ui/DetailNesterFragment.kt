package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import de.syntaxinstitut.budgiebreeder.MainViewModel
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.databinding.FragmentDetailNesterBinding

//todo detailnester einmal updaten, beim hinzufügen der daten ... hinzufügen zu den entsprechenden listen
//todo auslesen der daten aus der liste und setzten dies auf edit text

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

        binding.buttonName.setOnClickListener{
            var name = binding.nameText.text.toString()
            Log.d("test","${name}")
            currentNest!!.name = name
            viewModel.updatedetailNest(currentNest)
            binding.nameText.text = name
        }
    }
}