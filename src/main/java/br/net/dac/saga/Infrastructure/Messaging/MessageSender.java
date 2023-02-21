package br.net.dac.saga.Infrastructure.Messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.dac.saga.Application.Abstraction.IMessageSender;
import br.net.dac.saga.Domain.Events.DomainEvent;

@Component
public class MessageSender implements IMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String queueName, DomainEvent event) {
        rabbitTemplate.convertAndSend(queueName, event);        
    }
}
