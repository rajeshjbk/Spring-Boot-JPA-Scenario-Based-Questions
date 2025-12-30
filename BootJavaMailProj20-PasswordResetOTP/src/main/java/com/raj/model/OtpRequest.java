package com.raj.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtpRequest {

    private String email;
    private String otp;
    private LocalDateTime expiryTime;
	
}
