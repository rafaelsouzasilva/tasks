package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventListenerInterface
import br.com.rssdev.tasks.core.events.TaskUpdatedEvent
import br.com.rssdev.tasks.core.models.Event
import org.springframework.stereotype.Service

@Service
class TaskUpdatedEventListener: EventListenerInterface<TaskUpdatedEvent> {
    override fun <TaskUpdatedEvent : Event> consume(event: TaskUpdatedEvent) {
        println("task updated $event")
    }

    override fun <T : Event> isEventValid(event: T): Boolean =
        event::class.java == TaskUpdatedEvent::class.java
}