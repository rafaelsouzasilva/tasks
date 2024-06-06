package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventListenerInterface
import br.com.rssdev.tasks.application.ports.services.NotificationServiceInterface
import br.com.rssdev.tasks.core.events.TaskCreatedEvent
import br.com.rssdev.tasks.core.events.Event
import br.com.rssdev.tasks.core.models.Task
import org.springframework.stereotype.Service

@Service
class TaskCreatedEventListener(
    private val notificationService: NotificationServiceInterface
) : EventListenerInterface<TaskCreatedEvent> {
    override fun <TaskCreatedEvent : Event> consume(event: TaskCreatedEvent) {
        val task = event.payload as Task
        notificationService.notify("task ${task.name} created")
    }

    override fun <T : Event> isEventValid(event: T): Boolean =
        event::class.java == TaskCreatedEvent::class.java
}
