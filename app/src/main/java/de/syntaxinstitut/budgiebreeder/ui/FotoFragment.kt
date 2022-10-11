package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.budgiebreeder.MainViewModel
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.adapter.NestAdapter
import de.syntaxinstitut.budgiebreeder.adapter.PicAdapter
import de.syntaxinstitut.budgiebreeder.data.model.PicData
import de.syntaxinstitut.budgiebreeder.databinding.FragmentFotosBinding
import java.util.Observer


class FotoFragment: Fragment(R.layout.fragment_fotos) {
    private lateinit var binding: FragmentFotosBinding
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fotos, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.pics.observe(
            viewLifecycleOwner
        ) {
            binding.fotoRv.adapter = PicAdapter(it)
        }
    }
}