package com.app.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.learning.model.Address;
import com.app.learning.repository.AddressRepository;

@Service
public class AddressService implements BaseService<Address> {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

}
