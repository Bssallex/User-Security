package com.bssallex.usersecurity.repository;

import com.bssallex.usersecurity.entity.Scopes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScopesRepository extends JpaRepository<Scopes, Long> {
    Optional<Scopes> findByName(String name);
}
