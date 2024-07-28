package org.example.recaptodo.utils;

import java.util.UUID;

public class IdService {

    public static String randomId(){
        return UUID.randomUUID().toString();
    }
}
