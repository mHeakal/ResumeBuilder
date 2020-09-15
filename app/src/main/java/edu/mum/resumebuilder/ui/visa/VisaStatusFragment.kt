package edu.mum.resumebuilder.ui.visa


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.mum.resumebuilder.R
import edu.mum.resumebuilder.WebViewActivity
import kotlinx.android.synthetic.main.fragment_technical_skills.*
import kotlinx.android.synthetic.main.fragment_technical_skills.view.*
import kotlinx.android.synthetic.main.fragment_visa_status.*
import kotlinx.android.synthetic.main.fragment_visa_status.view.*


class VisaStatusFragment : Fragment() {

    private lateinit var shareViewModel: VisaViewModel
    private var selectedType= "General"

    val types = arrayOf("F-1","F-2", "H1-B")
    val disc = arrayOf("Language and academic students","Dependents of F-1 Visa holders", "Physicians and highly specialised occupations requiring specific industry knowledge")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shareViewModel =
            ViewModelProviders.of(this).get(VisaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_visa_status, container, false)

        val spinner = root.findViewById<Spinner>(R.id.visa_spinner)
        spinner?.adapter = ArrayAdapter(activity!!.applicationContext, R.layout.support_simple_spinner_dropdown_item, types) as SpinnerAdapter
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("error")
                selectedType = "General"
                txtDesc.text = ""
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedType = parent?.getItemAtPosition(position).toString()
                txtDesc.text = disc[position].toString()
            }

        }

        root.readMore.setOnClickListener {
            // Return the object of SharedPreferences
            val spf = activity?.getSharedPreferences("visastatus", Context.MODE_PRIVATE)

            // To write a data using SharedPreferences Object by calling edit, return Editor object
            val spe = spf?.edit()

            // Using put method to write the data in SharedPreferences
            spe?.putString("type", selectedType)
            spe?.apply()

            var i = Intent(this.context, WebViewActivity::class.java)
            startActivity(i)
        }


        return root
    }


}