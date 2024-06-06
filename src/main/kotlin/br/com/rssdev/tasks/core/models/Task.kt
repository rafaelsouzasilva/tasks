package br.com.rssdev.tasks.core.models

import java.time.LocalDateTime
import java.util.UUID

data class Task(
    val id: UUID,
    val name: String,
    val description: String? = null,
    val status: TaskStatus,
    val dueDateTime: LocalDateTime? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val category: Category? = null
) {
    override fun equals(other: Any?): Boolean = this.id == (other as Task).id
}