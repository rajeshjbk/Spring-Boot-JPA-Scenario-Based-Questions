package com.raj.service;

import com.raj.model.OtpRequest;

public interface IOtpMailService {

	 void sendOtpMail(OtpRequest request);
}
