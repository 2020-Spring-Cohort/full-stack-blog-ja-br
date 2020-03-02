package org.wcci.blog.integration;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.storage.BlogStorage;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.storage.TagStorage;


import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    GenreStorage genreStorage;
    @MockBean
    BlogStorage blogStorage;
    @MockBean
    TagStorage tagStorage;
    @Autowired
    private MockMvc mockMvc;


//    @Test
//    public void genresShouldBeOKAndReturnTheGenresViewWithGenresModelAttribute() throws Exception {
//        mockMvc.perform(get("/genres"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(view().name("genres-view"))
//                .andExpect(model().attributeExists("genres"));
//    }

//    @Test
//    public void shouldReceiveOKFromSingleCampusEndpoint() throws Exception {
//        Campus testCampus = new Campus("Testerville");
//        when(genreStorage.findCampusByLocation("Testerville")).thenReturn(testCampus);
//        mockMvc.perform(get("/campuses/Testerville"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("campusView"))
//                .andExpect(model().attributeExists("campus"));
//    }
//
//    @Test
//    public void shouldBeAbleToCreateNewCampus() throws Exception {
//        mockMvc.perform(post("/add-campus")
//                .param("location", "Testville"))
//                .andExpect(status().is3xxRedirection());
//        verify(genreStorage).store(new Campus("Testville"));
//    }

}
