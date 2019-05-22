package com.sun.bean;

import java.util.List;

import com.sun.entity.automodel.Fs_kphz;

public interface UtilMapper {

	public  String selectMonth(String pjh);
	
	public void updateJkztAndJkrq(UpdateBean bean);
	
	public List<String> selectPjh();
	
	public void insertSync(Fs_kphz kphz);
	
	public void deleteByPjh(String pjh);

}
