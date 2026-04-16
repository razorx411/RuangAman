package com.ubermensch.ruangamanv10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EducationBlog : Fragment() {

    private lateinit var rvEducationBlog: RecyclerView
    private lateinit var adapter: EducationBlogAdapter
    private val educationList = arrayListOf<EducationItem>()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.fragment_education_blog, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvEducationBlog = view.findViewById(R.id.rvEducationBlog)
        rvEducationBlog.layoutManager = LinearLayoutManager(requireContext())
        rvEducationBlog.setHasFixedSize(true)

        loadDummyData()

        adapter = EducationBlogAdapter(educationList) { selectedItem ->
            val bundle = Bundle()
            bundle.putSerializable("education_data", selectedItem)

            findNavController().navigate(
                R.id.action_nav_education_to_educationDetailFragment,
                bundle
            )
        }

        rvEducationBlog.adapter = adapter
    }

    private fun loadDummyData() {
        educationList.clear()
        educationList.addAll(
            listOf(
                EducationItem(
                    title = "Apa itu bullying?",
                    shortDescription = "Bullying adalah perilaku agresif yang dilakukan berulang kali untuk menyakiti orang lain.",
                    content = "Bullying adalah tindakan menyakiti, mengintimidasi, atau merendahkan seseorang secara sengaja dan berulang. Bentuk bullying bisa berupa fisik, verbal, sosial, maupun cyberbullying.",
                    author = "Admin Ruang Aman",
                    date = "14 April 2026"
                ),
                EducationItem(
                    title = "Jenis-jenis bullying",
                    shortDescription = "Bullying bisa berbentuk fisik, verbal, sosial, dan cyberbullying.",
                    content = "Jenis bullying terdiri dari bullying fisik seperti memukul atau mendorong, bullying verbal seperti mengejek atau menghina, bullying sosial seperti mengucilkan teman, dan cyberbullying melalui media sosial.",
                    author = "Admin Ruang Aman",
                    date = "14 April 2026"
                ),
                EducationItem(
                    title = "Cara melaporkan bullying",
                    shortDescription = "Korban atau saksi bullying sebaiknya segera melapor kepada pihak terpercaya.",
                    content = "Jika kamu mengalami atau menyaksikan bullying, catat kejadian, simpan bukti bila ada, lalu laporkan kepada guru, orang tua, konselor, atau pihak sekolah.",
                    author = "Admin Ruang Aman",
                    date = "14 April 2026"
                ),
                EducationItem(
                    title = "Dampak bullying bagi korban",
                    shortDescription = "Bullying dapat memengaruhi kesehatan mental, emosional, dan akademik korban.",
                    content = "Korban bullying dapat mengalami rasa takut, cemas, depresi, sulit berkonsentrasi, hingga menurunnya prestasi belajar. Dukungan lingkungan sangat penting.",
                    author = "Admin Ruang Aman",
                    date = "14 April 2026"
                )
            )
        )
    }
}