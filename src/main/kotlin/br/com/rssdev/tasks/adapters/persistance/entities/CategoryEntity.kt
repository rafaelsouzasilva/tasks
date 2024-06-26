package br.com.rssdev.tasks.adapters.persistance.entities

import br.com.rssdev.tasks.core.models.Category
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "categories")
data class CategoryEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String
) {
    companion object {
        fun fromDomain(category: Category) = CategoryEntity(category.id, category.name)
    }
    fun toDomain() = Category(id, name)
}
