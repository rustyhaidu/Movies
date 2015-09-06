package sci.ro.exchangerates.it;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import sci.ro.exchangerates.CalculateExchangeRate;
import sci.ro.exchangerates.CalculateExchangeRateTaskWrapper;
import sci.ro.exchangerates.HttpRequestCheck;

/**
 * Created by sebi on 6/16/15.
 * Integration test used to check the functionality of CalculateExchangeRateTaskWrapper.
 */


@RunWith(RobolectricTestRunner.class)
@Config(manifest = "./app/src/main/AndroidManifest.xml", emulateSdk = 18, reportSdk = 18 )
public class CalculateExchangeRateTaskWrapperTest {

    @Test
    public void test_usd_to_usd() throws Exception {

        CalculateExchangeRateTaskWrapper c = new CalculateExchangeRateTaskWrapper();

        CalculateExchangeRate.ExchangeParams params = new CalculateExchangeRate.ExchangeParams(1, "USD", "USD");

        HttpRequestCheck httpRequestCheck = new HttpRequestCheck();

        c.calculateRate(Robolectric.application.getApplicationContext(), params, httpRequestCheck);
        httpRequestCheck.waitForResult();

        Assert.assertTrue(httpRequestCheck.isSuccess());

        float result = httpRequestCheck.getResult();
        Assert.assertEquals(1f, result);
    }



    @Test
    public void test_euro_to_usd() throws Exception {

        CalculateExchangeRateTaskWrapper c = new CalculateExchangeRateTaskWrapper();

        CalculateExchangeRate.ExchangeParams params = new CalculateExchangeRate.ExchangeParams(1, "EUR", "USD");

        HttpRequestCheck  httpRequestCheck = new HttpRequestCheck();

        c.calculateRate(Robolectric.application.getApplicationContext(), params, httpRequestCheck);
        httpRequestCheck.waitForResult();

        Assert.assertTrue(httpRequestCheck.isSuccess());

        float result = httpRequestCheck.getResult();
        //probably will fail in a year :)
        Assert.assertTrue(result > 1.05f);


    }
}
