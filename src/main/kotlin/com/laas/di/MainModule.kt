package com.laas.di

import com.laas.data.MessageDatasource
import com.laas.data.MessageDatasourceImpl
import com.laas.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {

    single {
        KMongo
            .createClient()
            .coroutine
            .getDatabase("message_db_yt")
    }

    single<MessageDatasource>{
        MessageDatasourceImpl(get())
    }

    single{RoomController(get())}

}