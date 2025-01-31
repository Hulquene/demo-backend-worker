package com.kenny.demo_backend_worker.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRquestConsumidor {

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMensagem(@Payload Message message){
        System.out.println(message);;
    }
}
