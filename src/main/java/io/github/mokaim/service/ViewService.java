package io.github.mokaim.service;

import io.github.mokaim.domain.CommentsAndReplyDTO;
import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.ViewInfoDTO;

import java.util.List;

public interface ViewService {

    public ViewInfoDTO select_View(int _post_num);

    public List<ViewInfoDTO> select_List();

    public String select_CurrentDate();

    public List<CommentsDTO> select_CommentsByPostNumber(int _post_num);

    public List<CommentsAndReplyDTO> select_CommentsAndReplyByPostNumber(int _post_num);
}
