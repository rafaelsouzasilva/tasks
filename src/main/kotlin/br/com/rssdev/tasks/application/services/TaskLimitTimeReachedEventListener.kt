package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventListenerInterface
import br.com.rssdev.tasks.application.ports.services.NotificationServiceInterface
import br.com.rssdev.tasks.core.events.Event
import br.com.rssdev.tasks.core.events.TaskLimitTimeReachedEvent
import br.com.rssdev.tasks.core.models.Task
import org.springframework.stereotype.Service

@Service
class TaskLimitTimeReachedEventListener(
    private val notificationService: NotificationServiceInterface
) : EventListenerInterface<TaskLimitTimeReachedEvent> {
    override fun <TaskLimitTimeReachedEvent : Event> consume(event: TaskLimitTimeReachedEvent) {
        val task = event.payload as Task
        notificationService.notify("task ${task.name} remember time in five minutes")
    }

    override fun <T : Event> isEventValid(event: T): Boolean =
        event::class.java == TaskLimitTimeReachedEvent::class.java
}
