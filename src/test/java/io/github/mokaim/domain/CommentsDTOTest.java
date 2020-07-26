package io.github.mokaim.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommentsDTOTest {

    CommentsDTO  commentsDTO;

    @BeforeEach
    public void setUp(){
        commentsDTO = mock(CommentsDTO.class);
    }

    @Test
    public void testCommentsDTO(){
        when(commentsDTO.get_post_num()).thenReturn(10);
        assertEquals(10, commentsDTO.get_post_num());
    }
}