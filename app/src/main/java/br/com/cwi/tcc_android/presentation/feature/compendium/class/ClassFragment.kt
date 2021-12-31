package br.com.cwi.tcc_android.presentation.feature.compendium.`class`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.tcc_android.databinding.FragmentClassBinding
import br.com.cwi.tcc_android.domain.entity.Class
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ClassFragment : Fragment() {

    private lateinit var binding: FragmentClassBinding

    private val viewModel: ClassViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClassBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.classes.observe(viewLifecycleOwner) { list ->
            setUpCoffeeRecyclerView(list)
        }
        viewModel.fetchClasses()
    }

    private fun setUpCoffeeRecyclerView(list: List<Class>) {
        binding.rvCaps.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = ClassAdapter(list)
        }
    }
}