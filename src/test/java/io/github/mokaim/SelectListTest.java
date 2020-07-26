package io.github.mokaim;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.github.mokaim.domain.InteliJunitTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class SelectListTest {

	@Mock
	InteliJunitTest inteliJunitTest;

	@Test
	public void test() {

		MockitoAnnotations.initMocks(this);
		when(inteliJunitTest.getId()).thenReturn("test1");

		assertTrue(inteliJunitTest.getId() == "test1");

	}
}
