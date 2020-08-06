package com.ravi.jhipster.gateway.myapp.repository;

import com.ravi.jhipster.gateway.myapp.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
