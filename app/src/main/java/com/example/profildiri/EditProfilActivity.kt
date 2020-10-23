package com.example.profildiri

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_profil.*



class EditProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")
        val genderuser = intentData?.getString("gender")
        val emailuser = intentData?.getString("email")
        val telpuser = intentData?.getString("telp")
        val alamatuser = intentData?.getString("alamat")

        edtProfilName.setText(namaUser)
        edtEmailProfil.setText(emailuser)
        edtTelpProfil.setText(telpuser)
        edtAddressProfil.setText(alamatuser)
        edtspinnerGenderProfil.selectedItem

        btnEditSave.setOnClickListener { saveData() }
    }


        private fun saveData() {
        val namaEdit = edtProfilName.text.toString()
        val emailEdit = edtEmailProfil.text.toString()
        val telpEdit = edtTelpProfil.text.toString()
        val alamatEdit = edtAddressProfil.text.toString()
        val genderEdit = edtspinnerGenderProfil.selectedItem.toString()

        if (!namaEdit.isEmpty() && !emailEdit.isEmpty() && !telpEdit.isEmpty() && !alamatEdit.isEmpty() && !genderEdit.equals("Pilih Jenis Kelamin", ignoreCase = true)) {
            val result = Intent()
            result.putExtra("nama", namaEdit)
            result.putExtra("email", emailEdit)
            result.putExtra("telp", telpEdit)
            result.putExtra("alamat", alamatEdit)
            result.putExtra("gender", genderEdit)
            setResult(Activity.RESULT_OK, result)
        } else {

            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}