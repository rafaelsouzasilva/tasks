package br.com.rssdev.tasks.core.events

import br.com.rssdev.tasks.core.models.Task

data class TaskCreatedEvent(
    override val name: String = "task_updated",
    override val payload: Task
) : Event(name = name, payload = payload)
