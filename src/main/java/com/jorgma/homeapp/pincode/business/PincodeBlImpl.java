package com.jorgma.homeapp.pincode.business;

import com.jorgma.homeapp.exceptions.InvalidPincodeException;
import com.jorgma.homeapp.pincode.dao.PincodeRepository;
import com.jorgma.homeapp.pincode.domain.Pincode;
import com.jorgma.homeapp.pincode.domain.ValidPincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
@Service
public class PincodeBlImpl implements PincodeBl {

    @Autowired
    private PincodeRepository pincodeRepository;

    @Override
    public List<Pincode> getPincodes() {
        return (List<Pincode>) pincodeRepository.findAll();
    }

    @Override
    public Pincode createPincode(Pincode pincode) {
        return pincodeRepository.save(pincode);
    }

    @Override
    public Optional<Pincode> getPincodeByCode(String code) {
        return pincodeRepository.findByCode(code);
    }
}
