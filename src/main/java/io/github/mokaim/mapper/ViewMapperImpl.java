package io.github.mokaim.mapper;

import io.github.mokaim.domain.CommentsDTO;
import io.github.mokaim.domain.ImageDTO;
import io.github.mokaim.domain.ViewInfoDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViewMapperImpl implements ViewMapper{


    @Autowired
    SqlSession sqlSession;

    public static final String NAME_SPACE = "io.github.mokaim.mapper";


    @Override
    public ViewInfoDTO select_View(int _post_num) {
        return sqlSession.selectOne(NAME_SPACE + ".select_View",_post_num);
    }

    @Override
    public List<ViewInfoDTO> select_List() {
        return sqlSession.selectList(NAME_SPACE + ".select_List");
    }


    @Override
    public String select_CurrentDate() {
        return sqlSession.selectOne(NAME_SPACE + ".select_CurrentDate");
    }

    @Override
    public List<CommentsDTO> select_CommentsByPostNumber(int _post_num) {
        return sqlSession.selectList(NAME_SPACE + ".select_CommentsByPostNumber", _post_num);
    }


}
