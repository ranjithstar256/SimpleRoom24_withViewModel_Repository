package tm.ranjith.simpleroom24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.room.Room
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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

            saveTempleData(db)
        }
    }
}
@Composable
fun saveTempleData(db: TempleDatabase){

    val scope = rememberCoroutineScope()
    var TempleName by remember { mutableStateOf("") }
    var TempleLocation by remember { mutableStateOf("") }
    var TempleMain by remember { mutableStateOf("") }




    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        TextField(value = TempleName, onValueChange = { TempleName = it })
        TextField(value = TempleLocation, onValueChange = { TempleLocation = it })
        TextField(value = TempleMain, onValueChange = { TempleMain = it })
        val templeOneData = Temple(
            0,
            TempleName,
            TempleLocation,
            TempleMain
        )
        Button(onClick = {

            scope.launch {
                db.templedao().insertNewTemple(templeOneData)
            }

        }) {
            Text(text = "save")
        }

    }


    
}