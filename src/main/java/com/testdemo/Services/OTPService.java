package com.testdemo.Services;

import com.testdemo.Exceptions.TestedAlreadyPairException;
import com.testdemo.Models.NewPairDTO;
import com.testdemo.Models.PairDTO;
import com.testdemo.Repositories.OTPBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    private final OTPBasicRepository otpBasicRepository;

    @Autowired
    public OTPService(OTPBasicRepository otpBasicRepository) {
        this.otpBasicRepository = otpBasicRepository;
    }

    public void addNewPair(NewPairDTO newPairDTO) {
        otpBasicRepository.saveOTPBasic(newPairDTO);
    }

    private void checkIfTestedAlready(NewPairDTO data) {
        if (data.isTestedStatus())
            throw new TestedAlreadyPairException();
    }

    public boolean isOtpValid(PairDTO pairDto) {
        try {
// retrieve the saved pairdto from the map based on the otp
            NewPairDTO newPairDTO = otpBasicRepository.getOTPBasic(pairDto.getOtp());
            // check if tested already
            checkIfTestedAlready(newPairDTO);
            // check if its yours
            if (newPairDTO.getEmailOrPhone().equals(pairDto.getEmailOrPhone())) {
                // check if its expired
                if (newPairDTO.getExpirytime() >= 300000) {
                    if (newPairDTO.getOtp().equals(pairDto.getOtp())) {
                        newPairDTO.setTestedStatus(true);
                        otpBasicRepository.saveOTPBasic(newPairDTO);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (NullPointerException | ClassCastException ex) {
            return false;
        }
        return false;
    }
}