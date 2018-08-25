package com.jorgma.homeapp.pincode.business;

import com.jorgma.homeapp.exceptions.InvalidPincodeException;
import com.jorgma.homeapp.pincode.dao.PincodeRepository;
import com.jorgma.homeapp.pincode.domain.Pincode;
import com.jorgma.homeapp.pincode.domain.ValidPincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
@Service
public class PincodeBlImpl implements PincodeBl {

    @Autowired
    private PincodeRepository pincodeRepository;

    @Override
    public void createPincode(int code) {
        Pincode pincode = new Pincode();
        pincode.setCode(code);
        pincodeRepository.save(pincode);
    }

    @Override
    public Optional<Pincode> getPincodeByCode(int code) {
        return pincodeRepository.findByCode(code);
    }
}
