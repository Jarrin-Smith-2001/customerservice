package edu.iu.p565.customerservice.controller;

import java.util.List;

import edu.iu.p565.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import edu.iu.p565.customerservice.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }

    // get just gets information
    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();
    }

    // post is used for creating
    // Post localhost:8080/customers -> when a request is coming in this form, this method should be executed
    @PostMapping
    public int create(@Valid @RequestBody Customer customer){ // RequestBody means this info is in the body
        return repository.create(customer);
    }

    // put is used for updating
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id){
        repository.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){ // id is in the path
        repository.delete(id);
    }
}
