package com.pirris.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pirris.R
import com.pirris.model.Speaker
import com.pirris.view.adapter.SpeakerAdapter
import com.pirris.view.adapter.SpeakerListener
import com.pirris.viewmodel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speakers.*

/**
 * A simple [Fragment] subclass.
 * Use the [SpeakersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeakersFragment : Fragment(), SpeakerListener {
    private lateinit var speakerAdapter: SpeakerAdapter
    private lateinit var viewModel: SpeakersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(SpeakersViewModel::class.java)
        viewModel.refresh()

        speakerAdapter = SpeakerAdapter(this)

        rvSpeakers.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = speakerAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.getSpeaker.observe(this, Observer<List<Speaker>>{ speaker ->
            speakerAdapter.updateDatadata(speaker)
        })

        viewModel.isLoading.observe(this, Observer<Boolean>{
            if (it != null){
                rlBaseSpeakers.visibility = View.INVISIBLE
            }
        })
    }

    override fun onSpeakerClicked(speaker: Speaker, position: Int) {
        val bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.speakersDetailFragmentDialog, bundle)
    }


}