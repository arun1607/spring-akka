package com.app.learning.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.learning.execution.App;
import com.app.learning.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class PersonRepositoryTest {
	@Autowired
	private PersonService personService;

	@Test
	public void testNotNull() {
		Assert.assertNotNull(personService);
	}

	@Test
	public void testFindAll() throws Exception {
		int size = personService.findAll().size();
		System.out.println("Collection size :" + size);
		Assert.assertTrue(size > 0);
	}
}
