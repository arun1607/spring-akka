package com.app.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.learning.model.Address;
import com.app.learning.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	@Transactional
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Address entity) {
		addressRepository.delete(entity);
	}

	@Override
	public Address findById(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public void populate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDetails() {
		for (Address address : addressRepository.findAll()) {
			System.out.println(address.getPerson().getName());
		}

	}
}
