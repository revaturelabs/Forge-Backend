package com.forge.revature.demo;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forge.revature.controllers.ProjectController;
import com.forge.revature.models.Project;
import com.forge.revature.repo.ProjectRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class ProjectTest {

    private MockMvc mock;

    @MockBean
    ProjectRepo repo;

    @BeforeEach
    public void setup() {
        mock = MockMvcBuilders.standaloneSetup(new ProjectController(repo)).build();
    }
    
    @Test
    void testGetAll() throws Exception {
        given(repo.findAll()).willReturn(new ArrayList<Project>());

        mock.perform(get("/projects"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();
    }

    @Test
    void testGetById() throws Exception {
        given(repo.findById((long) 1)).willReturn(Optional.of(new Project("Project 3", "sample description",
                "sample responsibilities", 40, 3)));

        mock.perform(get("/projects/1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();
    }

    @Test
    void testCreate() throws Exception {
        Project proj = new Project("Project 3", "sample description", "sample responsibilities", 40, 3);
        proj.setId(1);
        given(repo.save(proj)).willReturn(proj);

        mock.perform(post("/projects").contentType("application/json;charset=utf-8").content(new ObjectMapper().writeValueAsString(proj)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    void testUpdate() throws Exception {
        Project proj = new Project("Project 3", "sample description", "sample responsibilities", 40, 3);
        given(repo.findById((long) 1)).willReturn(Optional.of(proj));

        Project newProj = new Project("Project 3", "different description", "different responsibilities", 60, 2);

        mock.perform(post("/projects/1").contentType("application/json;charset=utf-8").content(new ObjectMapper().writeValueAsString(newProj)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    void testDelete() throws Exception {
        mock.perform(delete("/projects/1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andReturn();
    }
}