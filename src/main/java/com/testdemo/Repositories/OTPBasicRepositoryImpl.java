package com.testdemo.Repositories;

import com.testdemo.Models.NewPairDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OTPBasicRepositoryImpl implements OTPBasicRepository {

    Map<String, NewPairDTO> hashMap = new HashMap<>();

    @Override
    public void saveOTPBasic(NewPairDTO newPairDTO) {
        hashMap.put(newPairDTO.getOtp(), newPairDTO);
    }

    @Override
    public NewPairDTO getOTPBasic(String otp) throws NullPointerException, ClassCastException {
        return hashMap.get(otp);
    }
}