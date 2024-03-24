package com.techstore.estore.service;

import com.techstore.estore.persistence.entity.ConfirmationToken;
import com.techstore.estore.persistence.repository.ConfirmationTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenManagerImpl implements ConfirmationTokenManager {

    private final ConfirmationTokenRepository repository;

    public ConfirmationTokenManagerImpl(ConfirmationTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveConfirmationToken(ConfirmationToken token) {
        repository.save(token);
    }

    @Override
    public void deleteConfirmationToken(Long id) {
        repository.deleteById(String.valueOf(id));
    }
}
