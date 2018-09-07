package com.jorgma.homeapp.pincode.business;

import com.jorgma.homeapp.pincode.domain.Pincode;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
public interface PincodeBl {
    Pincode createPincode(Pincode pincode);

    Optional<Pincode> getPincodeByCode(String pincode);

    List<Pincode> getPincodes();
}
