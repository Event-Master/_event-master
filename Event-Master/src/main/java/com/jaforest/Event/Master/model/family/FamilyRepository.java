package com.jaforest.Event.Master.model.family;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    public Family findByUsername(String username);
}
