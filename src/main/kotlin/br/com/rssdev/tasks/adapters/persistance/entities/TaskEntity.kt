package br.com.rssdev.tasks.adapters.persistance.entities

import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.core.models.TaskStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "tasks")
data class TaskEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    @Enumerated(EnumType.STRING)
    val status: TaskStatus,
    @Column(name = "created_at")
    val createdAt: LocalDateTime,
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime
) {
    fun toDomain() = Task(id, name, description, status, createdAt, updatedAt)
}