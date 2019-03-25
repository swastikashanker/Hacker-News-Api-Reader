package codingblocks.com.fragments.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "item_table")
class Response(
	var score: Int? = null,
	var by: String? = null,
	@PrimaryKey var id: Int? = null,
	var time: Int? = null,
	@ColumnInfo var title: String? = null,
	var type: String? = null,
	var descendants: Int? = null,
	var url: String? = null,
	@Ignore var kids: List<Int?>? = null
)

class Stories(

	var id: Int?=null
)