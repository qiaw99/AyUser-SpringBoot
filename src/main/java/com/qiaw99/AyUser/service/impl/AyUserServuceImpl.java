package com.qiaw99.AyUser.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qiaw99.AyUser.model.AyUser;
import com.qiaw99.AyUser.repository.AyUserRepository;
import com.qiaw99.AyUser.service.AyUserService;

@Service
public class AyUserServuceImpl implements AyUserService {

	@Resource
	private AyUserRepository ayUserRepository;

	@Override
	public AyUser findById(String id) {
		return ayUserRepository.findById(id).get();
	}

	@Override
	public List<AyUser> findAll() {
		return ayUserRepository.findAll();
	}

	@Override
	public AyUser save(AyUser ayUser) {
		return ayUserRepository.save(ayUser);
	}

	@Override
	public void delete(String id) {
		ayUserRepository.deleteById(id);

	}

	@Override
	public Page<AyUser> findAll(Pageable pageable) {
		return ayUserRepository.findAll(pageable);
	}

	@Override
	public List<AyUser> findByName(String name) {
		return ayUserRepository.findByName(name);
	}

	@Override
	public List<AyUser> findByNameLike(String name) {
		return ayUserRepository.findByNameLike(name);
	}

	@Override
	public List<AyUser> findByIdIn(Collection<String> ids) {
		return ayUserRepository.findByIdIn(ids);
	}
}
