package com.example.corespringsecurity.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sskim on 2022/06/18
 */
@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     * RequestCache는 인터페이스이고 기본 구현체는 HttpSessionRequestCache 이며 SavedRequest 도 인터페이스이고 기본 구현체는 DefaultSavedRequest 입니다.
     * <p>
     * HttpSessionRequestCache 는 DefaultSavedRequest 객체를 세션에 저장하는 역할을 하며
     * DefaultSavedRequest 는 현재 클라이언트의 요청과정 중에 포함된 쿠키, 헤더, 파라미터 값들을 추출하여 보관하는 역할을 합니다.
     * <p>
     * 즉 현재 클라이언트의 요청 과정에서 생성되거나 참조되는 모든 정보는 DefaultSavedRequest 에 저장되고 이 객체는 HttpSessionRequestCache 에 의해 세션에 저장됩니다.
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        setDefaultTargetUrl("/");

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetUrl);
        } else {
            redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
        }
    }
}
