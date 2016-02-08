package it.example.queue.enums;

import org.junit.Assert;
import org.junit.Test;

public class TestEnum {

	@Test
	public void testQueueSender() {
		UserStatus us = UserStatus.ACTIVE;
		Assert.assertEquals("A", us.getStatusCode());
		Assert.assertEquals(2, us.getPosition());
	}
}
