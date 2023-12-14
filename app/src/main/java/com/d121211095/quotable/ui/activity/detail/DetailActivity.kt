package com.d121211095.quotable.ui.activity.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.d121211029.quotable.R
import com.d121211095.quotable.data.model.quote.Quote
import com.d121211095.quotable.ui.theme.QuotableTheme

class DetailActivity : ComponentActivity() {

    private var selectedQuote: Quote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedQuote = intent.getParcelableExtra("QUOTES")
        setContent {
            QuotableTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
                DetailScreen()
            }
        }
    }

    @Composable
    private fun DetailHeader(modifier: Modifier = Modifier){
        Box(
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .background(Color.White)
                .fillMaxWidth()
        ){
            Text(
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                text = stringResource(R.string.detail),
                modifier = Modifier.padding(16.dp),


            )
        }
    }


    @Composable
    private fun DetailCard(modifier: Modifier = Modifier) {
        Card(
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),

        ){
            Column {
                Column {
                    Text(
                        text = selectedQuote?.author.toString(),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontStyle = FontStyle.Normal
                        )

                    )

                    Text(
                        text = selectedQuote?.content.toString(),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                        )

                    )

                    Column(modifier = Modifier.padding(16.dp),) {
                        Row(
                            modifier = modifier
                        ){
                            selectedQuote?.tags?.let { tags ->
                                if (tags.isNotEmpty()) {
                                    Text(text = "Tags: ${tags.joinToString(", ")}")
                                } else {
                                    Text(text = "Tags: No Tags")
                                }
                            }
                        }
                        Text(text = "Date Added: ${selectedQuote?.dateAdded}")

                        Text(text = "Author: ${selectedQuote?.author}")
                    }
                }
            }
        }
    }

    @Composable
    private fun DetailScreen(modifier: Modifier = Modifier){
        Column {
            DetailHeader()
            DetailCard()
        }
    }
}
