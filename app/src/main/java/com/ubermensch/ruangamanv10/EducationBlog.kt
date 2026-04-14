package com.ubermensch.ruangamanv10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EducationBlog : Fragment() {

    private lateinit var rvEducationBlog: RecyclerView
    private lateinit var adapter: EducationBlogAdapter
    private lateinit var educationList: ArrayList<EducationItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_education_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvEducationBlog = view.findViewById(R.id.rvEducationBlog)
        rvEducationBlog.layoutManager = LinearLayoutManager(requireContext())

        educationList = arrayListOf(
            EducationItem(
                "Apa itu bullying?",
                "Bullying adalah perilaku agresif yang dilakukan berulang kali untuk menyakiti orang lain.",
                "Bullying adalah tindakan menyakiti, mengintimidasi, atau merendahkan seseorang secara sengaja dan berulang. Bentuk bullying bisa berupa fisik, verbal, sosial, maupun cyberbullying. Dampaknya sangat besar bagi korban, mulai dari menurunnya rasa percaya diri hingga gangguan kesehatan mental.",
                "Admin Ruang Aman",
                "14 April 2026"
            ),
            EducationItem(
                "Jenis-jenis bullying",
                "Bullying tidak hanya berupa kekerasan fisik, tetapi juga verbal, sosial, dan online.",
                "Jenis bullying terdiri dari bullying fisik seperti memukul atau mendorong, bullying verbal seperti mengejek atau menghina, bullying sosial seperti mengucilkan teman, dan cyberbullying yang dilakukan melalui media sosial atau pesan online.",
                "Admin Ruang Aman",
                "14 April 2026"
            ),
            EducationItem(
                "Cara melaporkan bullying",
                "Korban atau saksi bullying sebaiknya segera melapor kepada pihak terpercaya.",
                "Jika kamu mengalami atau menyaksikan bullying, segera catat kejadian yang terjadi, simpan bukti bila ada, lalu laporkan kepada guru, orang tua, konselor, atau melalui aplikasi pelaporan bullying. Melapor adalah langkah penting untuk menghentikan tindakan tersebut.",
                "Admin Ruang Aman",
                "14 April 2026"
            ),
            EducationItem(
                "Dampak bullying bagi korban",
                "Bullying dapat memengaruhi kesehatan mental, emosional, dan akademik korban.",
                "Korban bullying dapat mengalami rasa takut, cemas, depresi, sulit berkonsentrasi, hingga menurunnya prestasi belajar. Oleh karena itu, penting untuk memberi dukungan dan menciptakan lingkungan yang aman bagi semua orang.",
                "Admin Ruang Aman",
                "14 April 2026"
            )
        )

        adapter = EducationBlogAdapter(educationList) { selectedItem ->
            val detailFragment = EducationDetailFragment()

            val bundle = Bundle()
            bundle.putSerializable("education_data", selectedItem)
            detailFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.home_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        rvEducationBlog.adapter = adapter
    }
}