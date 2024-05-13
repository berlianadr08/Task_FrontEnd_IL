package com.berliana.taskfrontendil.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.berliana.taskfrontendil.R
import com.berliana.taskfrontendil.di.Injection
import com.berliana.taskfrontendil.model.SelectDrink
import com.berliana.taskfrontendil.ui.ViewModelFactory
import com.berliana.taskfrontendil.ui.common.UiState
import com.berliana.taskfrontendil.ui.components.DrinkItem
import com.berliana.taskfrontendil.ui.components.SectionText

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    val query = viewModel.query
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllDrinks()
            }
            is UiState.Success -> {
                Column(modifier = modifier.fillMaxSize()) {
                    Banner(
                        query = query,
                        onQueryChange = viewModel::search
                    )
                    HomeSection(
                        title = stringResource(R.string.section_menu),
                        content = {
                            HomeContent(uiState.data, navigateToDetail = navigateToDetail) },
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun Banner(
    query: State<String>,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(100.dp)
        )
        Search(
            query = query,
            onQueryChange = onQueryChange,
            modifier = Modifier
        )
    }
}

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        SectionText(title, modifier)
        content()
    }
}

@Composable
fun HomeContent(
    listDrink: List<SelectDrink>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(listDrink) {
            DrinkItem(it.drink, modifier = Modifier.clickable {
                navigateToDetail(it.drink.id)
            })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    query: State<String>,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier) {
    SearchBar(
        query = query.value,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        shape = MaterialTheme.shapes.large,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {
    }
}