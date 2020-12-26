package com.example.bms_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.DataOutputStream

class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        val addBtn = findViewById<Button>(R.id.validateBtn)

        val title = findViewById<TextView>(R.id.titleEditText)
        val ref = findViewById<TextView>(R.id.referenceedittext)
        val cat = findViewById<TextView>(R.id.categoryEditText)

        addBtn.setOnClickListener {
            ajouterProd(title.text.toString(), ref.text.toString(), 1)
        }

    }

    fun ajouterProd(titre : String, ref : String, cat : Int){
        var postURL: String = "http://bms-tracker.herokuapp.com/api/products/products/"

        val request = object : FileUploadRequest(
            Method.POST,
            postURL,
            Response.Listener {

                Toast.makeText(this, "Un produit a été ajouté", Toast.LENGTH_SHORT).show()
                finish()
            },
            Response.ErrorListener {
                //Toast.makeText(this, "There were a problem", Toast.LENGTH_SHORT).show()
                Log.i("error", "error while posting comment")
                Log.i("error", it.toString())
            }
        ){
            override fun getParams(): MutableMap<String, String> {


                var params = HashMap<String, String>()
                params["name"] = titre
                params["reference"] = ref

                return params
            }

            /*override fun getHeaders(): MutableMap<String, String> {
                var headers: MutableMap<String, String> = mutableMapOf()
                headers["Accept"] = "*/
             /*   headers["Cache-Control"] = "no-cache"
                return headers
            }

            override fun getBodyContentType(): String {
                return "application/json"
            }

            override fun getBody(): ByteArray {
                val byteArrayOutputStream = ByteArrayOutputStream()
                val dataOutputStream = DataOutputStream(byteArrayOutputStream)
                val jsonUser = JSONObject()
                jsonUser.put("name", titre)
                jsonUser.put("reference", ref)
                jsonUser.put("image", "")
                jsonUser.put("category", cat)
                dataOutputStream.writeBytes(jsonUser.toString())
                Log.i("reeeeq", jsonUser.toString())
                return byteArrayOutputStream.toByteArray()
            }*/

        }
        Volley.newRequestQueue(this).add(request)
    }
}