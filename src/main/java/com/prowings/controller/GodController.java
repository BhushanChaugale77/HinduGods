package com.prowings.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.dto.GodDto;
import com.prowings.entity.God;
import com.prowings.service.GodServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/god")
public class GodController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private GodServiceInterface serviceInterface;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<God> godById(@PathVariable Long id){
		return new ResponseEntity<God>(serviceInterface.godById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<God>> allGod(){
		return new ResponseEntity<List<God>>(serviceInterface.allGod(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<GodDto> createGod(@Valid @RequestBody GodDto godDto,BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<GodDto>(serviceInterface.createGod(godDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGod(@PathVariable Long id){
		serviceInterface.deleteGodById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GodDto> updateGod(@Valid @PathVariable Long id,@RequestBody GodDto godDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<GodDto>(serviceInterface.updateGodById(id, godDto),HttpStatus.UPGRADE_REQUIRED);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<GodDto> patchGod(@Valid @PathVariable Long id,@RequestBody GodDto godDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<GodDto>(serviceInterface.patchGodById(id, godDto),HttpStatus.UPGRADE_REQUIRED);
	}
	@GetMapping
	public ResponseEntity<Page<God>> paginationGod(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<God>>(serviceInterface.paginationGod(page, size),HttpStatus.OK);
	}
}
