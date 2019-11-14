package com.example.apigateway.config;
import com.example.apigateway.bean.UserBean;
import com.example.apigateway.repository.UserRepository;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
@Component
public class AuthenticationFilter extends ZuulFilter {
    @Autowired
    UserRepository userRepository;

    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 1;
    }
    @Override
    public boolean shouldFilter() {
        String un = SecurityContextHolder.getContext().getAuthentication().getName();
        if(un.equals("anonymousUser"))
            return false;
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String un = SecurityContextHolder.getContext().getAuthentication().getName();
        UserBean user = userRepository.getUserByUsername(un);
        if(user != null)
            ctx.addZuulRequestHeader("userid", String.valueOf(user.getId()));
        return null;
    }
}