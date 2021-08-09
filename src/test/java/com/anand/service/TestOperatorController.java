package com.anand.service;

import com.anand.controller.OperatorController;
import com.anand.orchestration.OperatorOrchestration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.anand.constants.WebConstants.OPERATORS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Import(AnnotationAwareAspectJAutoProxyCreator.class)
@WebMvcTest(OperatorController.class)
public class TestOperatorController {
    @Autowired
    private MockMvc mvc;

    @Mock
    static
    OperatorService operatorService;

    @TestConfiguration
    static class TestOperatorControllerTestContextConfiguration {
        @Bean
        public OperatorOrchestration operatorOrchestration() {
            return new OperatorOrchestration(operatorService);
        }
    }

    @Test
    public void testOperator() throws Exception {
        String content = "{\"operator\":\"plus\",\"left\":5,\"right\":7}";
        mvc.perform(post(OPERATORS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is(200))
                .andExpect(mvcResult -> content.equals("5+7=12"));
    }
}
