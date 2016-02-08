package it.example.encrypt;

import it.example.encrypt.ExampleObj;

import java.util.Properties;

import javax.annotation.Resource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.spring31.properties.EncryptablePropertyPlaceholderConfigurer;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/example/encrypt/encrypt-test-context.xml" })
public class TestEncrypt {

	@Resource(name = "configProperties")
	private Properties props;

	@Resource(name = "testProperties")
	private Properties propsTest;

	@Resource(name = "propertyConfigurer")
	private EncryptablePropertyPlaceholderConfigurer propEncrypt;

	@Resource(name = "test")
	private ExampleObj ex;

	@Resource(name = "configurationEncryptor")
	private StandardPBEStringEncryptor encryptor;

	@Test
	public void testEncrypt() {
		String password = props.getProperty("db.password");
		System.out.println("config properties encrypt passwrod : " + password);

		System.out.println("example set USER : " + ex.getUser());
		System.out.println("example set password decript : " + ex.getPassword());
	}

	@Test
	public void testPropEnc() {
		propEncrypt.getClass();
	}

	@Test
	public void testBasicEncrypt() {

		String myPwd = props.getProperty("db.password");
		myPwd = myPwd.substring(4, myPwd.length() - 1);

		String plainText = encryptor.decrypt(myPwd);
		System.out.println("plainText : " + plainText);
	}

	@Test
	public void testStandardEncrypt() {
		String myText = "TEST_EXAMPLE";

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("example"); // we HAVE TO set a password
		encryptor.setAlgorithm("PBEWithMD5AndDES"); // optionally set the algorithm
		String encryptedText = encryptor.encrypt(myText);
		System.out.println("encryptedText : " + encryptedText);
		String plainText = encryptor.decrypt(encryptedText); // myText.equals(plainText)
		System.out.println("plainText : " + plainText);
	}

	@Test
	public void testSimpleEncrypt() {
		String myText = "TEST_EXAMPLE";

		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);

		String encryptedText = encryptor.encrypt(myText);
		System.out.println("encryptedText : " + encryptedText);
		String plainText = encryptor.decrypt(encryptedText); // myText.equals(plainText)
		System.out.println("plainText : " + plainText);
	}

	@Test
	public void testNoEncrypt() {
		String user = propsTest.getProperty("db.user");
		System.out.println("config properties no encrypt user : " + user);

		System.out.println("example set password decript : " + ex.getPassword());
		System.out.println("example set user : " + ex.getUser());
	}
}
