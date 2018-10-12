import javax.servlet.http.HttpServletRequest

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException

class PreFilter extends ZuulFilter{
	Logger log = LoggerFactory.getLogger(PreFilter.class);
	
	@Override
	public String filterType() {
		return "pre";
	}
	
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1000;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("this is a pre filter: Send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		return null;
	}	
}
