package javastuff.basicjava;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * System.nanoTime() - elapsed time in nanoseconds relative to some arbitrary point
 *
 * System.currentTimeMillis() - elapsed time in milliseconds since the epoch
 */
public class TimeGames {

    public static void main(String[] argc) {
        final long nanoTime = System.nanoTime();
        final long currentTimeMillis = System.currentTimeMillis();

        System.out.println("nanoTime: " + nanoTime);
        System.out.println("currentTimeMillis: " + currentTimeMillis);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultDateCurrentTimeMillis = new Date(currentTimeMillis);
        Date resultDateNanoTime = new Date(nanoTime);

        System.out.println("\nresultDateNanoTime: " + simpleDateFormat.format(resultDateNanoTime));
        System.out.println("resultDateCurrentTimeMillis: " + simpleDateFormat.format(resultDateCurrentTimeMillis));

        /**
         * DateTime is Joda-Time library. The most recommended time library for Java.
         */
        final DateTime dateTime = DateTime.now();
        System.out.println("\ndateTime: " + dateTime.toString());
    }
}
