package tm.ranjith.simpleroom24

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Persons")
data class Persons(
    @PrimaryKey(autoGenerate = true)
    var itemId: Int = 0,

    var firstName: String,
    var lastName: String,
    var age: Int
)
