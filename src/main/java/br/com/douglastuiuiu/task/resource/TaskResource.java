package br.com.douglastuiuiu.task.resource;

import br.com.douglastuiuiu.task.exception.ServiceException;
import br.com.douglastuiuiu.task.model.Task;
import br.com.douglastuiuiu.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;

/**
 * @author douglastuiuiu@gmail.com
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/v1/task", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> list() throws ServiceException {
        List<Task> tasks = taskService.list();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/task", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> save(@Valid @RequestBody Task task) throws ServiceException {
        taskService.save(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/v1/task/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) throws ServiceException {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}