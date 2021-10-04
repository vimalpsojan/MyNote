package com.vimal.base.threading

import kotlinx.coroutines.CoroutineDispatcher

expect val Main: CoroutineDispatcher

expect val Background: CoroutineDispatcher