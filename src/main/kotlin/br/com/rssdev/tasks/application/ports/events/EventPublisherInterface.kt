package br.com.rssdev.tasks.application.ports.events

import br.com.rssdev.tasks.core.events.Event

interface EventPublisherInterface {
    fun publish(event: Event)
}