package top.liaoyichao.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/19 23:30
 * @Description: User Controller Test
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;


    @Before
    public void set(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void queryUser() throws Exception{

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userName", "王五")
                .param("age", "15").param("size", "3")
                .param("page", "3")
                .param("sort", "age asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(contentAsString);
    }

    @Test
    public void queryOne() throws Exception{

        String asString = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("张三"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(asString);
    }


    @Test
    public void create() throws Exception{
        String content = "{\"userName\":\"Test\",\"age\":-10,\"password\":null}";

        String asString = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(asString);
    }


    @Test
    public void uploadFile(){



    }
}
