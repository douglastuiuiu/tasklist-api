package br.com.douglastuiuiu.projectname.service;

import br.com.douglastuiuiu.projectname.exception.ServiceException;
import br.com.douglastuiuiu.projectname.model.Person;
import br.com.douglastuiuiu.projectname.model.SampleModel;
import br.com.douglastuiuiu.projectname.model.TestModel;
import br.com.douglastuiuiu.projectname.queue.producer.ProducerService;
import br.com.douglastuiuiu.projectname.util.MessageLocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author diegom
 */
@Service
public class SampleService {
    private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

    @Autowired
    private MessageLocale messageLocale;

    @Autowired
    private ProducerService producer;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Faz algo totalmente disrruptivo
     *
     * @param sampleModel
     * @return
     * @throws ServiceException
     */
    public Person startDisrruptiveProcess(SampleModel sampleModel) throws ServiceException {
        try {
            logger.info("Start Disrruptive Process");
            // TODO implementation
            return new Person();
        } catch (Exception e) {
            throw new ServiceException(messageLocale.getMessage("error.business_rule_error"), e);
        }
    }

    /**
     * Obtem um TestModel do mongo e adiciona a uma fila (test.queue).
     * Essa fila é consumida na classe ConsumerService
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    public TestModel findBy(String id) throws ServiceException {
        logger.info("ID " + id);
        Optional<TestModel> optional = Optional.ofNullable(mongoTemplate.findById(id, TestModel.class));
        if (optional.isPresent()) {
            try {
                producer.sendMessage(optional.get());
            } catch (Exception e) {
                throw new ServiceException(messageLocale.getMessage("error.business_rule_error"), e);
            }
        }
        return optional.orElse(new TestModel("0"));
    }

}
