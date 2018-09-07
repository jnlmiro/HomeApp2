package com.jorgma.homeapp.pincode.service;

import com.jorgma.homeapp.pincode.domain.Pincode;

import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
public interface PincodeService {

    void createPincode(String code);

    Optional<Pincode> getPincodeByCode(String code);
}
