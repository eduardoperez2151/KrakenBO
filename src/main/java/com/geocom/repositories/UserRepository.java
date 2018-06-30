package com.geocom.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.geocom.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.deleted = true WHERE u.id = :id")
	void delete(@Param("id") final Long id);


	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.deleted = false WHERE u.id = :id")
	void activateUser(@Param("id") final Long id);

	List<User> findByDeletedFalse();

	Optional<User> findByDeletedFalseAndIdEquals(final Long id);

}
