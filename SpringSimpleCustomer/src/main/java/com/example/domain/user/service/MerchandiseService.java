package com.example.domain.user.service;

import java.util.List;
import com.example.domain.user.model.Merchandise;

public interface MerchandiseService {
	/** User signup */
	public void signupMerchandise(Merchandise merchandise);
	/** Get user */
	public List<Merchandise> getMerchandises(Merchandise merchandise);
	
	/** Get user */
	public List<Merchandise> getMerchandises();
	/** Get user(1record) */
	public List<Merchandise> findByMerchandise(int id);
	
	/** Get user(1record) */
	public Merchandise getMerchandiseOne(Integer merchandiseId);
	/** Update user */
	public void updateMerchandiseOne(Integer merchansideId,String merchandiseName,Integer amount, 
			Double money);
	/** Delete user */
	public void deleteMerchandiseOne(Integer merchandiseId);
}
