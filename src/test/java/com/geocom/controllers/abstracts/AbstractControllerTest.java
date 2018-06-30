package com.geocom.controllers.abstracts;

import com.geocom.AppInitializer;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = AppInitializer.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@Ignore
public class AbstractControllerTest {


    @Autowired
    protected ResourceLoader resourceLoader;

    @Autowired
    protected MockMvc mockMvc;


    protected String getFile(final String path) throws IOException {
        final Resource resource = resourceLoader.getResource(path);
        return new BufferedReader(new InputStreamReader(resource.getInputStream()))
                .lines()
                .collect(Collectors.joining());
    }

    private MockHttpServletRequestBuilder createRequest(final MockHttpServletRequestBuilder mockHttpServletRequestBuilder, final String requestPayload) {
        final MockHttpServletRequestBuilder requestBuilder = mockHttpServletRequestBuilder
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8);
        if (requestPayload != null) {
            requestBuilder.content(requestPayload);
        }
        return requestBuilder;
    }

    protected ResultActions checkRestAPIResponse(final MockHttpServletRequestBuilder mockHttpServletRequestBuilder,
                                                 final String requestPayload,
                                                 final ResultMatcher expectedStatus,
                                                 final String apiResponseCode,
                                                 final String apiResponseMessage) throws Exception {
        final MockHttpServletRequestBuilder request = createRequest(mockHttpServletRequestBuilder, requestPayload);
        return mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.code", is(apiResponseCode)))
                .andExpect(jsonPath("$.message", is(apiResponseMessage)));

    }

}
