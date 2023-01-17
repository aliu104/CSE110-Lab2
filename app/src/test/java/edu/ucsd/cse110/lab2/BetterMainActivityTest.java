package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.w3c.dom.Text;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button but_one = (Button) activity.findViewById(R.id.btn_one);
            Button but_plus = (Button) activity.findViewById(R.id.btn_plus);
            Button but_eq = (Button) activity.findViewById(R.id.btn_equals);

            but_one.performClick();
            but_plus.performClick();
            but_one.performClick();
            but_eq.performClick();

            TextView result = (TextView) activity.findViewById(R.id.display);
            assertEquals("2", result.getText());
        });
    }
}
