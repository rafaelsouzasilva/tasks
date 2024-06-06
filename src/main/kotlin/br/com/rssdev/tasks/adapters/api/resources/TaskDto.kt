package br.com.rssdev.tasks.adapters.api.resources

import br.com.rssdev.tasks.core.models.Category
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.core.models.TaskStatus
import java.util.UUID

data class TaskDto(val id: UUID? = null, val name: String, val description: String?, val categoryId: String) {
    fun toDomain() = Task(
        id = id ?: UUID.randomUUID(),
        name = name,
        description = description,
        status = TaskStatus.PENDING,
        category = Category(id = UUID.fromString(categoryId), name = "")
    )
}