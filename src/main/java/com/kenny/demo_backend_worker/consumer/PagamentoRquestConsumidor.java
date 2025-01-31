package com.kenny.demo_backend_worker.consumer;

import com.kenny.demo_backend_worker.producer.PagamentoErrorProdutor;
import com.kenny.demo_backend_worker.producer.PagamentoSucessoProdutor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRquestConsumidor {
    @Autowired
    private PagamentoErrorProdutor pagamentoErrorProdutor;
    @Autowired
    PagamentoSucessoProdutor pagamentoSucessoProdutor;

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMensagem(@Payload Message message){
        System.out.println(message);
        if(new Random().nextBoolean()){
            pagamentoSucessoProdutor.gerarResposta("Messagem de sucesso " + message);
        }else {
            pagamentoErrorProdutor.gerarResposta("Erro no pagamento " + message);
        }
    }
}
