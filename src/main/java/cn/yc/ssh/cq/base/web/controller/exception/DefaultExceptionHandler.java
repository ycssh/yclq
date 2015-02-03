package cn.yc.ssh.cq.base.web.controller.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>User: yc
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler({UnauthorizedException.class})
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException ex) {
    	ex.printStackTrace();
		ModelAndView mav = new ModelAndView("unauthorized");
		return mav;
	}
}
