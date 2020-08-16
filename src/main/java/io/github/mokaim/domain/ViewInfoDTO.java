package io.github.mokaim.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewInfoDTO {

	private int _post_num;
	private String _post_title;
	private String _post_content;
	private String _post_usr;
	private String _post_datetime;

	private int _img_num;
	private String _img_name;
	private String _img_location;
	private int _img_source;
	
}
