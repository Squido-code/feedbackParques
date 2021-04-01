package com.guillermo.feedback.interfaces;

import java.util.List;

public interface InterfazDAO<B> {
	
	public int add(B bean);

	public List<B> findAll();

	public int update(B bean);

}
