package com.example.cemil.kotlinalertdialog

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sendMessage() {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneText.text.toString()))
        intent.putExtra("sms_body", messageText.text.toString())
        startActivity(intent)
    }
    //Gönder butonumuzu yönlendirdiğimiz fonksiyonumuz
    fun alertMessage(view: View) {
        val alert = AlertDialog.Builder(this)//Öncelikle dialog oluşturuyoruz
        alert.setTitle("Gönderme İşlemi")//Dialogun başlığı
        alert.setMessage("Göndermek İstediğine Emin Misin?")//Dialogun içeriği
        alert.setIcon(android.R.drawable.ic_menu_send)//Dialoga icon ekliyoruz
        alert.setPositiveButton("Evet") { dialogInterface: DialogInterface, i: Int -> sendMessage() }//Evet butonuna tıladığımızda senMessage functionumuza yönlendiriliyoruz
        alert.setNegativeButton("İptal") { dialogInterface: DialogInterface, i: Int -> Toast.makeText(this, "İşlem İptal Edildi", Toast.LENGTH_SHORT).show() }//İptal butonuna tıkladığımızda ise Toast mesajı oluşturuyoruz
        alert.show()//ardından dialogu gösteriyoruz
    }
}
