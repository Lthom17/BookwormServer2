package com.example;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bookworm.App;
import com.bookworm.models.BookUser;
import com.bookworm.models.Library;
import com.bookworm.models.Member;
import com.bookworm.models.Result;

@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class MemberControllerTest {


    @Autowired
    private MockMvc mvc;

    // BookUser bookUser = new BookUser("username", "password", "email", "first_name", "last_name");

    // @MockBean
    // Library library;

    // List<String> roles = new ArrayList<String>();

    // Member member = new Member(bookUser, library, roles, false);

    // Result<Member> newMember = new Result<Member>();

    @Test
    void whenUserAccessUserSecuredEndpoint_thenOk() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.post("/add")).andExpect(MockMvcResultMatchers.status().isOk());
    }
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
 

