package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.databinding.FragmentOneBinding

/**
 * Fragment 1
 */
class OneFragment : Fragment(R.layout.fragment_one) {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentOneBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)

        return binding.root
    }

    /**
     * Lifecycle Methode nachdem das View erstellt wurde
     *
     * @param view                    Das angezeigte View
     * @param savedInstanceState      Eventuelle saveStates
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNestFragmentOne.setOnClickListener{
            findNavController().navigate(
                OneFragmentDirections.actionOneFragmentToNesterFragment()
            )
        }


        binding.btnFotosFragmentOne.setOnClickListener{
            findNavController().navigate(
                OneFragmentDirections.actionOneFragmentToFotoFragment()
            )
        }
        binding.btnFlirtboxFragmentOne.setOnClickListener{
            findNavController().navigate(
                OneFragmentDirections.actionOneFragmentToFlirtBoxFragment()
            )

        }
    }
}
