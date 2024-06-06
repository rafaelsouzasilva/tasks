package br.com.rssdev.tasks.adapters.api.resources

import br.com.rssdev.tasks.core.models.Category
import java.util.UUID

data class CategoryDto(val id: UUID? = null, val name: String) {
    fun toDomain() = Category(id = id ?: UUID.randomUUID(), name = name)
}
