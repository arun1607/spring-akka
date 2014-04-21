package com.app.learning.service;

import com.app.learning.model.Address;
import com.app.learning.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
