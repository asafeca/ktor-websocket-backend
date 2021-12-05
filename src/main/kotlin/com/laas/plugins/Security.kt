package com.laas.plugins

import com.laas.ChatSession
import io.ktor.sessions.*
import io.ktor.application.*
import io.ktor.util.*
// https://www.piesocket.com/websocket-tester to test websocket
fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("CHAT_SESSION")
    }

    intercept(ApplicationCallPipeline.Features){
        if(call.sessions.get<ChatSession>() == null){
            val username = call.parameters["username"]?:"Guest"

            call.sessions.set(ChatSession(username, generateNonce()))

        }
    }
}
