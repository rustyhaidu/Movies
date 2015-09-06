package sci.ro.exchangerates.ft;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;

import sci.ro.exchangerates.ExchangeRatesActivity;
import sci.ro.exchangerates.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.Espresso.unregisterIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

/**
 * Created by sebi on 6/14/15.
 */
public class CalculateExchangeRateExpressoTest extends ActivityInstrumentationTestCase2<ExchangeRatesActivity> {

    private ExchangeRatesActivity mActivity;

    public CalculateExchangeRateExpressoTest() {
        super(ExchangeRatesActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();


        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();


        registerIdlingResources(mActivity);
    }

    @After
    public void tearDown() throws Exception{
        unregisterIdlingResources(mActivity);
    }


    @LargeTest
    public void test_convert_euro_to_euro() {


        // Type text and then press the button.
        onView(ViewMatchers.withId(R.id.value_1))
                .perform(typeText("1"), closeSoftKeyboard());

        onView(withId(R.id.currency_1)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("EUR")))
                .perform(click());

        onView(withId(R.id.currency_2)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("EUR")))
                .perform(click());

        onView(withId(R.id.calculate)).perform(click());

        onView(withId(R.id.value_2)).check(matches(withText("1")));
    }


    @LargeTest
    public void test_convert_euro_to_usd() {
        // Type text and then press the button.
        onView(withId(R.id.value_1))
                .perform(typeText("1"), closeSoftKeyboard());

        onView(withId(R.id.currency_1)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("EUR")))
                .perform(click());


        onView(withId(R.id.currency_2)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("USD")))
                .perform(click());


        onView(withId(R.id.calculate)).perform(click());

        onView(withId(R.id.value_2)).check(matches(withText(startsWith("1."))));
    }
}
