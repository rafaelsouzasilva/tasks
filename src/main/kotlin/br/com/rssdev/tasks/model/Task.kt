package br.com.rssdev.tasks.model

import java.time.LocalDateTime
import java.util.UUID

data class Task(
    val id: UUID,
    val name: String,
    val description: String,
    val status: TaskStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)