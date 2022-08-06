package com.example.domain.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.Merchandise;
import com.example.repository.MerchandiseMapper;

@Service
public class MerchandiseServiceImpl implements MerchandiseService {
	@Autowired
	private MerchandiseMapper mapper;
	@Override
	public void signupMerchandise(Merchandise merchandise) {
		mapper.insertOne(merchandise);
		
	}

	@Override
	public List<Merchandise> getMerchandises(Merchandise merchandise) {
		return mapper.findMany(merchandise);
	}

	@Override
	public Merchandise getMerchandiseOne(Integer merchandiseId) {
		return mapper.findOne(merchandiseId);
	}

	@Override
	public void updateMerchandiseOne(Integer merchandiseId,String merchandiseName, Integer amount, Double money) {
		mapper.updateOne(merchandiseId,merchandiseName, amount, money);
	}

	@Override
	public void deleteMerchandiseOne(Integer merchandiseId) {
		mapper.deleteOne(merchandiseId);
	}

	@Override
	public List<Merchandise> getMerchandises() {
		return mapper.getMerchandises();
	}

	@Override
	public List<Merchandise> findByMerchandise(int id) {
		return mapper.findByMerchandise(id);
	}

}
