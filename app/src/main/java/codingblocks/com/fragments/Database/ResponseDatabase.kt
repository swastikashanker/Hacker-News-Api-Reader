package codingblocks.com.fragments.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import codingblocks.com.fragments.Models.Response


@Database(entities = [Response::class], version = 1, exportSchema = false)

abstract class ResponseDatabase : RoomDatabase() {

    abstract fun responseDao():ResponseDao

}