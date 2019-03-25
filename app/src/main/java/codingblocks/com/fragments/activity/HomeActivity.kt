package codingblocks.com.fragments.activity

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import codingblocks.com.fragments.Database.ResponseDatabase
import codingblocks.com.fragments.R
import codingblocks.com.fragments.fragment.HomeFragment
import codingblocks.com.fragments.fragment.ViewFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}