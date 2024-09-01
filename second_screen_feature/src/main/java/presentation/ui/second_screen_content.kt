package presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import domain.models.RetrievedUserData

@Composable
fun SecondScreenContent(
    modifier: Modifier,
    data:LazyPagingItems<RetrievedUserData>,
    onNavigateBack:(id:Int) -> Unit
){
   Box(
       modifier = modifier.fillMaxSize(),
       contentAlignment = Alignment.Center,

   ){
       LazyColumn(
           modifier = modifier.fillMaxSize(),
       ) {
          items(data.itemCount){ index->
              DataItem(
                  modifier = modifier.clickable {
                      val id = data[index]?.id
                      onNavigateBack(id?:-1)
                  },
                  data = data[index]
              )
          }
       }
   }
}

@Composable
fun DataItem(
    data: RetrievedUserData?,
    modifier: Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = data?.name ?:""
        )
        Spacer(modifier = modifier.padding(5.dp))

        Text(
            text = data?.details ?:""
        )
        Spacer(modifier = modifier.padding(5.dp))
        Text(
            text = data?.detailsSymbolsCount?.toString() ?: ""
        )
    }
}
