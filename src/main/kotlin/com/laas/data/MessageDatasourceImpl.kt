package com.laas.data

import com.laas.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDatasourceImpl(private val db: CoroutineDatabase) : MessageDatasource {
    private val messages = db.getCollection<Message>()
    override suspend fun getAllMessages(): List<Message> {

        return messages.find()
            .descendingSort(Message::timeStamp)
            .toList()
    }

    override suspend fun insertMessage(message: Message) {

        messages.insertOne(message)
    }
}