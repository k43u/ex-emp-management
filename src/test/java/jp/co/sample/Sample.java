package jp.co.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.sample.service.AdministratorService;
@SpringBootTest
class Sample {

	@Autowired
	private AdministratorService administratorService;
	
	@Test
	void test() {
		administratorService.login(null, null);
	}

}
