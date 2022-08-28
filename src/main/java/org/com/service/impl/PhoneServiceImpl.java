package org.com.service.impl;

import org.com.entity.Brand;
import org.com.entity.Phone;
import org.com.repository.PhoneRepository;
import org.com.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository repository;

    @Override
    public Phone read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Phone> read() {
        return repository.findAll();
    }

    @Override
    public void save(Phone entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Phone entity) {
        Phone phone = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        phone.setBrand(entity.getBrand());
        phone.setModel(entity.getModel());
        phone.setPrice(entity.getPrice());
        phone.setNumber(entity.getNumber());
        repository.save(phone);
    }

    @Override
    public List<Phone> readByModel(String model) {
        return repository.findByModelContaining(model);
    }

    @Override
    public List<Phone> readByBrand(Brand brand) {
        return repository.findByBrand(brand);
    }

    @Override
    public List<Phone> readByPrice(double begin, double end) {
        return repository.findByPriceBetween(begin, end);
    }

    @Override
    public List<Phone> readByNumber(Long begin, Long end) {
        return repository.findByNumberBetween(begin, end);
    }
}
