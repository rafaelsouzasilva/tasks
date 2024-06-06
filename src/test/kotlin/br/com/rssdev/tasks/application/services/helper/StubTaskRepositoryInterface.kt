package br.com.rssdev.tasks.application.services.helper

import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.core.models.TaskStatus
import java.time.LocalDateTime
import java.util.UUID

class StubTaskRepository(private val tasks: List<Task> = emptyList()) : TaskRepositoryInterface {
    override fun findById(id: UUID): Task? = null

    override fun findAll(): List<Task> = tasks

    override fun findAllByCategoryId(categoryId: UUID): List<Task> = emptyList()

    override fun create(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun update(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) = Unit

    override fun findAllByStatusAndDueTime(status: TaskStatus, dueDateTime: LocalDateTime): List<Task> =
        emptyList()
}