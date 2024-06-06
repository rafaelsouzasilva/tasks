package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventListenerInterface
import br.com.rssdev.tasks.core.events.TaskCreatedEvent
import br.com.rssdev.tasks.core.events.TaskUpdatedEvent
import br.com.rssdev.tasks.core.models.Event
import org.springframework.stereotype.Service

@Service
class TaskCreatedEventListener: EventListenerInterface<TaskCreatedEvent> {
    override fun <TaskCreatedEvent : Event> consume(event: TaskCreatedEvent) {
        println("task created $event")
    }

    override fun <T : Event> isEventValid(event: T): Boolean =
        event::class.java == TaskCreatedEvent::class.java
}