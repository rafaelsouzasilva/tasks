package br.com.rssdev.tasks.core.events

import br.com.rssdev.tasks.core.models.Task

data class TaskUpdatedEvent(
    override val name: String = "task_created",
    override val payload: Task
) : Event(name = name, payload = payload)