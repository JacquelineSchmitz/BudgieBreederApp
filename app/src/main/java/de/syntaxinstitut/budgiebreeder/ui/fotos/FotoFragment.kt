package de.syntaxinstitut.budgiebreeder.ui.fotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.databinding.FragmentFotosBinding
import de.syntaxinstitut.budgiebreeder.ui.nest.FotoViewModel


class FotoFragment: Fragment(R.layout.fragment_fotos) {
    private lateinit var binding: FragmentFotosBinding
    private val viewModel: FotoViewModel by viewModels()


     fun onCraeteView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fotos, container, false)

        return binding.root
    }
}