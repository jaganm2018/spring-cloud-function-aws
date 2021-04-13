package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service

data class Event (
    val id: String,
    val name: String,
    val data: String
)

data class EventResponse(
    val status: String,
    val ids : List<String>
)

@Service
class EventService {
    fun save(events: List<Event>): EventResponse {
        var ids: List<String> = events.map {
            it.id
        }
        return  EventResponse("SUCCESS", ids)
    }
}

@Configuration
class Function {

    @Bean
    fun save(eventService: EventService): (List<Event>) -> EventResponse {
        return {
            eventService.save(it)
        }
    }
}