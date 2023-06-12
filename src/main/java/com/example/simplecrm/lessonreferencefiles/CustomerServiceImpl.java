package com.example.simplecrm;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service is where we will put our business logic (i.e. decisions, procesing, computations, etc.)
// Service layer will call the repository layer to update the data store.
// CustomerService will need an instance of CustomerRepository
// Remember concept of composition?
// SelfServiceMachine
// Vending Machine IS A SelfServiceMachine (Inheritance)
// Vending Machine HAS A Cashbox (Composition)

@Service
public class CustomerServiceImpl implements CustomerService {

  // private CustomerRepository customerRepository = new CustomerRepository();

  // Field-based injection
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private InteractionRepository interactionRepository;

  // Constructor-based injection
  // @Autowired

  // CustomerServiceImpl( mock customer repository, mock interactionrepositoy)
  // public CustomerServiceImpl(CustomerRepository customerRepository,
  // InteractionRepository interactionRepository) {
  // this.customerRepository = customerRepository;
  // this.interactionRepository = interactionRepository;
  // }

  // CustomerServiceImpl(mockRepository)

  // Create
  @Override
  public Customer createCustomer(Customer customer) {
    Customer newCustomer = customerRepository.save(customer);
    // return new Customer();
    return newCustomer;
  }

  // Get One
  @Override
  public Customer getCustomer(int id) {
    // Customer foundCustomer = customerRepository.findById(id).get();
    Optional<Customer> foundCustomer = customerRepository.findById(id);

    if (foundCustomer.isPresent()) {
      return foundCustomer.get();
    } else {
      // throw new NoSuchElementException();
      throw new CustomerNotFoundException(id);
    }

    // return foundCustomer;
  }

  // Get All
  @Override
  public List<Customer> getAllCustomers() {
    List<Customer> allCustomers = customerRepository.findAll();
    return allCustomers;
  }

  // Update
  @Override
  public Customer updateCustomer(int id, Customer customer) {
    // Retrieve customer from DB
    // Customer customerToUpdate = customerRepository.findById(id).get();
    Optional<Customer> wrappedCustomerToUpdate = customerRepository.findById(id);

    // Early return/ Guard clause
    if (!wrappedCustomerToUpdate.isPresent()) {
      throw new CustomerNotFoundException(id);
    }

    // Unwrap it
    Customer customerToUpdate = wrappedCustomerToUpdate.get();

    // Update the customer retrieved from DB
    customerToUpdate.setFirstName(customer.getFirstName());
    customerToUpdate.setLastName(customer.getLastName());
    customerToUpdate.setEmail(customer.getEmail());
    customerToUpdate.setContactNo(customer.getContactNo());
    customerToUpdate.setJobTitle(customer.getJobTitle());
    customerToUpdate.setYearOfBirth(customer.getYearOfBirth());

    // Save and return the data
    return customerRepository.save(customerToUpdate);
  }

  // Delete
  @Override
  public void deleteCustomer(int id) {
    customerRepository.deleteById(id);
  }

  @Override
  public Interaction addInteractionToCustomer(int id, Interaction interaction) {
    // Retrieve the customer from the DB
    Optional<Customer> wrappedSelectedCustomer = customerRepository.findById(id);

    if (!wrappedSelectedCustomer.isPresent()) {
      throw new CustomerNotFoundException(id);
    }

    Customer selectedCustomer = wrappedSelectedCustomer.get();

    // Add the customer to the interaction
    interaction.setCustomer(selectedCustomer);
    // Save the interaction to the DB
    return interactionRepository.save(interaction);

  }
}
