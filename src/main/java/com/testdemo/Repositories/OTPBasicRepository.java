package com.testdemo.Repositories;

import com.testdemo.Models.NewPairDTO;

public interface OTPBasicRepository {

    void saveOTPBasic(NewPairDTO newPairDTO);

    NewPairDTO getOTPBasic(String otp) throws NullPointerException, ClassCastException;
}