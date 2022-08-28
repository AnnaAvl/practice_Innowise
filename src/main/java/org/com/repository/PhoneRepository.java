package org.com.repository;

import org.com.entity.Brand;
import org.com.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByModelContaining(String model);
    List<Phone> findByPriceBetween(double begin, double end);
    List<Phone> findByNumberBetween(Long begin, Long end);
    List<Phone> findByBrand(Brand brand);
}
