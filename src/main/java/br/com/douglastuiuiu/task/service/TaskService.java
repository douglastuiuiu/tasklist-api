package br.com.douglastuiuiu.task.service;

import br.com.douglastuiuiu.task.exception.ServiceException;
import br.com.douglastuiuiu.task.model.Task;
import br.com.douglastuiuiu.task.util.MessageLocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author douglastuiuiu@gmail.com
 */
@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private MessageLocale messageLocale;

    /**
     * @param id
     * @return Task
     * @throws ServiceException
     */
    public Task findById(String id) throws ServiceException {
        logger.info("ID " + id);
        // TODO: 16/03/2018 implementar
//        Optional<Task> optional = Optional.ofNullable(mongoTemplate.findById(id, Task.class));
        Optional<Task> optional = Optional.ofNullable(new Task());
        if (optional.isPresent()) {
            try {
                return optional.get();
            } catch (Exception e) {
                throw new ServiceException(messageLocale.getMessage("error.business_rule_error"), e);
            }
        }
        return optional.orElse(new Task());
    }

    /**
     * @return List<Task>
     * @throws ServiceException
     */
    public List<Task> findAll() throws ServiceException {
        try {
            // TODO: 16/03/2018 implementar
            return new ArrayList<>();
        } catch (Exception e) {
            throw new ServiceException(messageLocale.getMessage("error.business_rule_error"), e);
        }
    }

    /**
     * @param task
     * @throws ServiceException
     */
    public void save(Task task) {
        // TODO: 16/03/2018 implementar
    }

}
