package br.com.douglastuiuiu.projectname.resource;

import br.com.douglastuiuiu.projectname.exception.ServiceException;
import br.com.douglastuiuiu.projectname.model.Person;
import br.com.douglastuiuiu.projectname.model.SampleModel;
import br.com.douglastuiuiu.projectname.model.TestModel;
import br.com.douglastuiuiu.projectname.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author diegom
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SampleResource {

    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/v1/projectname/sample/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> findById(@PathVariable("id") String id) throws ServiceException {
        TestModel test = sampleService.findBy(id);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/projectname/sample", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> disrruptiveProcess(@Valid @RequestBody SampleModel sampleModel) throws ServiceException {
        Person result = sampleService.startDisrruptiveProcess(sampleModel);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}