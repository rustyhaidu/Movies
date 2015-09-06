package sci.ro.exchangerates;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sebi on 6/14/15.
 * Performs the ExchangeRate calculation by using a Thread to get the Rates via HTTP.
 */
public class CalculateExchangeRateThreadWrapper extends CalculateExchangeRate {
    @Override
    public void calculateRate(Context context, ExchangeParams params, Callback resultCallback) {
        //Executors.newFixedThreadPool(5).execute(new CalculateExchangeTask(resultCallback, params));

        new Thread(new CalculateExchangeTask(resultCallback, params)).start();
    }

    class CalculateExchangeTask implements Runnable {
        private Callback callback;
        private ExchangeParams exchangeParams;

        public CalculateExchangeTask(Callback callback, ExchangeParams exchangeParams) {
            this.callback = callback;
            this.exchangeParams = exchangeParams;
        }


        public  void run() {
            try {
                Float result = null;


                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL(OPEN_EXCHANGE_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                    String valuesJSON = readStream(in);

                    ExchangeRates rates = toRates(valuesJSON);
                    result = calculateExchangeRate(rates,
                            exchangeParams);


                } catch (Exception ex) {
                    callback.onError(ex);
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }


                callback.onSuccess(result);
            }catch (Exception ex) {
                callback.onError(ex);
            }

        }


        private String readStream(InputStream is) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while (i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                return bo.toString("UTF-8");
            } catch (IOException e) {
                return "";
            }
        }
    }
}
