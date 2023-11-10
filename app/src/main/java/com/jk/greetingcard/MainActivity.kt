package com.jk.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jk.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingImage(
//                        message = stringResource(R.string.happy_birthday_text),
//                        from = stringResource(R.string.signature_text)
//                    )
//                    ComposeTutorial(title = stringResource(R.string.jetpack_compose_tutorial),
//                        paragraphOne = stringResource(R.string.paragraph_one),
//                        paragraphTwo = stringResource(R.string.paragraph_two)
//                    )
//                    TaskDone(title = stringResource(id = R.string.all_tasks_completed), subtitle = stringResource(
//                        id = R.string.nice_work)
//                    )
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 70.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}

@Composable
fun ComposeTutorial(title: String, paragraphOne: String, paragraphTwo: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = paragraphOne,
            modifier = Modifier.padding(16.dp,0.dp,16.dp,0.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraphTwo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskDone(title: String, subtitle: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.align(alignment = CenterHorizontally)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = CenterHorizontally)
                .padding(top = 16.dp, bottom = 8.dp)
        )
        Text(
            text = subtitle,
            fontSize = 16.sp,
            modifier = Modifier.align(alignment = CenterHorizontally)
        )
    }
}

@Composable
fun ComposeQuadrant(){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Card(
                title = stringResource(id = R.string.text_composable),
                details = stringResource(id = R.string.text_composable_details),
                color = Color(0xFFEADDFF),
                Modifier.weight(1f)
                )
            Card(
                title = stringResource(id = R.string.text_composable),
                details = stringResource(id = R.string.text_composable_details),
                color = Color(0xFFD0BCFF),
                Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Card(
                title = stringResource(id = R.string.text_composable),
                details = stringResource(id = R.string.text_composable_details),
                color = Color(0xFFB69DF8),
                Modifier.weight(1f)
            )
            Card(
                title = stringResource(id = R.string.text_composable),
                details = stringResource(id = R.string.text_composable_details),
                color = Color(0xFFF6EDFF),
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CardRow(title1: String, details1: String, color1: Color, title2: String, details2: String, color2: Color, modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f, false)
        ) {
            Card(title = title1, details = details1, color1)
        }
        Column(
            modifier = Modifier
                .weight(1f, false)
        ) {
            Card(title = title2, details = details2, color2)
        }
    }
}

@Composable
fun Card(title: String, details: String, color: Color, modifier: Modifier = Modifier){
    Column(
        modifier
            .background(color = color)
            .padding(16.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Text(text = title, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(bottom = 16.dp))
            Text(text = details, textAlign = TextAlign.Justify)
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        ComposeQuadrant()
//        TaskDone(title = stringResource(id = R.string.all_tasks_completed), subtitle = stringResource(
//            id = R.string.nice_work)
//        )
//        ComposeTutorial(title = stringResource(R.string.jetpack_compose_tutorial),
//            paragraphOne = stringResource(R.string.paragraph_one),
//            paragraphTwo = stringResource(R.string.paragraph_two)
//        )
//        GreetingImage(message = "Happy birthday Junaid!", "From Rj")
    }
}