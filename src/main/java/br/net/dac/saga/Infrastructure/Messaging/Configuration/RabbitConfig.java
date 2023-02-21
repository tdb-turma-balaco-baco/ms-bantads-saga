package br.net.dac.saga.Infrastructure.Messaging.Configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.net.dac.saga.Domain.Events.Account.Request.CreateAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Request.SwapManagerEvent;
import br.net.dac.saga.Domain.Events.Account.Request.UpdateAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Request.UpdateAccountManagerEvent;
import br.net.dac.saga.Domain.Events.Account.Request.UpdateStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.ChangedStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.CreatedAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.ErrorAccountEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.CreateClientAuthEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.CreateManagerAuthEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.GeneratePasswordEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.RemoveManagerAccessEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.ClientPasswordCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.ManagerAuthCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.RemovedManagerAccessEvent;
import br.net.dac.saga.Domain.Events.Client.Request.CreateClientEvent;
import br.net.dac.saga.Domain.Events.Client.Request.UpdateClientEvent;
import br.net.dac.saga.Domain.Events.Client.Response.ClientCreatedEvent;
import br.net.dac.saga.Domain.Events.Client.Response.ClientUpdatedEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.ChangeManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.CreateManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.RemoveManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.SelectMaxClientEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.SelectMinClientEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.UpdateManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.ChangedManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.CreatedManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedTopEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.UpdatedManagerEvent;
import br.net.dac.saga.Domain.Events.Notification.Request.ClientApprovedEvent;
import br.net.dac.saga.Domain.Events.Notification.Request.ClientRejectedEvent;
import br.net.dac.saga.Domain.Events.Notification.Request.CreateClientFailEvent;
import br.net.dac.saga.Domain.Events.Notification.Request.CreatedManagerEmailEvent;

@Configuration
public class RabbitConfig {
    @Value("${manager.queue}")
    private String managerQueue;

    @Value("${manager-response.queue}")
    private String managerResponseQueue;

    @Value("${auth.client.queue}")
    private String authQueue;

    @Value("${auth.queue.producer}")
    private String authManagerQueue;

    @Value("${auth.manager.queue}")
    private String authResponseQueue;

    @Value("${account.queue}")
    private String accountQueue;

    @Value("${account-response.queue}")
    private String accountResponseQueue;

    @Value("${client.queue}")
    private String clientQueue;

    @Value("${client-response.queue}")
    private String clientResponseQueue;

