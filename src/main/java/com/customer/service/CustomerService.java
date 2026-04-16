
package com.customer.service;

import java.util.List;

import com.customer.entity.Customer;


public interface CustomerService {
	Customer  createCustomer(Customer customer);
	Customer  getCustomerById(Long id);
	List <Customer> getAllCustomer();
	Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
	

}
