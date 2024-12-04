package tm.ranjith.simpleroom24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val db =
                Room.databaseBuilder(
                applicationContext,
                TempleDatabase::class.java,
                "templedbexpl.db"
            ).build()

            ///saveTempleData(db)
        }
    }
}
@Composable
fun saveTempleData(db: TempleDatabase){

    val scope = rememberCoroutineScope()

    val templeOneData = Temple(
        0,
        "KasiVish",
        "Kasi",
        "Vish"
    )

    Button(onClick = {

        scope.launch {
            db.templedao().insertNewTemple(templeOneData)
        }

    }) {
        Text(text = "save")
    }
    
}