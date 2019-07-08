package com.ladyishenlong.oauth2clientsqr.config;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.impl.client.DefaultRedirectStrategy;

/**
 * @Author ruanchenhao
 * @Date 2019-07-08 16:29
 */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BanRedirectStrategy extends DefaultRedirectStrategy  {

    public static final BanRedirectStrategy INSTANCE = new BanRedirectStrategy();

    /**
     * Redirectable methods.
     */
    private static final String[] REDIRECT_METHODS = new String[] {};

    @Override
    protected boolean isRedirectable(final String method) {
        return false;
    }


}
