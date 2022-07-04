package com.adr.clim8.ui.presentation.screen.logIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adr.clim8.data.dispatcher.CoroutineDispatcherProvider
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcherProvider
) : ViewModel() {

    private val _uiState: MutableStateFlow<Any> = MutableStateFlow(Any())
    val uiState: StateFlow<Any> = _uiState.asStateFlow()

    fun googleSignIn(gsia: GoogleSignInAccount?) =
        viewModelScope.launch(coroutineDispatcher.default) {
            // ToDo: update uiState, save user in shared preferences and go to mainScreen
        }
}