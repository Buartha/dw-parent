package com.bidsun.dw.test.cep;

/**
 * @author Niuxy
 * @className LoginEvent
 * @description TODO
 * @date 2021/6/16 13:24
 */
public class LoginEvent {
    String id;
    String ip;
    String status;
    Long timestamp;

    public LoginEvent() {
    }

    public LoginEvent(String id, String ip, String status, Long timestamp) {
        this.id = id;
        this.ip = ip;
        this.status = status;
        this.timestamp = timestamp;
    }
}
