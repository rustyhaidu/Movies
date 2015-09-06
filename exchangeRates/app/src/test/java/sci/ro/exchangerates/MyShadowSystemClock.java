package sci.ro.exchangerates;

import android.os.SystemClock;

import org.robolectric.annotation.Implements;

/**
 * Created by adi on 5/27/2015.
 */
@Implements(value = SystemClock.class, callThroughByDefault = true)
public class MyShadowSystemClock {
    public static long elapsedRealtime() {
        return 0;
    }
}
