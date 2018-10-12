import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter extends ZuulFilter{
	Logger log = LoggerFactory.getLogger(PostFilter.class);
	
	@Override
	public String filterType() {
		return "post";
	}
	
	@Override
	public int filterOrder() {
		return 2000;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() throws ZuulException {
		log.info("this is a post filter: Receive response");
		try {
			HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
			response.getOutputStream().print(", I am chris");
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
