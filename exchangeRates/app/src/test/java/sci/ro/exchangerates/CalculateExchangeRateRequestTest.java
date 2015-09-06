package sci.ro.exchangerates;


import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.ExecutorDelivery;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.ResponseDelivery;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.NoCache;

import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.util.concurrent.Executors;

/**
 * Created by sebi on 6/16/15.
 * Unit test used to check the functionality fo CalculateExchangeRateRequest.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "./app/src/main/AndroidManifest.xml", emulateSdk = 18, reportSdk = 18, shadows = MyShadowSystemClock.class)
public class CalculateExchangeRateRequestTest extends BaseCalculateExchangeRateTest {


    @Before
    public void before() throws Exception {
        ShadowLog.stream = System.out;
        Robolectric.getFakeHttpLayer().interceptHttpRequests(true);

        // Instantiate the cache
        Cache cache = new NoCache();
        // Set up the network to use apache HttpClient
        Network network = new BasicNetwork(new HttpClientStack(new DefaultHttpClient()));

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
    protected void prepareIncomingContent(int statusCode, String content) {
        Robolectric.addPendingHttpResponse(statusCode, content);
    }

    @Override
    protected Context getContext() {
        return Robolectric.application.getApplicationContext();
    }
}
