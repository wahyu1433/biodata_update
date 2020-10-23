package com.example.profildiri

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()
        btnEditName.setOnClickListener { navigasiKeEditProfil()}
        btnCall.setOnClickListener { dialPhoneNumber(txtTelp.text.toString()) }

    }
    companion object {
        val REQUEST_CODE = 100
    }
    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfilActivity::class.java)
        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)
        val emailUser = txtEmail.text.toString()
        intent.putExtra("email", emailUser)
        val telpUser = txtTelp.text.toString()
        intent.putExtra("telp", telpUser)
        val alamatUser = txtAddress.text.toString()
        intent.putExtra("alamat", alamatUser)
        val genderUser = txtGender.text.toString()
        intent.putExtra("gender", genderUser)

        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtName.text = result
                val resultemail = data?.getStringExtra("email")
                txtEmail.text = resultemail
                val resulttelp = data?.getStringExtra("telp")
                txtTelp.text = resulttelp
                val resultalamat = data?.getStringExtra("alamat")
                txtAddress.text = resultalamat
                val resultgender = data?.getStringExtra("gender")
                txtGender.text = resultgender
            }else{

                Toast.makeText(this, "Edit failed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun ambilData(){
        val bundle = intent.extras
        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")

        txtName.text = nama
        txtGender.text = gender
        txtEmail.text = email
        txtTelp.text = telp
        txtAddress.text = alamat
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$363")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}