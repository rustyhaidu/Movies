package sci.ro.exchangerates.ft;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.EditText;
import android.widget.Spinner;

import junit.framework.Assert;

import org.junit.Before;

import java.lang.Thread;

import sci.ro.exchangerates.ExchangeRatesActivity;
import sci.ro.exchangerates.R;

/**
 * Created by sebi on 6/14/15.
 */
public class CalculateExchangeRateUITest extends ActivityInstrumentationTestCase2<ExchangeRatesActivity> {
    private static final long WAIT_SECONDS = 5;
    private ExchangeRatesActivity mActivity;

    private EditText value1;
    private Spinner currency1;
    private Spinner currency2;
    private EditText value2;


    public CalculateExchangeRateUITest() {
        super(ExchangeRatesActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        setActivityInitialTouchMode(true);
        value1 = (EditText) mActivity.findViewById(R.id.value_1);
        value2 = (EditText) mActivity.findViewById(R.id.value_2);
        currency1 = (Spinner) mActivity.findViewById(R.id.currency_1);
        currency2 = (Spinner) mActivity.findViewById(R.id.currency_2);


    }


    @LargeTest
    public void test_convert_euro_to_euro() throws Throwable {
        // Type text and then press the button.

        setValues("1", 0, 0);

        waitForUI();

        Assert.assertEquals("1", value2.getText().toString());

    }


    @LargeTest
    public void test_convert_euro_to_usd() throws Throwable {
        // Type text and then press the button.

        setValues("1", 0, 2);



        waitForUI();

        Assert.assertTrue(value2.getText().toString().startsWith("1."));

    }

    protected void waitForUI() throws Exception{
        getInstrumentation().waitForIdleSync();
        Thread.sleep(WAIT_SECONDS * 1000);
    }

    public void setValues(final String v1, final int c1, final int c2) throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                value1.setText(v1);

                currency1.setSelection(c1);
                currency2.setSelection(c2);
                mActivity.findViewById(R.id.calculate).performClick();
            }
        });

    }


}
