
package codingblocks.com.fragments.Database
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import codingblocks.com.fragments.Models.Response


@Dao
interface ResponseDao {
    @Insert
    fun insertResponse(response: Response)

    @Insert
    fun insertResponse(responses: List<Response>)


    @Delete
    fun deleteResponse(response: Response)

    @Query("SELECT * FROM item_table ORDER BY id Desc")
    fun getResponse():List<Response>

    @Query("SELECT * FROM item_table WHERE id = :responseId")
    fun getResponseById(responseId : Int) : Response
}

