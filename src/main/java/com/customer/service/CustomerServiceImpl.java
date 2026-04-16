package com.customer.service;
import com.customer.entity.Customer;

import com.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	private final CustomerRepository customerRepository;
	@Override 
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

		

	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	@Override
	
	public Customer updateCustomer(Long id,Customer customer) {
		Customer existing = getCustomerById(id);
		existing.setFeedback(customer.getFeedback());
		existing.setDate(customer.getDate());
		existing.setAction(customer.getAction()); 
		return customerRepository.save(existing);
	}
	
	  @Override
	    public void deleteCustomer(Long id) {
	        Customer existing = getCustomerById(id);
	        customerRepository.delete(existing);
	    }
	
}