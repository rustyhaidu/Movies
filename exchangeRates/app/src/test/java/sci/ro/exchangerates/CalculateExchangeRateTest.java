package sci.ro.exchangerates;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;

/**
 * Unit Test used to check the functionality of CalculateExchangeRate.
 * Created by sebi on 6/16/15.
 */
public class CalculateExchangeRateTest {

    private CalculateExchangeRate calculator = new CalculateExchangeRate() {
        @Override
        public void calculateRate(Context context, ExchangeParams params, Callback resultCallback) {
            //in in scope
        }
    };



    @Test(expected = ParseException.class)
    public void test_null_rates() throws Exception{
        calculator.calculateExchangeRate(null, new CalculateExchangeRate.ExchangeParams(1, "EUR", "USD"));
    }

    @Test(expected = ParseException.class)
    public void test_invalid_rate_no_in_rate() throws Exception{
        CalculateExchangeRate.ExchangeRates rates = new CalculateExchangeRate.ExchangeRates("USD",
                new HashMap<String , Float>());


        calculator.calculateExchangeRate(rates, new CalculateExchangeRate.ExchangeParams(1, "EUR", "USD"));
    }


    @Test
    public void test_convertion_to_same_currency() throws Exception{
        HashMap<String , Float> ratesMap = new HashMap<String , Float>();
        ratesMap.put("EUR", 1.1f);
        CalculateExchangeRate.ExchangeRates rates = new CalculateExchangeRate.ExchangeRates("USD",
                ratesMap);


        float result  = calculator.calculateExchangeRate(rates, new CalculateExchangeRate.ExchangeParams(1, "EUR", "EUR"));
        Assert.assertEquals(1f, result);

        result  = calculator.calculateExchangeRate(rates, new CalculateExchangeRate.ExchangeParams(22.3232f, "EUR", "EUR"));
        Assert.assertEquals(22.3232f, result);
    }

    @Test
    public void test_convertion_1() throws Exception{
        HashMap<String , Float> ratesMap = new HashMap<String , Float>();
        ratesMap.put("EUR", 2f);
        ratesMap.put("RON", 4f);
        CalculateExchangeRate.ExchangeRates rates = new CalculateExchangeRate.ExchangeRates("USD",
                ratesMap);


        float result  = calculator.calculateExchangeRate(rates, new CalculateExchangeRate.ExchangeParams(1, "EUR", "RON"));
        Assert.assertEquals(2f, result);

        result  = calculator.calculateExchangeRate(rates, new CalculateExchangeRate.ExchangeParams(22.22f, "RON", "EUR"));
        Assert.assertEquals(11.11f, result);
    }

    @Test(expected = ParseException.class)
    public void parse_invalid_content() throws Exception {
        String test = "ana are mere";
        calculator.toRates(test);
    }

    @Test(expected = ParseException.class)
    public void parse_no_base() throws Exception {
        String test = "{\"2\":\"2\"}";
        calculator.toRates(test);
    }


    @Test(expected = ParseException.class)
    public void parse_no_rates() throws Exception {
        String test = "{\"base\":\"usd\"}";
        calculator.toRates(test);
    }


    @Test
    public void parse_rates() throws Exception {

        String test = readFile(this.getClass().getClassLoader().getResourceAsStream("res/rates.json"));
        CalculateExchangeRate.ExchangeRates rates = calculator.toRates(test);

        Assert.assertNotNull(rates);

        Assert.assertNotNull(rates.getRates().get("USD"));
        Assert.assertNotNull(rates.getRates().get("EUR"));
        Assert.assertNotNull(rates.getRates().get("CHF"));
        Assert.assertNotNull(rates.getRates().get("RON"));

        Assert.assertEquals(1f, rates.getRates().get("USD"));
        Assert.assertEquals(0.886802f, rates.getRates().get("EUR"));
    }

    private String readFile( InputStream file ) throws IOException {
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
}
