package sci.ro.exchangerates;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by sebi on 6/13/15.
 */
public class HttpRequestCheck<T> implements CalculateExchangeRate.Callback {

    private static long WAIT_TIMEOUT_SECONDS = 20;
    private Semaphore semaphore;
    CalculateExchangeRate.Callback realCallback;
    private Exception error;
    private AtomicBoolean success = new AtomicBoolean(false);
    private Float result;

    public HttpRequestCheck(CalculateExchangeRate.Callback realCallback) {
        this.realCallback = realCallback;
        semaphore = new Semaphore(1);
       try {
           semaphore.acquire();
       }catch (Exception ex) {}

    }




    public HttpRequestCheck() {
        this(null);
    }

    @Override
    public void onError(Exception ex) {
        //ex.printStackTrace();
        error = ex;

        if (realCallback != null) {
            realCallback.onError(ex);
        }
        semaphore.release();
    }

    @Override
    public void onSuccess(Float result) {
        this.result = result;

        if (realCallback != null) {
            realCallback.onSuccess(result);
        }
        success.set(true);
        semaphore.release();
    }


    public boolean isSuccess() {
        return error == null && success.get();
    }


    public void waitForResult() {
        try {
            if (!semaphore.tryAcquire(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                error = new TimeoutException("Timeout after: " + WAIT_TIMEOUT_SECONDS + " Seconds.");
            }

        }catch (Throwable th) {

        }
    }

    public Exception getError() {
        return error;
    }

    public Float getResult() {
        return result;
    }
}
