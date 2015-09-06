package sci.ro.exchangerates;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by sebi on 6/14/15.
 */
public class CalculateExchangeRateRequest extends CalculateExchangeRate {

    private RequestQueue requestQueue;

    public CalculateExchangeRateRequest(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }





    @Override
    public void calculateRate(final Context context, final ExchangeParams params, final Callback resultCallback) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, OPEN_EXCHANGE_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    float result = calculateExchangeRate(toRates(jsonObject.toString()), params);
                    resultCallback.onSuccess(result);
                } catch (Exception ex) {
                    resultCallback.onError(ex);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                resultCallback.onError(volleyError);
            }
        }) {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    Thread.sleep(SLEEP_IN_SECONDS * 1000);
                } catch (Exception ex) {
                }
                return super.parseNetworkResponse(response);
            }
        };

        requestQueue.add(request);
    }

}
