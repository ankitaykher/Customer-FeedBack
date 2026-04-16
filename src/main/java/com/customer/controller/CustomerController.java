package com.customer.controller;
import com.customer.entity.Customer;
import com.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;
	@PostMapping
	     public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
         
        Customer saved = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Customer>>getAll() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id,
                                           @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}

