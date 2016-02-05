package it.almaviva.queue.encrypt2;

import java.util.Properties;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/almaviva/queue/encrypt2/encrypt-2-test-context.xml" })
public class TestEncrypt2 {

	@Resource(name = "testProp")
	private Properties test;

	@Resource(name = "test")
	private ExampleObj2 ex;

	@Test
	public void testEncrypt2() {
		String plainText = test.getProperty("db.password");
		System.out.println("plainText : " + plainText);

	}

	@Test
	public void testNoEncrypt() {

		System.out.println("example set password decript : " + ex.getPassword());
		System.out.println("example set user : " + ex.getUser());
	}
	
	
	@Test
	public void testENC() {
		String pwd = test.getProperty("db.password");
		
		System.out.println("pwd : " + pwd);
	}
}
