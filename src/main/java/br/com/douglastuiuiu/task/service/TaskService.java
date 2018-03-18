package br.com.douglastuiuiu.task.service;

import br.com.douglastuiuiu.task.exception.ServiceException;
import br.com.douglastuiuiu.task.model.Task;
import br.com.douglastuiuiu.task.util.MessageLocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
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
     * @return List<Task>
     * @throws ServiceException
     */
    public List<Task> list() throws ServiceException {
        try {
            // TODO: 16/03/2018 implementar
            
            return listMock();
        } catch (Exception e) {
            throw new ServiceException(messageLocale.getMessage("error.business_rule_error"), e);
        }
    }

    /**
     * @param task
     * @throws ServiceException
     */
    public void save(Task task) throws ServiceException {
        try {
            // TODO: 16/03/2018 implementar
        } catch (Exception e) {
            throw new ServiceException(messageLocale.getMessage("error.business_rule_error"), e);
        }
    }

    /**
     * @param id
     * @throws ServiceException
     */
    public void delete(String id) throws ServiceException {
        try {
            // TODO: 16/03/2018 implementar
        } catch (Exception e) {
            throw new ServiceException(messageLocale.getMessage("error.business_rule_error"), e);
        }
    }
    
    private List<Task> listMock(){
        List<Task> tasks = new ArrayList();
        Task task = new Task();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        task.setTitle("Gamification");
        task.setDescription("Desenvolver plataforma de gamification para o site da Labelamafia");
        task.setStartDate(LocalDateTime.parse("2016-06-14 09:00:00", formatter));
        task.setEstimatedTime(60L);
        task.setStatus("OPENED");
        tasks.add(task);
        
        task.setTitle("ERP Interno");
        task.setDescription("Desenvolver ERP para uso interno onde possa-se gerenciar as tasks de cada usuario");
        task.setStartDate(LocalDateTime.parse("2016-03-22T09:00:00", formatter));
        task.setEstimatedTime(90L);
        task.setStatus("OPENED");
        tasks.add(task);
        
        task.setTitle("Migrar APIs");
        task.setDescription("Migrar APIs escritas em nodejs para ruby on rails");
        task.setStartDate(LocalDateTime.parse("2016-02-10T16:30:00", formatter));
        task.setEstimatedTime(180L);
        task.setStatus("IN_PROGRESS");
        tasks.add(task);
        
        task.setTitle("Desenvolver DCIM");
        task.setDescription("Desenvolver DCIM - Gerenciamento de datacenters e ambientes críticos");
        task.setStartDate(LocalDateTime.parse("2016-07-01T15:00:00", formatter));
        task.setEstimatedTime(240L);
        task.setStatus("FINISHED");
        tasks.add(task);
        
        return tasks;
    }

}
