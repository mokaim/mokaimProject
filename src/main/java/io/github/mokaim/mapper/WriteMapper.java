package io.github.mokaim.mapper;

import java.util.List;


import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.WriteDTO;

public interface WriteMapper {
	
	public int count_img_TB();
	
	
	public void insert_img_TB(ImageDTO imageDTO);
	
	
	public List<ImageDTO> select_List();
	
	public void insert_write_TB(WriteDTO writeDTO);
	
	public int count_write_TB();
	
	
	
}
