package ru.mts.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.mts.core.FeatureManager
import javax.inject.Inject

abstract class BaseFragment<VM : IBaseViewModel> : Fragment() {

    var featureTag: String by FragmentTagHolder()

    abstract val layout: Int

    @Inject
    lateinit var viewModel: VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        FeatureManager.attachFragment(this)
        viewModel.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel()
    }

    abstract fun subscribeToViewModel()

    override fun onDestroy() {
        super.onDestroy()
        if (activity != null && activity?.isChangingConfigurations == false) {
            FeatureManager.destroy(this)
        }
    }
}
