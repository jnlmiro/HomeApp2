package com.jorgma.homeapp.pincode.dao;

import com.jorgma.homeapp.pincode.domain.Pincode;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
public interface PincodeRepository extends PagingAndSortingRepository<Pincode, Integer> {
    Optional<Pincode> findByCode(int code);
}
