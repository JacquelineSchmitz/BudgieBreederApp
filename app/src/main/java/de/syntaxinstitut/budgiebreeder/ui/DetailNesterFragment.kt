package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
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



class DetailNesterFragment : Fragment() {
    private lateinit var binding: FragmentDetailNesterBinding
    private val viewModel: MainViewModel by activityViewModels()
    private var nestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nestId = it.getInt("id")
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


    }
}