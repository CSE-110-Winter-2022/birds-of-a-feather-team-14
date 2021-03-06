package com.example.birdsofafeatherteam14;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static org.junit.Assert.*;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ProfileCoursesTests {
    @Rule
    public ActivityScenarioRule<ProfileCoursesActivity> scenarioRule = new ActivityScenarioRule<ProfileCoursesActivity>(ProfileCoursesActivity.class);

    // Test to make sure that the display is correct upon initialization
    @Test
    public void testInitialDisplay() {
        ActivityScenario<ProfileCoursesActivity> scenario = scenarioRule.getScenario();
        scenario.moveToState(Lifecycle.State.CREATED);

        scenario.onActivity(activity -> {
            EditText subject_text = activity.findViewById(R.id.enter_subject);
            EditText course_number_text = activity.findViewById(R.id.enter_course_number);

            assertEquals("", subject_text.getText().toString());
            assertEquals("", course_number_text.getText().toString());
        });
    }

    // Test to make sure that the input fails if you attempt to type in an invalid quarter
    @Test
    public void testUpdateDisplay() {
        ActivityScenario<ProfileCoursesActivity> scenario = scenarioRule.getScenario();
        scenario.moveToState(Lifecycle.State.CREATED);

        scenario.onActivity(activity -> {
            TextView error = activity.findViewById(R.id.error_textview);
            EditText subject_text = activity.findViewById(R.id.enter_subject);
            EditText course_number_text = activity.findViewById(R.id.enter_course_number);
            Button enterButton = activity.findViewById(R.id.enter_button);

            subject_text.setText("CSE");
            course_number_text.setText("11");
            enterButton.performClick();

            assertEquals("Added quarter", error.getText());
        });
    }
}
