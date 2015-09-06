package sci.ro.exchangerates;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sebi on 6/14/15.
 */
public class CalculateExchangeRateTaskWrapper extends CalculateExchangeRate {
    @Override
    public void calculateRate(Context context, ExchangeParams params, Callback resultCallback) {
        new CalculateExchangeTask(resultCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
    }

    static class CalculateExchangeTask extends AsyncTask<ExchangeParams, Void, Float> {
        private Callback callback;

        public CalculateExchangeTask(Callback callback) {
            this.callback = callback;
        }

        @Override
        protected Float doInBackground(ExchangeParams... exchangeParamses) {
            Float result = null;


            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(OPEN_EXCHANGE_URL);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                String valuesJSON = readStream(in);
                CalculateExchangeRate calculator = new CalculateExchangeRate() {
                    @Override
                    public void calculateRate(Context context, ExchangeParams params, Callback resultCallback) {
                        //ignore
                    }
                };
                result = calculator.calculateExchangeRate(calculator.toRates(valuesJSON), exchangeParamses[0]);


            } catch (Exception ex) {
                callback.onError(ex);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }


            try {
                Thread.sleep(SLEEP_IN_SECONDS * 1000);
            } catch (Exception ex) {
            }
            return result;
        }

        @Override
        protected void onPostExecute(Float result) {
            callback.onSuccess(result);
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
