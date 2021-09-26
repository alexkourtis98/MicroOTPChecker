package com.testdemo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PairDTO {

    @NotBlank
    @JsonProperty("emailOrPhone")
    private String emailOrPhone;

    @NotBlank
    @JsonProperty("otp")
    private String otp;
}