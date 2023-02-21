package br.net.dac.saga.Application.Abstraction;

import br.net.dac.saga.Domain.Events.DomainEvent;

public interface IMessageSender {
    void sendMessage(String queueName, DomainEvent event);
}
