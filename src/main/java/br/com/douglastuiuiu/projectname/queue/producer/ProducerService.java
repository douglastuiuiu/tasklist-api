package br.com.douglastuiuiu.projectname.queue.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by douglastuiuiu on 9/13/16.
 */
@Service
public class ProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${api.exchange.name}")
    private String exchangeName;

    public void sendMessage(Object body) throws JsonProcessingException, AmqpException {
        MessageProperties props = MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).build();

        ObjectMapper mapper = new ObjectMapper();
        Message message = MessageBuilder.withBody(mapper.writeValueAsBytes(body))
                .andProperties(props)
                .build();
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setExchange(exchangeName);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) throw new AmqpException("ERROR TO ENQUEUE MESSAGE [CAUSE]: " + cause);
        });
        rabbitTemplate.convertAndSend(message);
    }
}
