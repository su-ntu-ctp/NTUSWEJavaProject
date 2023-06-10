package com.example.simplecrm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// Integration test - test whole of interaction of the app
// mockMvc to simulate web requests
@SpringBootTest
@AutoConfigureMockMvc // this will configure mockMvc for us
class SimpleCrmApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CustomerRepository customerRepository;

	@BeforeEach
	void setup() {
		customerRepository.save(new Customer(1, "John", "Doe", "john@a.com", "12345678", "Manager", 1990));
		customerRepository.save(new Customer(2, "Tony", "Stark", "tony@a.com", "12345678", "Manager", 1990));
	}

	@Test
	void contextLoads() {
	}

	@Test
	void getCustomerByIdTest() throws Exception {
		// Step 1: Build a GET request to /customers/1
		RequestBuilder request = MockMvcRequestBuilders.get("/customers/1");

		// Step 2: Perform the request and get the result
		mockMvc.perform

	@BeforeEach
	void setup() {
		customerRepository.save(new Customer(1, "John", "Doe", "john@a.com", "12345678", "Manager", 1990));
		customerRepository.save(new Customer(2, "Tony", "Stark", "tony@a.com", "12345678", "Manager", 1990));
	}

	@Test
	void contextLoads() {
	}

	@Test
	void getCustomerByIdTest() throws Exception {
		// Step 1: Build a GET request to /customers/1
		RequestBuilder request = MockMvcRequestBuilders.get("/customers/1");

		// Step 2: Perform the request and get the result
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(1));

		// jsonPath is a way to get a specific field from the JSON response

	}

	@Test
	public void getAllCustomersTest() throws Exception {
		// Step 1: Build the requ

	}

	@Test
	public void getAllCustomersTest() throws Exception {
		// Step 1: Build the request to get all customers
		RequestBuilder request = MockMvcRequestBuilders.get("/customers");

		// Step 2: Perform the request and get the result
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.size()").value(2));

	}

	@Test
	public void validCustomerCreationTest() throws Exception {
		// Step 1: Build the request to create a customer
		Customer newCustomer = new Customer(3, "Bruce", "Banner", "bruce@a.com", "12345678", "Scientist", 1990);

		// Step 2: Convert the Java object to JSON
		String newCustomerAsJson = objectmapper.writeValueAsString(newCustomer);

		// Step 3: Build the request to create a customer
		RequestBuilder request = MockMvcRequestBuilders.post("/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newCustomerAsJson);

		// Step 4: Perform the request and get the result
		mockMvc.perform(request)
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.firstName").value("Bruce"))
				.andExpect(jsonPath("$.lastName").value("Banner"));

	}

	@Test
	public void invalidCustomerCreationTest() throws Exception {
		// Step 1: Create an invalid Customer
		Customer invalidCustomer = new Customer(4, "   ", "Banner", "  ", "12345678", "Scientist", 1990);

		// Step 2: Convert the Java object to JSON
		String invalidCustomerAsJson = objectmapper.writeValueAsString(invalidCustomer);

		// Step 3: Bu

	}

	@Test
	public void invalidCustomerCreationTest() throws Exception {
		// Step 1: Create an invalid Customer
		Customer invalidCustomer = new Customer(4, "   ", "Banner", "  ", "12345678", "Scientist", 1990);

		// Step 2: Convert the Java object to JSON
		String invalidCustomerAsJson = objectmapper.writeValueAsString(invalidCustomer);

		// Step 3: Build the request
		RequestBuilder request = MockMvcRequestBuilders.post("/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(invalidCustomerAsJson);

		// Step 4: Perform the request and get the result
		mockMvc.perform(request)
				.andExpect(status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

}
