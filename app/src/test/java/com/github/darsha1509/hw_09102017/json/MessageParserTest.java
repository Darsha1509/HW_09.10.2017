package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.BuildConfig;
import com.github.darsha1509.hw_09102017.Constants;
import com.github.darsha1509.hw_09102017.http.IHttpClient;
import com.github.darsha1509.hw_09102017.mocks.Mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION)
public class MessageParserTest {

    private IHttpClient mIHttpClient;

    private static final int EXPECTED_ID = 34853;
    private static final int EXPECTED_FROM_WHO_ID = 21402356;
    private static final String EXPECTED_MESSAGE_TEXT="Привет)";
    private static final String EXPECTED_DATE="Sun Jan 18 13:42:49 MSK 1970";

    @Before
    public void setUp(){
        mIHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parseMessageObject() throws Exception{
        final InputStream mockedInputStream = Mocks.stream("message/message_object");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getMessage");

        final MessageParserFactory messageParserFactory = new MessageParserFactory();
        final IMessage message = messageParserFactory.createParser(response).parse();

        assertEquals(EXPECTED_ID, message.getId());
        assertEquals(EXPECTED_FROM_WHO_ID, message.getFromWhoId());
        assertEquals(EXPECTED_MESSAGE_TEXT, message.getMessageText());
        assertEquals(EXPECTED_DATE, message.getDate());
    }

    @Test
    public void parseMessageListInObject() throws Exception{
        final InputStream mockedInputStream = Mocks.stream("message/messages_array_with_root_object.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getMessage");

        final MessageParserFactory messageParserFactory = new MessageParserFactory();
        final IMessageList messages = messageParserFactory.createParserJsonListInObject(response).parse();

        assertTrue(messages.getMessagesList().size() == 10);
        assertTrue(messages.getMessagesList().get(2).getId()==EXPECTED_ID);
        assertEquals(messages.getMessagesList().get(2).getMessageText(), EXPECTED_MESSAGE_TEXT);
    }

    @Test
    public void parseMessageList() throws Exception{
        final InputStream mockedInputStream = Mocks.stream("message/messages_array.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getMessage");

        final MessageParserFactory messageParserFactory = new MessageParserFactory();
        final IMessageList messages = messageParserFactory.createParserJsonList(response).parse();

        assertTrue(messages.getMessagesList().size() == 10);
        assertTrue(messages.getMessagesList().get(2).getId()==EXPECTED_ID);
        assertEquals(messages.getMessagesList().get(2).getMessageText(), EXPECTED_MESSAGE_TEXT);
    }

    @Test
    public void parseGsonMessageObject() throws Exception{
        final InputStream mockedInputStream = Mocks.stream("message/message_object");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getMessage");

        final MessageParserFactory messageParserFactory = new MessageParserFactory();
        final IMessage message = messageParserFactory.createGsonMessageParser(response).parse();

        assertEquals(EXPECTED_ID, message.getId());
        assertEquals(EXPECTED_FROM_WHO_ID, message.getFromWhoId());
        assertEquals(EXPECTED_MESSAGE_TEXT, message.getMessageText());
        assertEquals(EXPECTED_DATE, message.getDate());
    }

    @Test
    public void parseMessageListGson() throws Exception{
        final InputStream mockedInputStream = Mocks.stream("message/messages_array.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getMessage");

        final MessageParserFactory messageParserFactory = new MessageParserFactory();
        final IMessageList messages = messageParserFactory.createGsonMessageListParser(response).parse();

        assertTrue(messages.getMessagesList().size() == 10);
        assertTrue(messages.getMessagesList().get(2).getId()==EXPECTED_ID);
        assertEquals(messages.getMessagesList().get(2).getMessageText(), EXPECTED_MESSAGE_TEXT);
    }

    @Test
    public void parseMessageListInObjectGson() throws Exception{
        final InputStream mockedInputStream = Mocks.stream("message/messages_array_with_root_object.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getMessage");

        final MessageParserFactory messageParserFactory = new MessageParserFactory();
        final IMessageList messages = messageParserFactory.createMessageListWithObjectGsonParser(response).parse();

        assertTrue(messages.getMessagesList().size() == 10);
        assertTrue(messages.getMessagesList().get(2).getId()==EXPECTED_ID);
        assertEquals(messages.getMessagesList().get(2).getMessageText(), EXPECTED_MESSAGE_TEXT);
    }
}
