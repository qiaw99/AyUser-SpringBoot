package com.qiaw99.AyUser.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.qiaw99.AyUser.model.AyUser;

public interface AyUserService {
	AyUser findById(String id);

	List<AyUser> findAll();

	AyUser save(AyUser ayUser);

	void delete(String id);

	Page<AyUser> findAll(Pageable pageable);

	List<AyUser> findByName(String name);

	List<AyUser> findByNameLike(String name);

	List<AyUser> findByIdIn(Collection<String> ids);
}
