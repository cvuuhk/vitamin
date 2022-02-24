package cn.cvuuhk.vitamin.exception;

import org.springframework.stereotype.Component;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException(String msg) {
        super(msg);
    }
}
