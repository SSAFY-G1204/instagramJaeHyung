package com.example.instagram_backend.domain.ContentManagement.controller;

import com.example.instagram_backend.domain.ContentManagement.dto.AddPostRequestDto;
import com.example.instagram_backend.domain.ContentManagement.dto.UpdatePostRequestDto;
import com.example.instagram_backend.domain.ContentManagement.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @InjectMocks// 모킹된 postService를 주입받는다.
    private PostController postController;

    @BeforeEach
    void setUp() {
        // MockMvc 객체를 초기화한다.
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    void testAddPost() throws Exception {
        AddPostRequestDto postRequestDto = new AddPostRequestDto(1L, "content");
        doNothing().when(postService).addPost(postRequestDto);

        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":1,\"content\":\"content\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdatePost() throws Exception {
        UpdatePostRequestDto postRequestDto = new UpdatePostRequestDto(1L, 1L, "updated content");
        doNothing().when(postService).updatePost(postRequestDto);

        mockMvc.perform(put("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"postId\":1,\"userId\":1,\"content\":\"updated content\"}"))
                .andExpect(status().isOk());
    }

}