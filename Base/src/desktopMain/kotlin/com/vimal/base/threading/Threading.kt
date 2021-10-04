package com.vimal.base.threading

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val Main: CoroutineDispatcher = Dispatchers.Main

actual val Background: CoroutineDispatcher = Dispatchers.IO