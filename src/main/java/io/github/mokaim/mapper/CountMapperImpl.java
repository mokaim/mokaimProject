package io.github.mokaim.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountMapperImpl implements CountMapper{


    @Autowired
    SqlSession sqlSession;

    public static final String NAME_SPACE = "io.github.mokaim.mapper";

    @Override
    public int count_Post() {
        return sqlSession.selectOne(NAME_SPACE + ".count_Post");
    }

    @Override
    public int count_LastPostNumber() {
        return sqlSession.selectOne(NAME_SPACE + ".count_LastPostNumber");
    }

    @Override
    public int count_Distinct_img(int _post_num) {
        return sqlSession.selectOne(NAME_SPACE + ".count_Distinct_img",_post_num);
    }
}
