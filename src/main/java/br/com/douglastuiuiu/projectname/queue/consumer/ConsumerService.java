package br.com.douglastuiuiu.projectname.queue.consumer;

import br.com.douglastuiuiu.projectname.model.TestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


/**
 * Created by douglastuiuiu on 9/13/16.
 */
@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitListener(queues = {"test.queue"})
    public void receiveMessage(Message<TestModel> message) {
        logger.info("consumer message: " + message.getPayload().toString());
    }

}
