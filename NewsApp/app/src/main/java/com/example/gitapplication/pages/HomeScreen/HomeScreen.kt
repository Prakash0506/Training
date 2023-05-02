import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gitapplication.pages.HomeScreen.HomeScreenVM

@Composable

fun HomeScreen(navController: NavHostController, vm:HomeScreenVM) {
    LaunchedEffect(key1 = Unit, block = {
//        vm.()
    })


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(text = "News App", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add News", color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green))
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
                ){

            Button(onClick = { /*TODO*/ },
            modifier = Modifier.background(color =Color.LightGray )) {
                Text(text = "Filter by Trending", color = Color.Gray
                )
            }

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.background(color =Color.LightGray )) {
                Text(text = "Filter by Local", color = Color.Gray
                )
            }

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.background(color =Color.LightGray )) {
                Text(text = "Filter by Sports", color = Color.Gray
                )
            }

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.background(color =Color.LightGray )) {
                Text(text = "Clear Filters", color = Color.Gray
                )
            }
        }




        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)

        ) {
            items(vm.uiList.value) {news->


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
//                        .background(
////                            if (isCredentialExpired(it.expiryDate))
////                                Color.Red
////                            else
////                                Color.Green
//                        )
                        .padding(15.dp)
                ) {


                    Column() {
                        Text(text =news.title , Modifier.padding(top = 10.dp))
                        Text(text = news.description)
                        Text(text = news.data)



                }

            }

    }
}}}