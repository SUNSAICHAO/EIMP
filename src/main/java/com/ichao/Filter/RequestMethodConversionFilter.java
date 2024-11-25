package com.ichao.Filter;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
public class RequestMethodConversionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest) servletRequest;
         //判断请求方式是否为post
         if ("POST".equals(request.getMethod())){
             //获取隐藏域中的请求方法属性值
             String methodParam = "_method";
             String methodValue=request.getParameter(methodParam);
             //如果属性值不为空，把属性值转换为大写
             if (StringUtils.isNotBlank(methodValue)){
                 String method=methodValue.toUpperCase();
                 if ("PUT_DELETE".contains(method)){
                      request= new HttpServletRequestWrapper(request){
                          @Override
                          public String getMethod() {
                              return method;
                          }
                      };
                 }
                 System.out.println("change into"+ method);
             }
         }
         filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
