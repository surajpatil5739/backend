package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.admin.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query("select user from Admin user where user.email = :e AND user.password = :p")
	public Admin check(@Param("e") String email, @Param("p") String pass);
}
