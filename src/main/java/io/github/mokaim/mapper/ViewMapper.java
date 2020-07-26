package io.github.mokaim.mapper;

import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.ViewInfoDTO;

import java.util.List;

public interface ViewMapper {

    public ViewInfoDTO select_View(int _post_num);

    public List<ImageDTO> select_List();

    public String select_CurrentDate();

    public List<CommentsDTO> select_CommentsByPostNumber(int _post_num);
}
