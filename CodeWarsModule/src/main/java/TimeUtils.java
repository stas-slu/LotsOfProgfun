import java.util.concurrent.TimeUnit;

class TimeUtils {
    public static String convertTime(int timeDiff) { //in seconds

        long days = TimeUnit.SECONDS.toDays(timeDiff);
        timeDiff -= TimeUnit.DAYS.toSeconds(days);
        long hours = TimeUnit.SECONDS.toHours(timeDiff);
        timeDiff -= TimeUnit.HOURS.toSeconds(hours);
        long minutes = TimeUnit.SECONDS.toMinutes(timeDiff);
        timeDiff -= TimeUnit.MINUTES.toSeconds(minutes);
        long seconds = timeDiff; //last seconds

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(days);
        stringBuilder.append(" ");

        stringBuilder.append(hours);
        stringBuilder.append(" ");

        stringBuilder.append(minutes);
        stringBuilder.append(" ");

        stringBuilder.append(seconds);

        return stringBuilder.toString();
    }
}