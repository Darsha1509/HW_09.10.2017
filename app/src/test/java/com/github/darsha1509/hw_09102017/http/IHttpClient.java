package com.github.darsha1509.hw_09102017.http;

import java.io.InputStream;

interface IHttpClient {
    InputStream request(String url);
}
