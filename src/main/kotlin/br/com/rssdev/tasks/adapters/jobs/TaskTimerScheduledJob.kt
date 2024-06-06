package br.com.rssdev.tasks.adapters.jobs

import br.com.rssdev.tasks.application.ports.services.NotificationServiceInterface
import br.com.rssdev.tasks.application.ports.services.TaskServiceInterface
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class TaskTimerScheduledJob(
    private val taskService: TaskServiceInterface,
    private val notificationService: NotificationServiceInterface
) {

    private companion object {
        const val FIVE_SECONDS = 5000L
    }

    @Scheduled(fixedRate = FIVE_SECONDS)
    fun notifyFixedRateTaskSchedule() {
        println("executing fixed rate task to verify time reached executed-at: ${System.currentTimeMillis() / 1000}")
        findTasks().forEach { task ->
            notificationService.notify("task ${task.name} remember time in five minutes")
        }
    }

    private fun findTasks() = taskService.findAllPendingTasksWithCloseTimeReached()
}