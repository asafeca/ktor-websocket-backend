package com.laas.data

import com.laas.data.model.Message

interface MessageDatasource {
    suspend fun getAllMessages():List<Message>
    suspend fun insertMessage(message: Message)
}