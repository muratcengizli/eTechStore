package com.techstore.estore.service;

import com.techstore.estore.persistence.entity.ConfirmationToken;

public interface ConfirmationTokenManager {

    void saveConfirmationToken(ConfirmationToken token);
    void deleteConfirmationToken(Long id);
}
