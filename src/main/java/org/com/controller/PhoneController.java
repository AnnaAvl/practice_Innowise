package org.com.controller;

import org.com.entity.Brand;
import org.com.entity.Phone;
import org.com.service.PhoneService;
import org.com.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/phone")
public class PhoneController extends AbstractController<Phone> {
    @Autowired
    private PhoneService service;

    @Override
    public Service<Phone> getService() {
        return service;
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Phone>> getByModel(@PathVariable String model) {
        List<Phone> phones = service.readByModel(model);
        if (phones.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(phones, headers, HttpStatus.OK);
    }

    @GetMapping("/price/{begin}to{end}")
    public ResponseEntity<List<Phone>> getByPrice(@PathVariable double begin, @PathVariable double end) {
        List<Phone> phones = service.readByPrice(begin, end);
        if (phones.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(phones, headers, HttpStatus.OK);
    }

    @GetMapping("/number/{begin}to{end}")
    public ResponseEntity<List<Phone>> getByNumber(@PathVariable Long begin, @PathVariable Long end) {
        List<Phone> phones = service.readByNumber(begin, end);
        if (phones.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(phones, headers, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Phone>> getByBrand(@PathVariable Brand brand) {
        List<Phone> phones = service.readByBrand(brand);
        if (phones.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(phones, headers, HttpStatus.OK);
    }
}
