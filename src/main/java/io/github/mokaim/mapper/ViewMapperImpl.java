package io.github.mokaim.mapper;

import io.github.mokaim.domain.ViewInfoDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ViewMapperImpl implements ViewMapper{


    @Autowired
    SqlSession sqlSession;

    public static final String NAME_SPACE = "io.github.mokaim.mapper";


    @Override
    public ViewInfoDTO view(int bno) {
        return sqlSession.selectOne(NAME_SPACE + ".select_viewTest",bno);
    }
}
