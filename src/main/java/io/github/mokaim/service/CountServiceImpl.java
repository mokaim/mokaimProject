package io.github.mokaim.service;

import io.github.mokaim.mapper.CountMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {

    @Autowired
    CountMapperImpl countMapper;

    @Override
    public int count_Post() {
        return countMapper.count_Post();
    }

    @Override
    public int count_LastPostNumber() {
        return countMapper.count_LastPostNumber();
    }
}
