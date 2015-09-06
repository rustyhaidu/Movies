package sci.ro.exchangerates;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;


public class ExchangeRatesActivity extends Activity {
    private static final DecimalFormat DF = new DecimalFormat("#.###");
    private static final String TAG = "ExchangeRatesActivity";

    private CalculateExchangeRate calculateExchangeRate;
    private ProgressBar pg;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rates);
        calculateExchangeRate = new CalculateExchangeRateThreadWrapper();


    }

    private class MyCallback implements CalculateExchangeRate.Callback {
        @Override
        public void onError(final Exception ex) {

            Log.e(TAG, "Error calculating rates.", ex);
            pg.post(new Runnable() {
                @Override
                public void run() {
                    error.setVisibility(View.VISIBLE);
                    error.setText(ex.getMessage());
                    pg.setVisibility(View.GONE);
                }
            });

        }

        @Override
        public void onSuccess(final Float result) {
            final EditText out = (EditText) findViewById(R.id.value_2);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (result != null) {
                        out.setText(DF.format(result));
                    } else {
                        out.setText("0");
                    }
                    pg.setVisibility(View.GONE);
                }
            });
        }
    }

    public void calculate(View calculate) {

        error = (TextView) findViewById(R.id.error);
        EditText in = (EditText) findViewById(R.id.value_1);
        Spinner inCurrency = (Spinner) findViewById(R.id.currency_1);
        Spinner outCurrency = (Spinner) findViewById(R.id.currency_2);
        pg = (ProgressBar) findViewById(R.id.progress);
        pg.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);

        float inValue = 0.0f;
        try {
            inValue = DF.parse(in.getText().toString()).floatValue();
        } catch (ParseException ex) {
            Log.e(TAG, "Error getting in value", ex);
        }


        calculateExchangeRate.calculateRate(this,
                new CalculateExchangeRate.ExchangeParams(inValue,
                        inCurrency.getSelectedItem().toString(),
                        outCurrency.getSelectedItem().toString()
                ), new MyCallback());
    }
}
