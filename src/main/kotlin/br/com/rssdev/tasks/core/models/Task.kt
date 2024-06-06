package br.com.rssdev.tasks.core.models

import java.time.LocalDateTime
import java.util.UUID

data class Task(
    val id: UUID,
    val name: String,
    val description: String? = null,
    val status: TaskStatus,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val category: Category? = null
)