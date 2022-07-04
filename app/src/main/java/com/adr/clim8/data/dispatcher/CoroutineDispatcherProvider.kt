package com.adr.clim8.data.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

data class CoroutineDispatcherProvider(
    val default: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
) {
    @Inject
    constructor() : this(Dispatchers.Default, Dispatchers.Main, Dispatchers.IO)
}
