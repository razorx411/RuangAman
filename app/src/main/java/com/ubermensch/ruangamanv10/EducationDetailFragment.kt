package com.ubermensch.ruangamanv10

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment

class EducationDetailFragment : Fragment() {

    private lateinit var btnBack: ImageButton
    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailAuthor: TextView
    private lateinit var tvDetailDate: TextView
    private lateinit var tvDetailContent: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_education_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBack = view.findViewById(R.id.btnBackDetail)
        tvDetailTitle = view.findViewById(R.id.tvDetailTitle)
        tvDetailAuthor = view.findViewById(R.id.tvDetailAuthor)
        tvDetailDate = view.findViewById(R.id.tvDetailDate)
        tvDetailContent = view.findViewById(R.id.tvDetailContent)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("education_data", EducationItem::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getSerializable("education_data") as? EducationItem
        }

        data?.let {
            tvDetailTitle.text = it.title
            tvDetailAuthor.text = it.author
            tvDetailDate.text = it.date
            tvDetailContent.text = it.content
        }

        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}