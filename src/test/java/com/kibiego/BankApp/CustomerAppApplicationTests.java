package com.kibiego.BankApp;

import com.kibiego.BankApp.customer.Customer;
import com.kibiego.BankApp.customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CustomerAppApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	@Test
	public void testCreate() {
		Customer c = new Customer();
		c.setId(1L);
		c.setFirstName("Nick");
		c.setLastName("Sal");
		c.setEmail("sal@gmail.com");
		c.setAccountNumber(123455554);
		c.setAccountBalance(3000D);
		customerRepository.save(c);

		assertNotNul(customerRepository.findById(1L).get());
	}

	private void assertNotNul(Customer customer) {
	}

	@Test
	public void testReadAll () {
		List<Customer> list = customerRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}


}
