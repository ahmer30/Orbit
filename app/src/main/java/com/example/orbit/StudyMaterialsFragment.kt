package com.example.orbit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import soup.neumorphism.NeumorphCardView

class StudyMaterialsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_study_materials, container, false)
        
        view.findViewById<NeumorphCardView>(R.id.cardFiles).setOnClickListener {
            Toast.makeText(context, "Files and Folder clicked", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<NeumorphCardView>(R.id.cardAssessments).setOnClickListener {
            Toast.makeText(context, "Assessments clicked", Toast.LENGTH_SHORT).show()
        }
        
        return view
    }
}