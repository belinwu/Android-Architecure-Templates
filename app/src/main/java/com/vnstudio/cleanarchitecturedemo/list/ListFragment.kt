package com.vnstudio.cleanarchitecturedemo.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.vnstudio.cleanarchitecturedemo.*
import com.vnstudio.cleanarchitecturedemo.databinding.FragmentListBinding
import com.vnstudio.cleanarchitecturedemo.details.DetailsFragment
import com.vnstudio.cleanarchitecturedemo.models.Fork
import javax.inject.Inject

class ListFragment : Fragment(), ListViewContract {

    @Inject
    lateinit var listPresenter: ListPresenter

    private var binding: FragmentListBinding? = null
    private var forkAdapter: ForkAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListBinding.inflate(LayoutInflater.from(context))
        AppApplication.instance?.appComponent?.injectListFragment(this)
        listPresenter.attachView(this)
        setForkAdapter()
        binding?.startButton?.setOnClickListener {
            listPresenter.getForksFromApi()
        }
        return binding?.root
    }

    private fun setForkAdapter() {
        forkAdapter = forkAdapter ?: ForkAdapter(listOf())
        binding?.recyclerView?.adapter = forkAdapter
        forkAdapter?.setOnForkClickListener(object : OnForkClickListener {
            override fun onForkClick(fork: Fork) {
                findNavController().navigate(ListFragmentDirections.startDetailsFragment(fork.id ?: 0))
            }
        })
    }

    override fun setProgressVisibility(showProgress: Boolean) {
        binding?.progressBar?.isVisible = showProgress
    }

    override fun insertForksToDB(forks: List<Fork>) {
        listPresenter.insertForksToDB(forks)
    }

    override fun getForksFromDB() {
        listPresenter.getForksFromDB()
    }

    override fun setForksFromDB(forks: List<Fork>) {
        forkAdapter?.setForks(forks)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        listPresenter.detachView()
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}