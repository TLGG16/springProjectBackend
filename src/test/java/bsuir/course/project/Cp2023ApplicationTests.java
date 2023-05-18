package bsuir.course.project;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Interfaces.CarService;
import bsuir.course.project.Interfaces.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class Cp2023ApplicationTests {
    UserService userService;
    CarService carService;
    MockMvc mockMvc;

    @Test
    public void testAdvertCreate() throws Exception {
        Advert advert = new Advert();
        advert.setUser(userService.getUserById(1).get());
        advert.setCar(carService.getCarById(1).get());
        advert.setPrice((double) 1000);
        advert.setDescription("Test description");

        mockMvc.perform(post("/advert/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(advert)))
                .andExpect(status().isAccepted());
    }

    @Test
    public void testAdvertGet() throws Exception {
        mockMvc.perform(get("/advertmenu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].price", is((double) 1000)).exists())
                .andExpect(jsonPath("$[1].price", is((double) 2000)).exists());
    }

    @Test
    public void testAdvertGetById() throws Exception {
        mockMvc.perform(get("/advert/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(1000)).exists());
    }

    @Test
    public void testAdvertDelete() throws Exception {
        mockMvc.perform(delete("/advertdelete/{id}", 1))
                .andExpect(status().isOk());

        mockMvc.perform(get("/advertmenu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].price", is(2000)).exists());
    }

    @Test
    public void testAdvertUpdateGet() throws Exception {
        mockMvc.perform(get("/advertupdate/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(1000)).exists());
    }

    @Test
    public void testAdvertUpdatePut() throws Exception {
        Advert advert = new Advert();
        advert.setUser(userService.getUserById(1).get());
        advert.setCar(carService.getCarById(1).get());
        advert.setPrice((double) 3000);
        advert.setDescription("Updated description");

        mockMvc.perform(post("/advertupdate/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson (advert)))
                .andExpect(status().isAccepted());

        mockMvc.perform(get("/advert/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(3000)).exists())
                .andExpect(jsonPath("$.description", is("Updated description")).exists());
    }

}
