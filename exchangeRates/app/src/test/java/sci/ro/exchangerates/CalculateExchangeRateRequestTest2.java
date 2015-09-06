package sci.ro.exchangerates;


import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.ExecutorDelivery;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.ResponseDelivery;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.NoCache;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.util.HashMap;
import java.util.concurrent.Executors;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;

/**
 * Created by sebi on 6/16/15.
 * Unit test used to check the functionality fo CalculateExchangeRateRequest.
 * Using mockito to mock the network.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "./app/src/main/AndroidManifest.xml", emulateSdk = 18, reportSdk = 18, shadows = MyShadowSystemClock.class)
public class CalculateExchangeRateRequestTest2 extends BaseCalculateExchangeRateTest {

    private  Network network;

    @Before
    public void before() throws Exception {
        ShadowLog.stream = System.out;
        Robolectric.getFakeHttpLayer().interceptHttpRequests(true);

        // Instantiate the cache
        Cache cache = new NoCache();
        // Set up the network to use HttpURLConnection
        network = spy(new BasicNetwork(new HurlStack()));


        final ResponseDelivery responseDelivery = new ExecutorDelivery(Executors.newSingleThreadExecutor());

        RequestQueue testQueue =
                new RequestQueue(
                        cache,
                        network,
                        1,
                        responseDelivery);
        testQueue.start();
        c = new CalculateExchangeRateRequest(testQueue);
    }


    @Override
    protected void prepareIncomingContent(final int statusCode,final String content) throws Exception {


        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return new NetworkResponse(statusCode, content.getBytes("UTF-8"), new HashMap<String, String>(), false);

            }
        }).when(network).performRequest(any(Request.class));


    }

    @Override
    protected Context getContext() {
        return Robolectric.application.getApplicationContext();
    }
}
