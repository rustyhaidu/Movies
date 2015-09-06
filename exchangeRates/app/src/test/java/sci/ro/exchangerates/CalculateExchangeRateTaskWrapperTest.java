package sci.ro.exchangerates;

import android.content.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.robolectric.shadows.ShadowLog;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by sebi on 6/17/15.
 * Unit test used to check the functionaly of CalculateExchangeRateTaskWrapper.
 */
@RunWith(JUnit4.class)
public class CalculateExchangeRateTaskWrapperTest extends BaseCalculateExchangeRateTest {

    private static HttpURLConnection mockConnection;

    private Context context;

    @Before
    public void setup() {
        context = mock(Context.class);
    }

    @BeforeClass
    public static void init() {
        mockConnection = mock(HttpURLConnection.class);
        final URLStreamHandler handler = new URLStreamHandler() {

            @Override
            protected URLConnection openConnection(final URL arg0)
                    throws IOException {
                return mockConnection;
            }
        };

        URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
            @Override
            public URLStreamHandler createURLStreamHandler(String s) {
                return handler;
            }
        });
    }

    @Override
    protected Context getContext() {
        return context;
    }

    @Before
    public void before() throws Exception {
        ShadowLog.stream = System.out;
        c = new CalculateExchangeRateTaskWrapper() {
            @Override
            public void calculateRate(Context context, ExchangeParams params, Callback resultCallback) {
                Float result = new CalculateExchangeTask(resultCallback).doInBackground(params);
                resultCallback.onSuccess(result);
            }
        };


    }

    @Override
    protected void prepareIncomingContent(int statusCode, final String content) throws Exception {
        given(mockConnection.getInputStream()).willReturn(new ByteArrayInputStream(content.getBytes("UTF-8")));
    }
}
