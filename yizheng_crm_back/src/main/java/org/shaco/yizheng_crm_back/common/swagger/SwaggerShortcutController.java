package org.shaco.yizheng_crm_back.common.swagger;

//import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shaco
 * @since 2025-03-28
 */
@Controller
public class SwaggerShortcutController {

    private final Environment environment;

    public SwaggerShortcutController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public void index(HttpServletResponse response) throws IOException {
        String contextPath = environment.getProperty("server.servlet.context-path");
        response.sendRedirect((StringUtils.isNotEmpty(contextPath) ? contextPath : StringUtils.EMPTY).concat("/doc.html"));
    }

}
