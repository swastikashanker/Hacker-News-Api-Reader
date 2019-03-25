package codingblocks.com.fragments.fragment

import android.arch.persistence.room.Room
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import codingblocks.com.fragments.Database.ResponseDatabase
import codingblocks.com.fragments.Models.Response
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import codingblocks.com.fragments.Models.Adapter.NewsAdapter
import codingblocks.com.fragments.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class ViewFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view, container, false)
    }



}


