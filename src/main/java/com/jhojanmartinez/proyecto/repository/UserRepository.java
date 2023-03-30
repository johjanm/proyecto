package com.jhojanmartinez.proyecto.repository;

import com.jhojanmartinez.proyecto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
}


