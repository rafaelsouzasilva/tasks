package br.com.rssdev.tasks.application.ports.events

import br.com.rssdev.tasks.core.models.Event

interface EventPublisherInterface {
    fun publish(event: Event)
}