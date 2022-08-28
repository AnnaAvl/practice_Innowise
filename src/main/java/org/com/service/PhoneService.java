package org.com.service;


import org.com.entity.Brand;
import org.com.entity.Phone;

import java.util.List;

public interface PhoneService extends Service<Phone> {
    List<Phone> readByModel(String model);
    List<Phone> readByPrice(double begin, double end);
    List<Phone> readByNumber(Long begin, Long end);
    List<Phone> readByBrand(Brand brand);
}
