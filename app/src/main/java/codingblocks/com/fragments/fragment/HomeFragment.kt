package codingblocks.com.fragments.fragment

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codingblocks.com.fragments.Database.ResponseDatabase
import codingblocks.com.fragments.Models.Adapter.NewsAdapter
import codingblocks.com.fragments.Models.Response
import codingblocks.com.fragments.Models.Stories
import codingblocks.com.fragments.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException
import java.net.URL

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    val db by lazy {
        Room.databaseBuilder(
            requireContext(),
            ResponseDatabase::class.java,
            "responseDb.db"
        )

            .allowMainThreadQueries()
            .build()

    }


    var baseUrl = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty"
    var itemUrl = "https://hacker-news.firebaseio.com/v0/item/"
     var lists = ArrayList<Int>()
    val data =ArrayList<Response>()
    private val gson = Gson()

   // val stories = ArrayList<Stories>()


   val listType = object :TypeToken<List<Int>>(){}.type


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvNews.adapter=NewsAdapter(data,db)
        rvNews.layoutManager = LinearLayoutManager(requireContext())
        data.addAll(db.responseDao().getResponse())


        val client = OkHttpClient()
        val requestStories = Request.Builder()
            .url(URL( baseUrl))
            .build()

        val call: Call = client.newCall(requestStories)

        call.enqueue(object:Callback{
            override fun onFailure(call: Call, e: IOException) {

                e.printStackTrace()
                client.newCall(requestStories).enqueue(this)

            }

            override fun onResponse(call: Call, response: okhttp3.Response) {
               val result = response.body()?.string()

                result.let {
                  lists= gson.fromJson(result, listType)


                    lists.forEach{


                    val requestItems = Request.Builder()
                        .url(URL("$itemUrl$it.json"))
                        .build()



                    val client2 = OkHttpClient()
                        val callItem : Call =client2.newCall(requestItems)

                        callItem.enqueue(object :Callback{
                            override fun onFailure(call: Call, e: IOException) {
                                e.printStackTrace()
                                client2.newCall(requestItems).enqueue(this)

                            }

                            override fun onResponse(call: Call, response: okhttp3.Response) {
                           //get item data and set in adapter
                                val responseBody :ResponseBody? = response.body()
                                val resultItem = responseBody?.string()
                                val parsedObject : Response = gson.fromJson(resultItem,Response::class.java)

                                Log.e("TAG",parsedObject.title)






                                    data.add(parsedObject)



                                activity?.runOnUiThread {

                                    if (isAdded) {
                                        rvNews.adapter?.notifyDataSetChanged()
                                    }

                                }


                            }


                        })

                   }


                }
        }

        })
    }
}




