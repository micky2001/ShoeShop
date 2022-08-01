package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.sample.demo.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByUserName(String name);
	
	@Modifying
    @Query(value="update users set passcode = :pass where username = :name", nativeQuery=true)
    public void updatePassword(@Param("name") String name, @Param("pass") String pass);

	public Users findByUserId(int id);

	public Users findTopByOrderByUserIdDesc();
}
