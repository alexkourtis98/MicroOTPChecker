package com.testdemo.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class NewPairDTO implements Serializable {

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 1, max = 55, message = "Cannot be empty")
    private String emailOrPhone;

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 1, max = 55, message = "Cannot be empty")
    private String otp;

    @NotNull(message = "Cannot be empty")
    @Min(1)
    @Max(Long.MAX_VALUE)
    private long expirytime;

    private boolean testedStatus;

    public NewPairDTO(@NotEmpty(message = "Cannot be empty") @Size(min = 1, max = 55, message = "Cannot be empty") String emailOrPhone, @NotEmpty(message = "Cannot be empty") @Size(min = 1, max = 55, message = "Cannot be empty") String otp, @NotNull(message = "Cannot be empty") @Min(1) @Max(Long.MAX_VALUE) long expirytime) {
        this.testedStatus = false;
        this.emailOrPhone = emailOrPhone;
        this.otp = otp;
        this.expirytime = expirytime;
    }
}