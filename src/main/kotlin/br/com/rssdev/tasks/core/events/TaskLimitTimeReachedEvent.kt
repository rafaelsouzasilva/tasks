package br.com.rssdev.tasks.core.events

import br.com.rssdev.tasks.core.models.Task

data class TaskLimitTimeReachedEvent(
    override val name: String = "task_limit_time_reached",
    override val payload: Task
) : Event(name = name, payload = payload)
