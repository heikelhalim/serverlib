package com.insider.travel.japan.wabisabi.serverlib.utils.log;

import java.util.Arrays;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 
 */
@Interceptor
public class LoggingDebugInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        Logger logger = LoggerFactory.getLogger(context.getTarget().getClass());
        logger.debug("Before call to [" + context.getMethod().getName() + "] with args " + Arrays.toString(context.getParameters()));

        Object returnMe = context.proceed();

        logger.debug("After call to [" + context.getMethod().getName() + "] returned" + returnMe);
        return returnMe;
    }

}
