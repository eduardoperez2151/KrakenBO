package com.geocom.repositories;

import com.geocom.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local,Long> {
}
