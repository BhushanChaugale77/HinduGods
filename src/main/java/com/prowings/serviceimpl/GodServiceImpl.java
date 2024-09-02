package com.prowings.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prowings.dto.GodDto;
import com.prowings.entity.God;
import com.prowings.repository.GodRepository;
import com.prowings.service.GodServiceInterface;

@Service
public class GodServiceImpl implements GodServiceInterface{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private GodRepository repository;

	 
	@Override
	public List<God> allGod() {
 		return repository.findAll();
	}

	@Override
	public God godById(Long id) {
 		return repository.findById(id).orElseThrow();
	}

	@Override
	public GodDto createGod(GodDto godDto) {
 		God god = mapper.map(godDto, God.class);
 		repository.save(god);
 		GodDto dto = mapper.map(god, GodDto.class);
		return dto;
	}

	@Override
	public void deleteGodById(Long id) {
 		repository.deleteById(id);
	}

	@Override
	public GodDto updateGodById(Long id, GodDto godDto) {
		God god = mapper.map(godDto, God.class);
 		
		god.setId(godDto.getId());
		god.setGodName(godDto.getGodName());
		god.setGodAnicientTime(godDto.getGodAnicientTime());
		god.setGodemail(godDto.getGodemail());
		god.setCurrentState(godDto.getCurrentState());
		god.setGodPlace(godDto.getGodPlace());
		
		repository.saveAndFlush(god);
		GodDto dto = mapper.map(god, GodDto.class);
		return dto;
	}

	@Override
	public GodDto patchGodById(Long id, GodDto godDto) {
		God god = mapper.map(godDto, God.class);
 		
		god.setId(godDto.getId());
		god.setGodemail(godDto.getGodemail());
		god.setCurrentState(godDto.getCurrentState());

		repository.flush();
		GodDto dto = mapper.map(god, GodDto.class);
		return dto;
	}

	@Override
	public Page<God> paginationGod(int page, int size) {
 		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	
}
