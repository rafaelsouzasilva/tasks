package br.com.rssdev.tasks.adapters.pusher

import br.com.rssdev.tasks.application.ports.services.NotificationServiceInterface
import org.springframework.stereotype.Component

@Component
class NotificationPusher : NotificationServiceInterface {
    override fun notify(message: String) =
        println(message)
}
