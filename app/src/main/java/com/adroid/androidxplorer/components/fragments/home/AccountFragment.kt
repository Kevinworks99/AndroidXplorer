package com.adroid.androidxplorer.components.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.adroid.androidxplorer.databinding.FragmentAccountBinding
import com.adroid.androidxplorer.model.Person
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private lateinit var nameEdt: EditText
    private lateinit var phoneEdt: EditText
    private lateinit var addressEdt: EditText
    private lateinit var button: Button
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var person: Person

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEdt = binding.name
        phoneEdt = binding.number
        addressEdt = binding.address
        button = binding.button

        // below line is used to get the
        // instance of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("PersonData")

        // initializing our object
        // class variable.
        person = Person()

        button.setOnClickListener {
            val name: String = nameEdt.text.toString()
            val phone: String = phoneEdt.text.toString()
            val address: String = addressEdt.text.toString()

            if (name.isEmpty() && phone.isEmpty() && address.isEmpty()) {
                Toast.makeText(requireContext(), "Please add some data.", Toast.LENGTH_SHORT).show()
            } else {
                addDataToFirebase(name, phone, address)
            }
        }
    }

    private fun addDataToFirebase(name: String, phone: String, address: String) {
        person.name = name
        person.number = phone
        person.address = address


        // Use push() to create a unique key for each person
        databaseReference.push().setValue(person)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Data added successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { error ->
                Toast.makeText(requireContext(), "Failed to add data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
    }
}