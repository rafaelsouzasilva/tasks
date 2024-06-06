package br.com.rssdev.tasks.adapters.api

import br.com.rssdev.tasks.adapters.api.resources.TaskDto
import br.com.rssdev.tasks.adapters.persistance.repositories.DatabaseCategoryRepository
import br.com.rssdev.tasks.adapters.persistance.repositories.DatabaseTaskRepository
import br.com.rssdev.tasks.core.models.Category
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.core.models.TaskStatus
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.UUID

@AutoConfigureMockMvc
@SpringBootTest
class TasksApplicationTests {

	@Autowired
	lateinit var mockMvc: MockMvc

	@Autowired
	lateinit var mapper: ObjectMapper

	@Autowired
	lateinit var databaseCategoryRepository: DatabaseCategoryRepository

	@Autowired
	lateinit var databaseTaskRepository: DatabaseTaskRepository

	@Test
	fun `returns created and creates registry when creating task`() {
		val categoryId = UUID.randomUUID()
		databaseCategoryRepository.create(Category(id = categoryId, name = "category-name"))
		val payload = TaskDto(
			name = "task-name",
			description = null,
			categoryId = categoryId
		)

		val request = MockMvcRequestBuilders.post("/tasks")
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(payload))

		mockMvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isCreated)
	}

	@Test
	fun `returns not found when getting task and it does not exists`() {
		val taskId = UUID.randomUUID()

		val request = MockMvcRequestBuilders.get("/tasks/$taskId")

		mockMvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isNotFound)
	}

	@Test
	fun `returns ok with found task when getting task and it exists`() {
		val categoryId = UUID.randomUUID()
		val category = Category(id = categoryId, name = "category-name")
		val savedCategory = databaseCategoryRepository.create(category)
		val taskId = UUID.randomUUID()
		val task = Task(
			id = taskId,
			name = "task-name",
			description = null,
			status = TaskStatus.PENDING,
			category = savedCategory
		)
		databaseTaskRepository.create(task)

		val result = mockMvc.perform(MockMvcRequestBuilders.get("/tasks/$taskId"))
			.andExpect(MockMvcResultMatchers.status().isOk)
			.andReturn().response

		val responseTask = mapper.readValue(result.contentAsString, Task::class.java)
		assertEquals(responseTask, task)
	}
}
