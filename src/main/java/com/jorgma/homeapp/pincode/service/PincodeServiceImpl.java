package com.jorgma.homeapp.pincode.service;

import com.jorgma.homeapp.exceptions.InvalidPincodeException;
import com.jorgma.homeapp.pincode.business.PincodeBl;
import com.jorgma.homeapp.pincode.domain.Pincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
@Service
public class PincodeServiceImpl implements PincodeService {

    @Autowired
    private PincodeBl pincodeBl;

    @Override
    public void createPincode(String code) {
        pincodeBl.createPincode(code);
    }

    @Override
    public Optional<Pincode> getPincodeByCode(String code) throws InvalidPincodeException {
        return pincodeBl.getPincodeByCode(code);
    }
}
