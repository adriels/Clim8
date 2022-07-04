package com.adr.clim8.ui.presentation.screen.logIn

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.adr.clim8.BuildConfig
import com.adr.clim8.R
import com.adr.clim8.data.contract.GoogleApiContract
import com.adr.clim8.data.navigation.NavigationScreen
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException

@Composable
fun LogInScreen(
    navController: NavHostController,
    logInViewModel: LogInViewModel = hiltViewModel()
) {
    val uiState = remember { logInViewModel.uiState.value }

    val authResultLauncher = rememberLauncherForActivityResult(
        contract = GoogleApiContract(),
        onResult = {
            logInViewModel.googleSignIn(it?.result)
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h1
        )
        AndroidView(modifier = Modifier.clickable {
            // authResultLauncher.launch(SIGN_IN_REQUEST_CODE)
            navController.navigate(NavigationScreen.Main.route)
        }, factory = { context -> SignInButton(context) })
        Text(
            modifier = Modifier.clickable {
                navController.navigate(NavigationScreen.Main.route)
            },
            text = stringResource(id = R.string.continue_as_guest),
            textDecoration = TextDecoration.Underline,
            color = MaterialTheme.colors.onSurface.copy(0.5f),
            style = MaterialTheme.typography.subtitle2
        )
    }
}

private const val SIGN_IN_REQUEST_CODE = 1234