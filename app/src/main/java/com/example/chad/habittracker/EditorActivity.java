package com.example.chad.habittracker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.chad.habittracker.data.HabitContract.HabitEntry;
import com.example.chad.habittracker.data.HabitDbHelper;

/**
 * Created by Chad on 2/12/2017.
 */

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;

    private EditText mTriggerEditText;

    private Spinner mWeekdaySpinner;

    private Spinner mDaytimeSpinner;

    private Spinner mNoOfTimesSpinner;

    private Spinner mAccomplishedSpinner;

    private int mWeekday = HabitEntry.WEEKDAY_UNKNOWN;

    private int mDaytime = HabitEntry.DAYTIME_UNKNOWN;

    private int mNoOfTimes = HabitEntry.ONE;

    private int mAccomplished = HabitEntry.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        //Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.edit_habit_name);
        mTriggerEditText = (EditText) findViewById(R.id.edit_habit_trigger);
        mWeekdaySpinner = (Spinner) findViewById(R.id.spinner_weekday);
        mDaytimeSpinner = (Spinner) findViewById(R.id.spinner_daytime);
        mNoOfTimesSpinner = (Spinner) findViewById(R.id.spinner_no_of_times);
        mAccomplishedSpinner = (Spinner) findViewById(R.id.spinner_accomplished);

        setupWeekdaySpinner();
        setupDaytimeSpinner();
        setupNoOfTimesSpinner();
        setupAccomplishedSpinner();
    }

    /**
     * Setup the dropdown spinner that allows the user to select the weekday.
     */
    private void setupWeekdaySpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter weekdaySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_weekday_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        weekdaySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mWeekdaySpinner.setAdapter(weekdaySpinnerAdapter);

        // Set the integer mSelected to the constant values
        mWeekdaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.sunday))) {
                        mWeekday = HabitEntry.WEEKDAY_SUNDAY;
                    } else if (selection.equals(getString(R.string.monday))) {
                        mWeekday = HabitEntry.WEEKDAY_MONDAY;
                    } else if (selection.equals(getString(R.string.tuesday))) {
                        mWeekday = HabitEntry.WEEKDAY_TUESDAY;
                    } else if (selection.equals(getString(R.string.wednesday))) {
                        mWeekday = HabitEntry.WEEKDAY_WEDNESDAY;
                    } else if (selection.equals(getString(R.string.thursday))) {
                        mWeekday = HabitEntry.WEEKDAY_THURSDAY;
                    } else if (selection.equals(getString(R.string.friday))) {
                        mWeekday = HabitEntry.WEEKDAY_FRIDAY;
                    } else if (selection.equals(getString(R.string.saturday))) {
                        mWeekday = HabitEntry.WEEKDAY_SATURDAY;
                    } else {
                        mWeekday = HabitEntry.WEEKDAY_UNKNOWN;
                    }
                }
            }
            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mWeekday = HabitEntry.WEEKDAY_UNKNOWN;
            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the weekday.
     */
    private void setupDaytimeSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter daytimeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_daytime_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        daytimeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mDaytimeSpinner.setAdapter(daytimeSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mDaytimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.morning))) {
                        mDaytime = HabitEntry.DAYTIME_MORNING;
                    } else if (selection.equals(getString(R.string.midday))) {
                        mDaytime = HabitEntry.DAYTIME_MIDDAY;
                    } else if (selection.equals(getString(R.string.afternoon))) {
                        mDaytime = HabitEntry.DAYTIME_AFTERNOON;
                    } else if (selection.equals(getString(R.string.evening))) {
                        mDaytime = HabitEntry.DAYTIME_EVENING;
                    } else {
                        mDaytime = HabitEntry.DAYTIME_UNKNOWN;
                    }
                }
            }
            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mDaytime = HabitEntry.DAYTIME_UNKNOWN;
            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the weekday.
     */
    private void setupNoOfTimesSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter noOfTimesSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_no_of_times_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        noOfTimesSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mNoOfTimesSpinner.setAdapter(noOfTimesSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mNoOfTimesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.one))) {
                        mNoOfTimes = HabitEntry.ONE;
                    } else if (selection.equals(getString(R.string.two))) {
                        mNoOfTimes = HabitEntry.TWO;
                    } else if (selection.equals(getString(R.string.three))) {
                        mNoOfTimes = HabitEntry.THREE;
                    } else if (selection.equals(getString(R.string.four))) {
                        mNoOfTimes = HabitEntry.FOUR;
                    } else if (selection.equals(getString(R.string.five))) {
                        mNoOfTimes = HabitEntry.FIVE;
                    } else if (selection.equals(getString(R.string.six))) {
                        mNoOfTimes = HabitEntry.SIX;
                    } else if (selection.equals(getString(R.string.seven))) {
                        mNoOfTimes = HabitEntry.SEVEN;
                    } else if (selection.equals(getString(R.string.eight))) {
                        mNoOfTimes = HabitEntry.EIGHT;
                    } else if (selection.equals(getString(R.string.nine))) {
                        mNoOfTimes = HabitEntry.NINE;
                    } else {
                        mNoOfTimes = HabitEntry.TEN;
                    }
                }
            }
            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mNoOfTimes = HabitEntry.ONE;
            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the weekday.
     */
    private void setupAccomplishedSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter accomplishedSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_accomplished_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        accomplishedSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mAccomplishedSpinner.setAdapter(accomplishedSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mAccomplishedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.no))) {
                        mAccomplished = HabitEntry.FALSE;
                    } else {
                        mAccomplished = HabitEntry.TRUE;
                    }
                }
            }
            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mAccomplished = HabitEntry.FALSE;
            }
        });
    }

    /**
     * Get user input from editor and save new pet into database.
     */
    private void insertHabit() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String nameString = mNameEditText.getText().toString().trim();
        String triggerString = mTriggerEditText.getText().toString().trim();

        // Create database helper
        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, nameString);
        values.put(HabitEntry.COLUMN_TRIGGER, triggerString);
        values.put(HabitEntry.COLUMN_WEEKDAY, mWeekday);
        values.put(HabitEntry.COLUMN_DAYTIME, mDaytime);
        values.put(HabitEntry.COLUMN_NO_OF_TIMES, mNoOfTimes);
        values.put(HabitEntry.COLUMN_ACCOMPLISHED, mAccomplished);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save pet to database
                insertHabit();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
