package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EntityScan(basePackages = "org.example.entity")
class CrudTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
