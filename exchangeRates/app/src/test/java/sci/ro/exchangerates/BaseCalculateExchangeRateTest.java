package sci.ro.exchangerates;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * Created by sebi on 6/17/15.
 */
public abstract class BaseCalculateExchangeRateTest {
    protected CalculateExchangeRate c;

    @Test
    public void test_page_not_available() throws Exception {
        prepareIncomingContent(400, "Page not available");


        CalculateExchangeRate.ExchangeParams params = new CalculateExchangeRate.ExchangeParams(1, "EUR", "USD");

        HttpRequestCheck httpRequestCheck = new HttpRequestCheck();

        c.calculateRate(getContext(), params, httpRequestCheck);
        httpRequestCheck.waitForResult();

        Assert.assertNotNull(httpRequestCheck.getError());

        Assert.assertNull(httpRequestCheck.getResult());
    }

    protected abstract Context getContext();



    @Test
    public void test_wrong_content() throws Exception {
        prepareIncomingContent(200, "{\"dummy\":\"json\"}");


        CalculateExchangeRate.ExchangeParams params = new CalculateExchangeRate.ExchangeParams(1, "EUR", "USD");

        HttpRequestCheck httpRequestCheck = new HttpRequestCheck();

        c.calculateRate(getContext(), params, httpRequestCheck);
        httpRequestCheck.waitForResult();

        Assert.assertNotNull(httpRequestCheck.getError());

        // httpRequestCheck.getError().printStackTrace();
        Assert.assertTrue(httpRequestCheck.getError() instanceof ParseException);


        Assert.assertNull(httpRequestCheck.getResult());
    }


    @Test
    public void test_euro_ron() throws Exception {
        String json = readFile(this.getClass().getClassLoader().getResourceAsStream("res/rates.json"));

        prepareIncomingContent(200, json);

        CalculateExchangeRate.ExchangeParams params = new CalculateExchangeRate.ExchangeParams(1, "EUR", "USD");

        HttpRequestCheck httpRequestCheck = new HttpRequestCheck();

        c.calculateRate(getContext(), params, httpRequestCheck);
        httpRequestCheck.waitForResult();

        Assert.assertTrue(httpRequestCheck.isSuccess());

        Assert.assertEquals(1.1276474f, httpRequestCheck.getResult());
    }


    protected String readFile( InputStream file ) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }

        return stringBuilder.toString();
    }

    protected abstract void prepareIncomingContent(int statusCode, String content) throws Exception;
}
