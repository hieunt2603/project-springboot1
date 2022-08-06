package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.Merchandise;


@Mapper
public interface MerchandiseMapper {
	/** User signup */
	public int insertOne(Merchandise merchandise);
	
	/** Get User*/
	public List<Merchandise> findMany(Merchandise merchandise);
	
	/** Get User*/
	public List<Merchandise> getMerchandises();
	/** Get User*/
	public List<Merchandise> findByMerchandise(@Param("merchandiseId") int id);
	
	/** Get user (1 record) */
	public Merchandise findOne(Integer merchandiseId);
	/** Update user */
	public void updateOne(@Param ("merchandiseId") Integer merchandiseId,
					@Param ("merchandiseName") String merchandiseName,
					@Param ("amount") Integer amount,
					@Param ("money") Double money);
	/** Delete user */
	public int deleteOne(@Param ("merchandiseId") Integer merchandiseId);
}
