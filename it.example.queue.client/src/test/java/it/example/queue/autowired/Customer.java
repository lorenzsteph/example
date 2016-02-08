package it.example.queue.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Customer {

	private City city;

	@Autowired
	public Customer(City city){
		this.city = city;
	}
	
	public boolean customerLiveInCity() {
		return city.isTrue();
	}

}
