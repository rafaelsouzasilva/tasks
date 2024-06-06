package br.com.rssdev.tasks.adapters.events

import br.com.rssdev.tasks.application.ports.events.EventPublisherInterface
import br.com.rssdev.tasks.core.models.Event
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class SpringEventPublisher(private val applicationEventPublisher: ApplicationEventPublisher): EventPublisherInterface {
    override fun publish(event: Event) =
        applicationEventPublisher.publishEvent(GenericSpringEvent(event))
}