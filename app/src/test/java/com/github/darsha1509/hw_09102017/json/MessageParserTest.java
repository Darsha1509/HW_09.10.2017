package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.http.IHttpClient;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
public class MessageParserTest {
    private IHttpClient mIHttpClient;

    @Before
    public void setUp(){
        mIHttpClient = mock(IHttpClient.class);
    }
}
