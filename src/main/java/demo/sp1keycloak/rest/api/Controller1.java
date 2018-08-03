/*
 *  copyright (c) thelook.cn
 */
package demo.sp1keycloak.rest.api;

import java.security.Principal;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 老唐
 */
@RestController

public class Controller1 {

    @CrossOrigin
    @RequestMapping("/")
    public String index() {
        return "hello";
    }

    @RequestMapping("/user")
    public String user(Principal p) {
        Objects.requireNonNull(p);
        final StringBuffer sb = new StringBuffer();
        sb.append("user:").append(p.getName()).append("\n");
        sb.append("role:").append(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return sb.toString();
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) throws ServletException {
        req.logout();
        return null;
    }
}
