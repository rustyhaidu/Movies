package sci.ro.exchangerates;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sebi on 6/14/15.
 */
public abstract class CalculateExchangeRate {

    public static final String OPEN_EXCHANGE_URL = "https://openexchangerates.org/api/latest.json?app_id=8d96eb1163334b3aa27b37617ec253a6";

    static final DecimalFormat DF = new DecimalFormat("#.###");

    static final long SLEEP_IN_SECONDS = 0;

    public interface Callback {
        void onError(Exception ex);

        void onSuccess(Float result);
    }

    public static class ExchangeRates {
        //base currency
        private String base;
        Map<String, Float> rates;

        public ExchangeRates(String baseCurrency, Map<String, Float> rates) {
            this.base = baseCurrency;
            this.rates = rates;
        }

        public String getBaseCurrency() {
            return base;
        }


        public Map<String, Float> getRates() {
            return rates;
        }


    }

    public static class ExchangeParams {
        float inRate;
        String inCurrency;
        String outCurrency;

        public ExchangeParams(float inRate, String inCurrency, String outCurrency) {

            this.inRate = inRate;
            this.inCurrency = inCurrency;
            this.outCurrency = outCurrency;
        }


        public float getInRate() {
            return inRate;
        }

        public String getInCurrency() {
            return inCurrency;
        }

        public String getOutCurrency() {
            return outCurrency;
        }
    }


    public abstract void calculateRate(Context context,
                                       CalculateExchangeRateRequest.ExchangeParams params,
                                       Callback resultCallback);


    public List<String> toRates(ExchangeRates rates) {
        List<String> result = new LinkedList<>();
        Map<String, Float> ratesMap = rates.getRates();

        for (Map.Entry<String, Float> rateEntry : ratesMap.entrySet()){
            String currentCurrency = rateEntry.getKey();
            Float value = rateEntry.getValue();
            result.add(currentCurrency + " : " + value);
        }


        return result;
    }

    protected final Float calculateExchangeRate(ExchangeRates rates, ExchangeParams exchangeParams) throws ParseException {
        Float result;

        Float inRate = rates != null && rates.getRates() != null ? rates.getRates().get(exchangeParams.getInCurrency()) : null;
        Float outRate = rates != null && rates.getRates() != null ? rates.getRates().get(exchangeParams.getOutCurrency()) : null;

        if (inRate != null && outRate != null) {
            result = exchangeParams.getInRate() * outRate / inRate;
        } else {
            throw new ParseException(inRate == null ? "No rate for INT Currency" : "No rate for OUT Currency", 0);
        }

        return result;
    }


    protected ExchangeRates toRates(String json) throws JSONException, ParseException {
        try {

            ExchangeRates result = new Gson().fromJson(json, ExchangeRates.class);
            if (result != null) {
                if (result.base == null) {
                    throw new ParseException("no base currency", 0);
                }
                if (result.getRates() == null) {
                    throw new ParseException("no rate", 0);
                }
            }
            return result;
        }
        catch (ParseException pEx) {
            throw pEx;
        }
        catch (JsonParseException ex2) {
            throw new ParseException(ex2.getMessage(), 0);
        } catch (Exception ex) {
            throw new JSONException(ex.getMessage());
        }
    }

}
