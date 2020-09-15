package edu.mum.resumebuilder.ui.contactinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_contact_info.*
import kotlinx.android.synthetic.main.fragment_contact_info.view.*
import kotlinx.android.synthetic.main.fragment_technical_skills.*

class ContactInfoFragment : Fragment() {

    //private lateinit var ContactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //ContactViewModel =
         //   ViewModelProviders.of(this).get(ContactViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contact_info, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
        root.btn_contact_add.setOnClickListener(){
           //Setting Shared Preferences to save the data and retrieve the data
            var name:String?=edit_contact_name.text.toString()
            var phone:String?=edit_contact_phone.text.toString()
            var address:String?=edit_contact_address.text.toString()
            var email:String?=edit_menu_email.text.toString()
            var linkedin:String?=edit_contact_linkedin.text.toString()

            val Sharedpreference = activity?.getSharedPreferences("contactinfo", Context.MODE_PRIVATE)
            // To write a data using SharedPreferences Object by calling edit, return Editor object
            val edit = Sharedpreference?.edit()
            edit?.putString("name", name)
            edit?.putString("phone", phone)
            edit?.putString("address", address)
            edit?.putString("email", email)
            edit?.putString("linkedin", linkedin)
            edit?.apply()
            Toast.makeText(activity,"Data Saved",Toast.LENGTH_LONG).show()
            clearText()
        }
        root.btn_contact_show.setOnClickListener(){
            var sharedPreferences:SharedPreferences?=null
            var name:String?=null
            var phone:String?=null
            var address:String?=null
            var email:String?=null
            var linkedin:String?=null
            var merge:String?=null

            sharedPreferences=activity?.getSharedPreferences("contactinfo",Context.MODE_PRIVATE)
            name=sharedPreferences?.getString("name",null)
            phone=sharedPreferences?.getString("phone",null)
            address=sharedPreferences?.getString("address",null)
            email=sharedPreferences?.getString("email",null)
            linkedin=sharedPreferences?.getString("linkedin",null)

            merge="Name :" + name + "\n" + "Phone # :" + phone + "\n" + "Email :" + email + "\n" +"Address :" + address + "\n" + "Email :" + email + "\n" +"LinkedIn :" + linkedin + "\n"
           if (merge!=null)
               tv_showdata.text=merge
        }
        return root
    }
    fun clearText(){
        edit_contact_name.text.clear()
        edit_contact_address.text.clear()
        edit_contact_linkedin.text.clear()
        edit_contact_phone.text.clear()
        edit_menu_email.text.clear()
    }
}