    @Value("${notification.queue}")
    private String notificationQueue;

    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueue, true);
    }

    @Bean
    public Queue clientQueue() {
        return new Queue(clientQueue, true);
    }

    @Bean
    public Queue clientResponseQueue() {
        return new Queue(clientResponseQueue, true);
    }

    @Bean
    public Queue accountQueue() {
        return new Queue(accountQueue, true);
    }

    @Bean
    public Queue accountResponseQueue() {
        return new Queue(accountResponseQueue, true);
    }

    @Bean
    public Queue authQueue() {
        return new Queue(authQueue, true);
    }
    
    @Bean
    public Queue authManagerQueue() {
        return new Queue(authManagerQueue, true);
    }

    @Bean
    public Queue authResponseQueue() {
        return new Queue(authResponseQueue, true);
    }

    @Bean
    public Queue managerQueue() {
        return new Queue(managerQueue, true);
    }

    @Bean
    public Queue managerResponseQueue() {
        return new Queue(managerResponseQueue, true);
    }

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setClassMapper(classMapper());
        return converter;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setIdClassMapping(customClassMapping());
        classMapper.setTrustedPackages("*");
        return classMapper;
    }

    public Map<String, Class<?>> customClassMapping(){
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        
        idClassMapping.putAll(customAccount());
        idClassMapping.putAll(customManager());
        idClassMapping.putAll(customAuth());
        idClassMapping.putAll(customNotification());
        idClassMapping.putAll(customClient());
        
        return idClassMapping;
    }


    public AmqpTemplate template(ConnectionFactory connection) {
        RabbitTemplate template = new RabbitTemplate(connection);
        template.setMessageConverter(messageConverter());
        return template;
    }

    private Map<String, Class<?>> customAccount(){
        Map<String, Class<?>> accounMap = new HashMap<>();
        accounMap.put("UpdateAccountEvent", UpdateAccountEvent.class);
        accounMap.put("CreateAccountEvent", CreateAccountEvent.class);
        accounMap.put("UpdateStatusAccountEvent", UpdateStatusAccountEvent.class);
        accounMap.put("UpdateManagerEvent", UpdateAccountManagerEvent.class);
        accounMap.put("SwapManagerEvent", SwapManagerEvent.class);

        accounMap.put("ChangedStatusAccountEvent", ChangedStatusAccountEvent.class);
        accounMap.put("CreatedAccountEvent", CreatedAccountEvent.class);
        accounMap.put("ErrorAccountEvent", ErrorAccountEvent.class);
        return accounMap;
    }

    private Map<String, Class<?>> customAuth(){
        Map<String, Class<?>> authMap = new HashMap<>();
        authMap.put("CreateClientAuthEvent", CreateClientAuthEvent.class);
        authMap.put("CreateManagerAuthEvent", CreateManagerAuthEvent.class);
        authMap.put("GeneratePasswordEvent", GeneratePasswordEvent.class);
        authMap.put("RemoveManagerCredentials", RemoveManagerAccessEvent.class);
        
        //authMap.put("AuthCanceledEvent", AuthC.class);
        authMap.put("ClientPasswordCreatedEvent", ClientPasswordCreatedEvent.class);
        authMap.put("RemovedManagerAccessEvent", RemovedManagerAccessEvent.class);
        //authMap.put("ClientPasswordFailEvent", ClientPasswordFailEvent.class);
        authMap.put("ManagerAuthCreatedEvent", ManagerAuthCreatedEvent.class);
        //authMap.put("ManagerAuthFail", ManagerAuthFail.class);
        return authMap;
    }

    private Map<String, Class<?>> customNotification(){
        Map<String, Class<?>> notificationMap = new HashMap<>();
        notificationMap.put("ClientApprovedEvent", ClientApprovedEvent.class);
        notificationMap.put("CreatedManagerEmailEvent", CreatedManagerEmailEvent.class);
        notificationMap.put("ClientRejectedEvent", ClientRejectedEvent.class);
        notificationMap.put("CreateClientFailEvent", CreateClientFailEvent.class);
        return notificationMap;
    }

    private Map<String, Class<?>> customClient(){
        Map<String, Class<?>> clientMap = new HashMap<>();
        clientMap.put("CreateClientEvent", CreateClientEvent.class);
        clientMap.put("UpdateClientEvent", UpdateClientEvent.class);

        clientMap.put("ClientCreatedEvent", ClientCreatedEvent.class);
        clientMap.put("ClientUpdatedEvent", ClientUpdatedEvent.class);
        return clientMap;
    }

    private Map<String, Class<?>> customManager(){
        Map<String, Class<?>> managerMap = new HashMap<>();
        managerMap.put("CreateManagerEvent", CreateManagerEvent.class);
        managerMap.put("RemoveManagerEvent", RemoveManagerEvent.class);
        managerMap.put("UpdateManagerEvent", UpdateManagerEvent.class);
        managerMap.put("ChangeManagerClients", ChangeManagerClientsEvent.class);
        managerMap.put("SelectMaxCientEvent", SelectMaxClientEvent.class);
        managerMap.put("SelectMinClientEvent", SelectMinClientEvent.class);

        managerMap.put("ChangedManagerClientsEvent", ChangedManagerClientsEvent.class);
        managerMap.put("CreatedManagerEvent", CreatedManagerEvent.class);
        managerMap.put("SelectedManagerEvent", SelectedManagerEvent.class);
        managerMap.put("SelectedTopEvent", SelectedTopEvent.class);
        managerMap.put("UpdatedManagerEvent", UpdatedManagerEvent.class);
        return managerMap;
    }
}
