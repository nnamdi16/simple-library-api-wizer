package com.nnamdi.library;

import com.nnamdi.library.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleLibraryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testCreateCategory(){
//        Category category = new Category();
//        category.setTitle("Religion");
//        ResponseEntity<Category> postCategory = restTemplate.postForEntity(getRootUrl() + "/api/v1/category", category,Category.class);
//        Assert.assertNotNull(postCategory);
//        Assert.assertNotNull(postCategory.getBody());

    }


}
