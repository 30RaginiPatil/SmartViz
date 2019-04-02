package com.smartypants.smartvis

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.content.Intent
import android.support.design.widget.AppBarLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.register.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mStorageRef: StorageReference
    private lateinit var mDatabaseReference: FirebaseDatabase
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        mStorageRef = FirebaseStorage.getInstance().reference
        mDatabaseReference = FirebaseDatabase.getInstance()
        if(currentUser==null)
        {
            val intent = Intent(this,loginActivity::class.java)
            startActivity(intent)
        }
        else{
            setContentView(R.layout.activity_main)
            setSupportActionBar(toolbar)
            val navigationView = findViewById(R.id.nav_view) as NavigationView
            val headerView = navigationView.getHeaderView(0)
            val navEmail = headerView.findViewById(R.id.emailID) as TextView
            navEmail.text = mAuth.currentUser?.email.toString()

            val navUser = headerView.findViewById<TextView>(R.id.navName)
            //navName.text = mAuth.currentUser?.displayName.toString()

            val app_bar_main = findViewById(R.id.app_bar_main) as AppBarLayout
            val constraintLayout = findViewById(R.id.content_main) as AppBarLayout
            recyclerView = findViewById(R.id.uploads) as RecyclerView

            //adding a layoutmanager
            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


            //crating an arraylist to store users using the data class user
            var files = ArrayList<file>()


            mDatabaseReference = FirebaseDatabase.getInstance()
            val ref = mDatabaseReference.getReference("fileData")
            ref.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        files.clear()
                        for (i in dataSnapshot.children) {
                            val value = i.getValue(file::class.java)
                            //println(value)
                            if (value != null) {
                                files.add(value)
                                Log.d("idk", value.name)
                            }
                        }
                    }
                    var adapter = CustomAdapter(files)
                    recyclerView.adapter = adapter

                }
            })

//            files.add(file("image1"))
//            files.add(file("image2"))
//            files.add(file("image3"))
            //files.add(file("k","dh"))
            //creating our adapter


            //now adding the adapter to recyclerview





            fab.setOnClickListener {
                val intent = Intent()
                        .setType("*/*")
                        .setAction(Intent.ACTION_GET_CONTENT)

                startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)

            }

            val toggle = ActionBarDrawerToggle(
                    this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            drawer_layout.addDrawerListener(toggle)
            toggle.syncState()

            nav_view.setNavigationItemSelectedListener(this)
        }


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
            R.id.signOut -> {
                mAuth.signOut()
                startActivity(Intent(this,MainActivity::class.java))
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111 && resultCode == RESULT_OK) {
            val selectedFile = data?.data //The uri with the location of the file
            if (selectedFile != null) {
//                val childRef = mStorageRef.child("my Uploads/image"+data.toString().split("/").last())
//
//                //uploading the image
//                val uploadTask = childRef.putFile(selectedFile)
//
//                uploadTask.addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> {
//                    Toast.makeText(this, "Upload successful", Toast.LENGTH_SHORT).show()
//                    val ref = mDatabaseReference.getReference("fileData")
//                    val id =ref.push().key
//                    ref.child(id!!).child("name").setValue("my Uploads/image"+data.toString().split("/").last())
//                    ref.child(id).child("ext").setValue("jpg")
//                }).addOnFailureListener(OnFailureListener { e ->
//                    Toast.makeText(this, "Upload Failed -> $e", Toast.LENGTH_SHORT).show()
//                })

                val intent = Intent(this,optionsActivity::class.java)
                Toast.makeText(this,"Select an option",Toast.LENGTH_SHORT).show()
                val bundle = Bundle()
                bundle.putString("name",data.toString())
                intent.putExtras(bundle)
                ContextCompat.startActivity(this, intent, bundle)
            } else {
                Toast.makeText(this, "Select an image", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
