package br.com.rssdev.tasks.adapters.jobs

import br.com.rssdev.tasks.application.ports.events.EventPublisherInterface
import br.com.rssdev.tasks.application.ports.services.TaskServiceInterface
import br.com.rssdev.tasks.core.events.TaskLimitTimeReachedEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class TaskTimerScheduledJob(
    private val taskService: TaskServiceInterface,
    private val publisher: EventPublisherInterface
) {

    private companion object {
        const val ONE_SECOND_IN_MILLISECONDS = 1000L
        const val ONE_MINUTE = 60L * ONE_SECOND_IN_MILLISECONDS
        const val FIVE_MINUTES = 5L * ONE_MINUTE
    }

    @Scheduled(fixedRate = FIVE_MINUTES)
    fun notifyFixedRateTaskSchedule() {
        println("executing fixed rate task to verify time reached executed-at: ${System.currentTimeMillis() / 1000}")
        findTasks().forEach { task ->
            publisher.publish(TaskLimitTimeReachedEvent(payload = task))
        }
    }

    private fun findTasks() = taskService.findAllPendingTasksWithCloseTimeReached()
}