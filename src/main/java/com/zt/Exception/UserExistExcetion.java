package com.zt.Exception;

/**
 * Created by zt on 2017/7/4.
 */
public class UserExistExcetion extends Exception {

    public UserExistExcetion(){

    }

    public UserExistExcetion(String message) {
        super(message);
    }

    public UserExistExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistExcetion(Throwable cause) {
        super(cause);
    }


}
