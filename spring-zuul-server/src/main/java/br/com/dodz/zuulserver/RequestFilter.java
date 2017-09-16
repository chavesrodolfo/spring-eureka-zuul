package br.com.dodz.zuulserver;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RequestFilter extends ZuulFilter {
	public String filterType() {
		return "pre";
	}

	public int filterOrder() {
		return 1;
	}

	public boolean shouldFilter() {
		RequestContext context = getCurrentContext();
		return context.getRequest().getParameter("service") == null;
	}

	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		System.out.println("Method = " + request.getMethod() +
			", RemoteAddr = " + request.getRemoteAddr() +
			", RequestURI" + request.getRequestURI() +
			", Status = " + response.getStatus()
		);
		
		return null;
	}
}