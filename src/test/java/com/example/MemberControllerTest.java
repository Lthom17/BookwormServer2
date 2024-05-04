package com.example;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {


    @Autowired
    private MockMvc mvc;


    @Test
    public void whenUserAccessUserSecuredEndpoint_thenOk() throws Exception {
        mvc.perform(post("/add"))
                .andExpect(status().isOk());
    }

//     @Test
//     public void whenUserAccessRestrictedEndpoint_thenOk() throws Exception {
//         mvc.perform(get("/all"))
//                 .andExpect(status().isOk());
//     }

//     @Test
//     public void whenUserAccessAdminSecuredEndpoint_thenIsForbidden() throws Exception {
//         mvc.perform(get("/admin"))
//                 .andExpect(status().isForbidden());
//     }

//     @Test
//     public void whenUserAccessDeleteSecuredEndpoint_thenIsForbidden() throws Exception {
//         mvc.perform(delete("/delete"))
//                 .andExpect(status().isForbidden());
//     }
 }

