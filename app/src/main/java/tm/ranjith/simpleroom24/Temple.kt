package tm.ranjith.simpleroom24

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// val onetempledata =  Temple (0,"Tirupathi","Andhra Pradesh","Lord Venkateswara")
// db.templedao().insertNewTemple(onetempledata)

@Entity(tableName = "Temple")  // table name
data class Temple (

    @PrimaryKey(autoGenerate = true)
    var itemId: Int = 0,

    @ColumnInfo(name = "TempleName")  // column name 1
    var TempleName : String,


    @ColumnInfo(name = "Location")  // column name 2
    var Location : String,


    @ColumnInfo(name = "MainGod")  // column name 3
    var MainGod : String
// create table Temple (TempleName TEXT, Location TEXT, MainGod TEXT, PRIMARY KEY(itemId)
)