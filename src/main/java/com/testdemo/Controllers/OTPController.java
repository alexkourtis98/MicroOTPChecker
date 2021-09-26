package com.testdemo.Controllers;

import com.testdemo.Exceptions.DisapprovedPairException;
import com.testdemo.Models.NewPairDTO;
import com.testdemo.Models.PairDTO;
import com.testdemo.Services.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "otpcodes/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@ResponseStatus(HttpStatus.OK)
public class OTPController {

    private final OTPService otpService;

    @Autowired
    public OTPController(OTPService otpService) {
        this.otpService = otpService;
    }

    @PostMapping(path = "/addNew")
    public void addNewPair(@Valid @RequestBody NewPairDTO newPairDTO) {
        otpService.addNewPair(newPairDTO);
    }

    @PostMapping(path = "/isOtpValid")
    public void isOtpValid(@Valid @RequestBody PairDTO pairDto) {
        if (!otpService.isOtpValid(pairDto))
            throw new DisapprovedPairException();
    }
}