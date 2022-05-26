package com.qiaw99.AyUser.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qiaw99.AyUser.model.AyUser;

public interface AyUserRepository extends JpaRepository<AyUser, String> {
	List<AyUser> findByName(String name);
	
	List<AyUser> findByNameLike(String name);
	
	List<AyUser> findByIdIn(Collection<String> ids);
}
