package com.fredd.users_api.infraestructure.adapter.repository;

import com.fredd.users_api.infraestructure.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
