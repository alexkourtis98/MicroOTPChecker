package com.testdemo.Repositories;

import com.testdemo.Models.NewPairDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class OTPBasicRepositoryImplTest {

    Map<String, NewPairDTO> hashMap = new HashMap<>();
    private String otp = generateRandomNumber();

    private String generateRandomNumber() {
        Random r = new Random(System.currentTimeMillis());
        return String.valueOf(((1 + r.nextInt(2)) * 10000000 + r.nextInt(10000000)));
    }

    // test that it saves the otp pair
    @Test
    void saveOTPBasic() {
        NewPairDTO newPairDTO = new NewPairDTO();
        newPairDTO.setTestedStatus(true);
        newPairDTO.setEmailOrPhone("akourtisdev@gmail.com");
        newPairDTO.setExpirytime(System.currentTimeMillis() + 300000);
        newPairDTO.setOtp(otp);

        hashMap.put(newPairDTO.getOtp(), newPairDTO);

        Assert.assertTrue(hashMap.containsKey(newPairDTO.getOtp()));
    }

    // test that it gets the otp pair
    @Test
    void getOTPBasic() {
        saveOTPBasic();
        NewPairDTO newPairDTO = hashMap.get(otp);
        System.out.println(newPairDTO.getEmailOrPhone());
        Assert.assertNotNull(newPairDTO);
        Assert.assertEquals(newPairDTO.getOtp(), otp);
    }
}