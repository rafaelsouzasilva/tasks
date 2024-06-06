package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.application.ports.services.TaskServiceInterface
import java.util.UUID

class TaskService: TaskServiceInterface {
    override fun create(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun find(id: UUID): Task? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun findAllByCategoryId(id: UUID): List<Task> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun update(task: Task): Task {
        TODO("Not yet implemented")
    }
}