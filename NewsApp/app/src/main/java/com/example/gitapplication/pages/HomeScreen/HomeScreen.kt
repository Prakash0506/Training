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
import androidx.compose.ui.res.stringResource
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
import com.example.gitapplication.R
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
            text = stringResource(R.string.title), fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(), textAlign = TextAlign.Center
        )

        Button(
            onClick = {
               vm.navigateToCreateScreen(navController)

            }, modifier = Modifier.padding(5.dp).fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green,
            )
        ) {
            Text(
                text = stringResource(R.string.addNewsTxt), color = Color.White,

            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()

        ) {

            val filterCategory = FilterCategory.values()
            filterCategory.forEach {filterKey->
                Button(
                onClick = {
                          vm.filterNews(filterKey.name)
                },
                colors =  ButtonDefaults.buttonColors(
                    backgroundColor =if (vm.filterValue == filterKey.name) {
                        Color.Cyan

                    }
                else{
                    Color.LightGray
                    }
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(78.dp)
            ) {
                Text(
                    text = filterKey.str, color = Color.Gray, fontSize = 9.sp
                )
            }
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
                        Text(text = news.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text(text = news.description)
                        Text(text = news.data)


                    }

                }

            }
        }
    }
}

enum class FilterCategory(val str : String){
    Trending("Filter by Trending"),
    Local("Filter by Local"),
    Sports("Filter by Sports"),
    All("Clear Filters")
}