package io.github.mokaim.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewInfoDTO {

	private int _post_num;
	private String _post_title;
	private String _post_content;

	private int _img_num;
	private String _img_name;
	private String _img_location;
	
}
