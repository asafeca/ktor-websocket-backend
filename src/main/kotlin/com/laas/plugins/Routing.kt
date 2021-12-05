package com.laas.plugins

import com.laas.room.RoomController
import com.laas.routes.chatSocket
import com.laas.routes.getAllMessages
import io.ktor.routing.*
import io.ktor.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing){
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}