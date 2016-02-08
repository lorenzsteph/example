package it.example.queue.encrypt3;

import java.util.Properties;

import javax.annotation.Resource;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/example/queue/encrypt3/encrypt-3-test-context.xml" })
public class TestEncrypt3 {

	@Resource(name = "testProp")
	private Properties test;

	@Resource(name = "test")
	private ExampleObj3 ex;

	@Test
	public void testEncrypt3() {
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

	@Test
	public void testSimpleEncrypt() {
		String myText = "ALMAPRIVACY";

		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);

	}

}
