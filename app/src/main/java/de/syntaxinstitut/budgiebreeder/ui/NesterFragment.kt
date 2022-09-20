package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import de.syntaxinstitut.budgiebreeder.MainViewModel
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.adapter.NestAdapter
import de.syntaxinstitut.budgiebreeder.databinding.FragmentNesterBinding


/**
 * Fragment 2
 */
class NesterFragment : Fragment(R.layout.fragment_nester) {
    private lateinit var binding : FragmentNesterBinding
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nester, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nest.observe(
            viewLifecycleOwner,
            Observer {
                binding.nesterRv.adapter = NestAdapter(it)
            }
        )
    }
}
