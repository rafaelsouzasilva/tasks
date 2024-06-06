package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventListenerInterface
import br.com.rssdev.tasks.application.ports.services.NotificationServiceInterface
import br.com.rssdev.tasks.core.events.TaskUpdatedEvent
import br.com.rssdev.tasks.core.events.Event
import br.com.rssdev.tasks.core.models.Task
import org.springframework.stereotype.Service

@Service
class TaskUpdatedEventListener(
    private val notificationService: NotificationServiceInterface
): EventListenerInterface<TaskUpdatedEvent> {
    override fun <TaskUpdatedEvent : Event> consume(event: TaskUpdatedEvent) {
        val task = event.payload as Task
        notificationService.notify("task ${task.name} created")
    }

    override fun <T : Event> isEventValid(event: T): Boolean =
        event::class.java == TaskUpdatedEvent::class.java
}