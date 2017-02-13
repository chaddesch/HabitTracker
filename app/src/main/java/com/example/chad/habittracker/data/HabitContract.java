package com.example.chad.habittracker.data;

import android.provider.BaseColumns;

/**
 * API Contract for the HabitTracker app.
 */

public final class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {}

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */
    public static final class HabitEntry implements BaseColumns {

        /** Name of database table for habits */
        public final static String TABLE_NAME = "habits";

        /**
         * Name of the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME ="name";

        /**
         * Whatever triggered the person to initiate the habit/action.
         *
         * Type: TEXT
         *
         * optional field
         */
        public final static String COLUMN_TRIGGER ="trigger";


        /**
         * The day of the week.
         *
         * Type: INTEGER
         *
         * default: unknown
         */
        public final static String COLUMN_WEEKDAY ="weekday";

        /**
         * The time of day.
         *
         * Type: INTEGER
         *
         * default: unknown (Unknown, Morning, Midday, Afternoon, Evening)
         */
        public final static String COLUMN_DAYTIME ="daytime";


        /**
         * The number_of_times the habit is completed
         *
         * Type: INTEGER
         */
        public final static String COLUMN_NO_OF_TIMES ="number_of_times";

        /**
         * Whether or not the habit was accomplished. Might be helpful for habits that are difficult
         * to remember whether or not you did them today like taking medicine.
         *
         * Type: INTEGER (I really only added this because I wanted a boolean. It's really somewhat
         * unnecessary.)
         */
        public final static String COLUMN_ACCOMPLISHED ="accomplished";

        /**
         * Possible values for weekday.
         */
        public static final int WEEKDAY_UNKNOWN = 0;
        public static final int WEEKDAY_SUNDAY = 1;
        public static final int WEEKDAY_MONDAY = 2;
        public static final int WEEKDAY_TUESDAY = 3;
        public static final int WEEKDAY_WEDNESDAY = 4;
        public static final int WEEKDAY_THURSDAY = 5;
        public static final int WEEKDAY_FRIDAY = 6;
        public static final int WEEKDAY_SATURDAY = 7;

        /**
         * Possible values for daytime.
         */
        public static final int DAYTIME_UNKNOWN = 0;
        public static final int DAYTIME_MORNING = 1;
        public static final int DAYTIME_MIDDAY = 2;
        public static final int DAYTIME_AFTERNOON = 3;
        public static final int DAYTIME_EVENING = 4;

        /**
         * Possible values for number_of_times.
         *
         * Max number_of_times is 10.
         */
        public static final int ONE = 0;
        public static final int TWO = 1;
        public static final int THREE = 2;
        public static final int FOUR = 3;
        public static final int FIVE = 4;
        public static final int SIX = 5;
        public static final int SEVEN = 6;
        public static final int EIGHT = 7;
        public static final int NINE = 8;
        public static final int TEN = 9;

        /**
         * Possible values for accomplished.
         */
        public static final int FALSE = 0;
        public static final int TRUE = 1;
    }
}
