/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package net.httpclient;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.SystemDefaultHttpClient;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpParams;

import java.io.IOException;

/**
 * @author mr.24
 * @version Id: HttpClientDemo, v 1.0 2018/10/28 下午4:21 Exp $$
 */
public class HttpClientDemo {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = new SystemDefaultHttpClient();
        HttpHost httpHost = new HttpHost("https://alipay.com");
        HttpRequest httpRequest = new HttpRequest() {
            @Override
            public RequestLine getRequestLine() {
                return new BasicRequestLine("POST", "", this.getProtocolVersion());
            }
    
            @Override
            public ProtocolVersion getProtocolVersion() {
                return new HttpVersion(1, 1);
            }
    
            @Override
            public boolean containsHeader(String s) {
                return false;
            }
    
            @Override
            public Header[] getHeaders(String s) {
                return new Header[0];
            }
    
            @Override
            public Header getFirstHeader(String s) {
                return null;
            }
    
            @Override
            public Header getLastHeader(String s) {
                return null;
            }
    
            @Override
            public Header[] getAllHeaders() {
                return new Header[0];
            }
    
            @Override
            public void addHeader(Header header) {
        
            }
    
            @Override
            public void addHeader(String s, String s1) {
        
            }
    
            @Override
            public void setHeader(Header header) {
        
            }
    
            @Override
            public void setHeader(String s, String s1) {
        
            }
    
            @Override
            public void setHeaders(Header[] headers) {
        
            }
    
            @Override
            public void removeHeader(Header header) {
        
            }
    
            @Override
            public void removeHeaders(String s) {
        
            }
    
            @Override
            public HeaderIterator headerIterator() {
                return null;
            }
    
            @Override
            public HeaderIterator headerIterator(String s) {
                return null;
            }
    
            @Override
            public HttpParams getParams() {
                return null;
            }
    
            @Override
            public void setParams(HttpParams httpParams) {
        
            }
        };
    
    
        HttpResponse response = httpClient.execute(httpHost, httpRequest, new HttpClientContext());
        System.out.println(response.getStatusLine());
    }
}
