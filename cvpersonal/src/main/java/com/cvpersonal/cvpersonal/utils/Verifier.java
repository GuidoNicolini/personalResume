package com.cvpersonal.cvpersonal.utils;

import org.springframework.stereotype.Service;

@Service
public class Verifier {

    public void IdVerification(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID must not be null or empty");
        }
    }
}
