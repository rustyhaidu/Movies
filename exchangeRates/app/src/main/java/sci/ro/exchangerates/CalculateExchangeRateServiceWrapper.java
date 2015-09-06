package sci.ro.exchangerates;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by sebi on 6/14/15.
 */
public class CalculateExchangeRateServiceWrapper extends CalculateExchangeRate {
    private Callback callback;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("EXCHANGE_RESULT".equals(intent.getAction())) {
                if (intent.getStringExtra("ERROR") == null) {

                    callback.onSuccess(intent.getFloatExtra("EXCHANGE_RESULT", 0));
                } else {

                    callback.onError(new Exception(intent.getStringExtra("ERROR")));
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            }
        }
    };



    @Override
    public void calculateRate(Context context, ExchangeParams params, Callback resultCallback) {
        this.callback = resultCallback;

        IntentFilter intentFilter = new IntentFilter("EXCHANGE_RESULT");
        intentFilter.setPriority(9999);
        context.registerReceiver(receiver, intentFilter);
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, intentFilter);

        Intent intent = new Intent(context, CalculateExchangeRateService.class);
        intent.putExtra(CalculateExchangeRateService.IN, params.getInRate());
        intent.putExtra(CalculateExchangeRateService.IN_CURRENCY, params.getInCurrency());
        intent.putExtra(CalculateExchangeRateService.OUT_CURRENCY, params.getOutCurrency());

        context.startService(intent);
    }
}
