package com.jorgma.homeapp.pincode.business;

import com.jorgma.homeapp.pincode.domain.Pincode;

import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
public interface PincodeBl {
    void createPincode(int code);

    Optional<Pincode> getPincodeByCode(int pincode);
}
