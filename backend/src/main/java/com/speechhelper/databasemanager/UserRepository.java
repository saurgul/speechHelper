package com.speechhelper.databasemanager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {
	List<UserEntity> findAll();
	UserEntity findById(long id);
}
