package com.kgisl.filters;

import com.kgisl.utils.ZuulConstant;
import com.netflix.zuul.ZuulFilter;

/**
 * RouteFilter class which will be used to route the request.
 * 
 * @author sriji.n
 * @version 1.0
 * @since 19-02-2021
 */
public class RouteFilter extends ZuulFilter {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		return ZuulConstant.ROUTE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#run()
	 */
	@Override
	public Object run() {
		System.out.println("Inside Route Filter");
		return null;
	}

}
