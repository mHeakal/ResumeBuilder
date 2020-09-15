package edu.mum.resumebuilder.ui.academic

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.main.fragment_academic.*
import kotlinx.android.synthetic.main.fragment_academic.view.*

class AcademicFragment : Fragment() {

    private lateinit var toolsViewModel: ToolsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val tpro=inflater.inflate(R.layout.fragment_academic, container, false)

        tpro.submitpro.setOnClickListener {

            val spfpro = activity?.getSharedPreferences("coolprojects", Context.MODE_PRIVATE)
            val spepro = spfpro?.edit()

            spepro?.putString("projectt", editTextPro.text.toString() )
            spepro?.putString("projectd", editTextDisc.text.toString() )
            spepro?.putString("projects", editTextSch.text.toString() )
            spepro?.putString("projecty", editTextYear.text.toString() )
            spepro?.putString("projectte", editTextTechn.text.toString() )
            spepro?.apply()

            editTextPro.text.clear()
            editTextDisc.text.clear()
            editTextYear.text.clear()
            editTextTechn.text.clear()
            editTextSch.text.clear()

        }


        tpro.showpro.setOnClickListener {


            var str =""
            var spf: SharedPreferences? = null
            var Projectname:String? =""
            var Projectyear:String? =""
            var Projectdisc:String? =""
            var Projecttech:String? =""
            var Projectsch:String? =""


            spf = activity?.getSharedPreferences("coolprojects", Context.MODE_PRIVATE)
            Projectname = spf?.getString("projectt","")
            Projectyear = spf?.getString("projecty","")
            Projectdisc = spf?.getString("projectd","")
            Projectsch = spf?.getString("projects","")
            Projecttech = spf?.getString("projectte","")

            if (Projectname != null){

                str += Projectname.toString().removeSuffix(",") + " \n" + Projectyear.toString().removeSuffix(",") + " \n" + Projectdisc.toString().removeSuffix(",") + " \n" + Projectsch.toString().removeSuffix(",") + " \n" + Projecttech.toString().removeSuffix(",") + " \n"


            }

            tvpro.text =str

        }

        return tpro


    }


}