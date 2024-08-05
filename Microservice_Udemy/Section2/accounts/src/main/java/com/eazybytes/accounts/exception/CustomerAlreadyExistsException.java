package com.eazybytes.accounts.exception;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String message)
    {
        super(message);
    }
}
