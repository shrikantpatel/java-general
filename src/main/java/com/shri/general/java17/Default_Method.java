package com.shri.general.java17;

import java.util.Date;

public class Default_Method {

    public interface Logging {
        void log(String message);

        /**
         Adding this method cause the complication error, since the LoggingImplementation
         does not implement the new method

         to get around we add default keyword and add the implementation in the interfaces

          void log(String message, Date date);
         */

        default void log(String message, Date date) {
            System.out.println(date.toString() + ": " + message);
        }

    }

    public class LoggingImplementation implements Logging {
        @Override
        public void log(String message) {
            System.out.println(message);
        }
    }

}
