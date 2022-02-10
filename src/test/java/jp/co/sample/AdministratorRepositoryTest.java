package jp.co.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;
@SpringBootTest
class AdministratorRepositoryTest {
	
	@Autowired
	private AdministratorRepository administratorRepository;

	@Test
	void test() {
		Administrator result1 = administratorRepository.findByMailAddressAndPassword("yamada@mail.com", "password");
		assertEquals(2, result1.getId());
		assertEquals("山田太郎", result1.getName());
		assertEquals("yamada@mail.com", result1.getMailAddress());
		assertEquals("password", result1.getPassword());
	}

}
