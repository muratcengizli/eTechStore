package com.techstore.estore.persistence.repository;

import com.techstore.estore.persistence.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, String> {
}
