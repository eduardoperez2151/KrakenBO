package com.geocom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.geocom.models.Role;

import javax.transaction.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Transactional
    @Modifying
    @Query("UPDATE Role r SET r.deleted = true WHERE r.id = :id")
    void delete(@Param("id") final Long id);
}
