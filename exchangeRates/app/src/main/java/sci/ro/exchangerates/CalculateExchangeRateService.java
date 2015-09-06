package sci.ro.exchangerates;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sebi on 6/14/15.
 */
public class CalculateExchangeRateService extends IntentService {

    public static final String IN = "IN";
    public static final String IN_CURRENCY = "IN_CURRENCY";
    public static final String OUT_CURRENCY = "OUT_CURRENCY";
    private static String TAG = "CalculateExchangeRateService";

    public CalculateExchangeRateService() {
        super("CalculateExchangeRateService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "Service started");

        float inRate = intent.getFloatExtra(IN, 0);
        String inCurrency = intent.getStringExtra(IN_CURRENCY);
        String outCurrency = intent.getStringExtra(OUT_CURRENCY);

        final List<Exception> exs = new LinkedList<>();
        CalculateExchangeRateTaskWrapper.CalculateExchangeTask c = new CalculateExchangeRateTaskWrapper.CalculateExchangeTask(new CalculateExchangeRate.Callback() {
            @Override
            public void onError(Exception ex) {
                exs.add(ex);
            }

            @Override
            public void onSuccess(Float result) {

            }
        });

        CalculateExchangeRate.ExchangeParams params = new CalculateExchangeRate.ExchangeParams(inRate, inCurrency, outCurrency);


        float result = c.doInBackground(params);



        Intent intentResult = new Intent("EXCHANGE_RESULT");
        if (exs.isEmpty()) {
            intentResult.putExtra("EXCHANGE_RESULT", result);
            Log.d(TAG, "Sending result: " + result);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intentResult);
        } else {
            Log.w(TAG, "Sending error: " + exs.get(0).getMessage());
            intentResult.putExtra("ERROR", exs.get(0).getMessage());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intentResult);
        }
    }
}
