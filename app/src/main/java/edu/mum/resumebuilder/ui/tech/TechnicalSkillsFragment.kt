package edu.mum.resumebuilder.ui.tech


import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.main.fragment_technical_skills.*
import kotlinx.android.synthetic.main.fragment_technical_skills.view.*


class TechnicalSkillsFragment : Fragment() {

    private lateinit var shareViewModel: TechnicalSkillsModel
    private var selectedType= "General"
    val types = arrayOf("General","Web", "Web Services", "Web and Application Servers", "Frameworks", "Databases", "Design Patterns", "SDLC", "Tools", "Platforms", "Big Data")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val t=inflater.inflate(R.layout.fragment_technical_skills, container, false)
        val spinner = t.findViewById<Spinner>(R.id.spinner)
        spinner?.adapter = ArrayAdapter(activity!!.applicationContext, R.layout.support_simple_spinner_dropdown_item, types) as SpinnerAdapter
        spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("error")
                selectedType = "General"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedType = parent?.getItemAtPosition(position).toString()
                Toast.makeText(activity,selectedType, Toast.LENGTH_LONG).show()
                println(selectedType)
            }

        }

        t.submit.setOnClickListener {
            // Return the object of SharedPreferences
            val spf = activity?.getSharedPreferences("technicalSkills", Context.MODE_PRIVATE)

            // To write a data using SharedPreferences Object by calling edit, return Editor object

            val spe = spf?.edit()

            // Using put method to write the data in SharedPreferences
            spe?.putString(selectedType, spf.getString(selectedType, "")   + et1.text.toString() + ", ")
            spe?.apply()

            // Once finished writing we need to go back to the main activity to show the text
            //Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()
            et1.text.clear()
        }
        t.show.setOnClickListener{
            var str =""
            var spf:SharedPreferences? = null
            var name:String? =""
            types.forEach {
                spf = activity?.getSharedPreferences("technicalSkills", Context.MODE_PRIVATE)
                name = spf?.getString(it, null)
                if (name != null)
                        str += it + " : " + name.toString().removeSuffix(",") + " \n "
            }
            tv.text = str
        }


        return t

    }



}