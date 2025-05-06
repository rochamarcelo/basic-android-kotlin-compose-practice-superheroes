package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero

@Composable
fun HeroesListItem(hero: Hero, modifier: Modifier = Modifier) {
    val height = dimensionResource(R.dimen.image_size);
    val mainPadding = dimensionResource(R.dimen.padding_medium);
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        elevation = CardDefaults.cardElevation(2.dp),
    ) {
        Row (modifier = Modifier.padding(mainPadding).height(height)) {
            Column (modifier = Modifier.padding(end = mainPadding)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = "Hero picture",
                modifier = Modifier
                    .size(height)
                    .clip(MaterialTheme.shapes.small)
            )
        }
    }
}

@Composable
fun HeroesList (heroes: List<Hero>, modifier: Modifier = Modifier) {
    val paddingSmall = dimensionResource(R.dimen.padding_small);
    val paddingMedium = dimensionResource(R.dimen.padding_medium);
    LazyColumn(modifier = modifier) {
        items(heroes) { hero -> HeroesListItem(
            hero = hero,
            modifier = Modifier.padding(start = paddingMedium, end = paddingMedium, bottom = paddingSmall),
        )}
    }
}