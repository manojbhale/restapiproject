package com.tsc.hotel.exception.error;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrors {

	private String message;
	List<String> details;
	private HttpStatus status;
	LocalDateTime timeStamp;
}
