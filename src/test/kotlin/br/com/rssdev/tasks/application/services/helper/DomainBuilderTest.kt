package br.com.rssdev.tasks.application.services.helper

import br.com.rssdev.tasks.core.models.Category
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.core.models.TaskStatus
import java.time.LocalDateTime
import java.util.UUID

class TaskBuilder(private val task: Task = withDefaultValues()) {
    private companion object {
        fun withDefaultValues(): Task = Task(
            id = UUID.randomUUID(),
            name = "task-name",
            description = null,
            status = TaskStatus.PENDING,
            dueDateTime = LocalDateTime.now(),
            category = CategoryBuilder().build()
        )
    }

    fun withId(id: UUID): TaskBuilder = TaskBuilder(task.copy(id = id))
    fun withName(name: String): TaskBuilder = TaskBuilder(task.copy(name = name))
    fun withDescription(description: String): TaskBuilder = TaskBuilder(task.copy(description = description))
    fun withStatus(status: TaskStatus): TaskBuilder = TaskBuilder(task.copy(status = status))
    fun withDueDateTime(dueDateTime: LocalDateTime): TaskBuilder = TaskBuilder(task.copy(dueDateTime = dueDateTime))
    fun withCreatedAt(createdAt: LocalDateTime): TaskBuilder = TaskBuilder(task.copy(createdAt = createdAt))
    fun withUpdatedAt(updatedAt: LocalDateTime): TaskBuilder = TaskBuilder(task.copy(updatedAt = updatedAt))
    fun withCategory(category: Category?): TaskBuilder = TaskBuilder(task.copy(category = category))
    fun build(): Task = task
}

class CategoryBuilder(private val category: Category = withDefaultValues()) {
    private companion object {
        fun withDefaultValues(): Category = Category(
            id = UUID.randomUUID(),
            name = "category-name"
        )
    }
    fun withId(id: UUID): CategoryBuilder = CategoryBuilder(category.copy(id = id))
    fun withName(name: String): CategoryBuilder = CategoryBuilder(category.copy(name = name))
    fun build(): Category = category
}