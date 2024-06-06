package br.com.rssdev.tasks.application.ports.repositories

import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.core.models.TaskStatus
import java.time.LocalDateTime
import java.util.UUID

interface TaskRepositoryInterface {
    fun findById(id: UUID): Task?
    fun findAll(): List<Task>
    fun findAllByCategoryId(categoryId: UUID): List<Task>
    fun create(task: Task): Task
    fun update(task: Task): Task
    fun deleteById(id: UUID)
    fun findAllByStatusAndDueTime(status: TaskStatus, dueDateTime: LocalDateTime): List<Task>
}
