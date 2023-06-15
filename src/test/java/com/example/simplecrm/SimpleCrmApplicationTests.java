package com.example.simplecrm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.simplecrm.model.Employee;
import com.example.simplecrm.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Integration test - test whole of interaction of the app
// mockMvc to simulate web requests
@SpringBootTest
@AutoConfigureMockMvc // this will configure mockMvc for us
class SimpleCrmApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ObjectMapper objectmapper;

	@BeforeEach
	void setup() {
		employeeRepository.save(new Employee(1, "John", "Doe", "john@a.com", "HR", "123456"));
		employeeRepository.save(new Employee(2, "Tony", "Stark", "tony@a.com", "Operations", "123456"));
	}

	@Test
	void contextLoads() {
	}

	@Test
	void getEmployeeByIdTest() throws Exception {
		// Step 1: Build a GET request to /customers/1
		RequestBuilder request = MockMvcRequestBuilders.get("/employees/1");

		// Step 2: Perform the request and get the result
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(1));

		// jsonPath is a way to get a specific field from the JSON response

	}

	@Test
	public void getAllEmployeesTest() throws Exception {
		// Step 1: Build the request to get all users
		RequestBuilder request = MockMvcRequestBuilders.get("/employees");

		// Step 2: Perform the request and get the result
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.size()").value(2));

	}

	@Test
	public void validEmployeeCreationTest() throws Exception {
		// Step 1: Build the request to create a employee
		Employee newEmployee = new Employee(3, "Bruce", "Banner", "bruce@a.com", "Finance", "123456");

			// Step 2: Convert the Java object to JSON
			String newUserAsJson = objectmapper.writeValueAsString(newEmployee);

			// Step 3: Build the request to create a employee
		RequestBuilder request = MockMvcRequestBuilders.post("/employees")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newUserAsJson);

		// Step 4: Perform the request and get the result
		mockMvc.perform(request)
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.firstName").value("Bruce"))
				.andExpect(jsonPath("$.lastName").value("Banner"));

	}

	@Test
	public void invalidUserCreationTest() throws Exception {
		// Step 1: Create an invalid employee
		Employee invalidEmployee = new Employee(4, "   ", "Banner", "  ", "Finance", "123456" );

		// Step 2: Convert the Java object to JSON
		String invalidEmployeeAsJson = objectmapper.writeValueAsString(invalidEmployee);

		// Step 3: Build the request
		RequestBuilder request = MockMvcRequestBuilders.post("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(invalidEmployeeAsJson);

				// Step 4: Perform the request and get the result
				mockMvc.perform(request)
				.andExpect(status().isBadRequest());
	}

}
