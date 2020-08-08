package com.pirris.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pirris.R
import com.pirris.model.Speaker
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*


/**
 * A simple [Fragment] subclass.
 * Use the [SpeakersDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeakersDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarExpositor.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarExpositor.setTitleTextColor(Color.WHITE)
        toolbarExpositor.setNavigationOnClickListener {
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker") as Speaker

        Glide.with(view.context)
            .load(speaker.image) //Acá asignamos el link de la imagen
            //.apply(RequestOptions.circleCropTransform()) //Aplicamos un contorno circular a la imagen
            .into(profile_image)

        toolbarExpositor.title = speaker.name
         tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerJobtitle.text = speaker.jobtitle
        tvDeatilSpeakerJob.text = speaker.workplace
        tvDetailSpeakerDescription.text = speaker.biography

        twitterSpeakerIcon.setOnClickListener {
            val url = speaker.twitter
            val uri = Uri.parse("https://twitter.com/$url")
            val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
            startActivity(launchBrowser)
        }

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}