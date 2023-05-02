import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gitapplication.pages.HomeScreen.HomeScreenVM

@Composable

fun HomeScreen(navController: NavHostController, vm: HomeScreenVM) {
    LaunchedEffect(key1 = Unit, block = {
        vm.getAllNewsData()
    })


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(top = 20.dp)
    ) {

        Text(
            text = "News App", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(), textAlign = TextAlign.Center
        )

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp).fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green,
            )
        ) {
            Text(
                text = "Add News", color = Color.White,

            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()

        ) {

            Button(
                onClick = {
                          vm.filterNews("Trending")
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(78.dp)
            ) {
                Text(
                    text = "Filter by Trending", color = Color.Gray, fontSize = 9.sp
                )
            }

            Button(
                onClick = {  vm.filterNews("Local")},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(78.dp)

            ) {
                Text(
                    text = "Filter by Local", color = Color.Gray, fontSize = 9.sp
                )
            }

            Button(
                onClick = {  vm.filterNews("Sports") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(78.dp)

            ) {
                Text(
                    text = "Filter by Sports", color = Color.Gray, fontSize = 9.sp
                )
            }

            Button(
                onClick = {  vm.filterNews("All") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(78.dp)

            ) {
                Text(
                    text = "Clear Filters", color = Color.Gray, fontSize = 9.sp
                )
            }
        }




        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 30.dp)

        ) {
            items(vm.uiList.value) { news ->


                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxWidth()

                        .padding(15.dp)
                ) {


                    Column() {
                        Text(text = "news.title", Modifier.padding(top = 10.dp))
                        Text(text = news.description)
                        Text(text = news.data)


                    }

                }

            }
        }
    }
}