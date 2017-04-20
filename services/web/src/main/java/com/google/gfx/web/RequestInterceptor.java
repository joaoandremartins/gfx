package com.google.gfx.web;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by joaomartins on 4/18/17.
 */
public class RequestInterceptor implements ClientHttpRequestInterceptor {

  Logger logger = Logger.getGlobal();

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    ClientHttpResponse response = execution.execute(request, body);
    logger.info(response.toString());
    return response;
  }
}
