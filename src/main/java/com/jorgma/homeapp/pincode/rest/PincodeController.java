package com.jorgma.homeapp.pincode.rest;

import com.jorgma.homeapp.exceptions.InvalidPincodeException;
import com.jorgma.homeapp.pincode.domain.Pincode;
import com.jorgma.homeapp.pincode.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */

@RestController
@RequestMapping("/api/pincode")
public class PincodeController {

    @Autowired
    private PincodeService pincodeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void createPincode(int code) {
        pincodeService.createPincode(code);
    }


    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public Pincode getPincodeByCode(int code) throws InvalidPincodeException {
        Optional<Pincode> pincode = pincodeService.getPincodeByCode(code);
        if (!pincode.isPresent()) {
            throw new InvalidPincodeException("Please try again");
        }

        return pincode.get();
    }
}
