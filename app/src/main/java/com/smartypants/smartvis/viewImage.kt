package com.smartypants.smartvis

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.firebase.ui.storage.images.FirebaseImageLoader
import com.google.firebase.storage.FirebaseStorage
//import sun.security.krb5.internal.KDCOptions.with



class viewImage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_image)
        val image = findViewById<ImageView>(R.id.imageView)
        val fileName = intent.getStringExtra("name")
        val mStorageRef = FirebaseStorage.getInstance().reference
        val Ref = mStorageRef.child(fileName)
        Glide.with(this).load(Ref).into(image)
//        Glide.with(this).using(FirebaseImageLoader())
//                .load(storageReference)
//                .into(image)
//        image.setImageResource(R.drawable.abc_ic_star_half_black_48dp);
    }

}