package io.github.mokaim.mapper;

import java.util.List;

import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.TestImageDTO;

public interface WriteMapper {
	
	public int count_img_TB();
	
	
	public void insert_img_TB(ImageDTO imageDTO);
	
	
	public List<ImageDTO> select_List();
	
}
