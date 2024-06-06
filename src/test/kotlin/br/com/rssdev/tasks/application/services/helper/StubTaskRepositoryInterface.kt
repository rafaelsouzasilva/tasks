package br.com.rssdev.tasks.application.services.helper

import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.core.models.TaskStatus
import java.time.LocalDateTime
import java.util.UUID

class StubTaskRepository(private val tasks: MutableList<Task> = mutableListOf()) : TaskRepositoryInterface {
    override fun findById(id: UUID): Task? = tasks.find { it.id == id }

    override fun findAll(): List<Task> = tasks

    override fun findAllByCategoryId(categoryId: UUID): List<Task> = tasks.filter { it.category?.id == categoryId }

    override fun create(task: Task): Task {
        tasks.add(task)
        return findById(task.id)!!
    }

    override fun update(task: Task): Task {
        deleteById(task.id)
        return create(task)
    }

    override fun deleteById(id: UUID) {
        findById(id).let { tasks.remove(it) }
    }

    override fun findAllByStatusAndDueTime(status: TaskStatus, dueDateTime: LocalDateTime): List<Task> = emptyList()
}