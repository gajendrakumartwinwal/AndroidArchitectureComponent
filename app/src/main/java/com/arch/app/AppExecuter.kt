package com.arch.app

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecuter {
    companion object {
        lateinit var netoworExecutor: Executor
        lateinit var diskIOExecutor: Executor

    }

    constructor() {
        netoworExecutor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * (1 + 10 / 5))
        diskIOExecutor = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * (1 + 10 / 100)
        )
    }
}