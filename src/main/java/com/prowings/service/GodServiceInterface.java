package com.prowings.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prowings.dto.GodDto;
import com.prowings.entity.God;

public interface GodServiceInterface {

 	
	List<God> allGod();
	
	God godById(Long id);
	
	GodDto createGod(GodDto godDto);
	
	void deleteGodById(Long id);
	
	GodDto updateGodById(Long id, GodDto godDto);
	
	GodDto patchGodById(Long id,GodDto godDto);
	
	Page<God> paginationGod(int page, int size);
	
}
