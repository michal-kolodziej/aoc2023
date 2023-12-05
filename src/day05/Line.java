package day05;

import java.util.List;

public class Line {
    private final long destination;
    private final long source;
    private final long range;

    Line(String line) {
        String[] s = line.split(" ");
        this.destination = Long.parseLong(s[0]);
        this.source = Long.parseLong(s[1]);
        this.range = Long.parseLong(s[2]);
    }

    boolean isInRange(long number){
        return number >= source && number < source + range;
    }

    public static long translate(long number, List<Line> map) {
        for (Line line : map) {
            if (line.isInRange(number)) {
                return line.translate(number);
            }
        }
        return number;
    }

    private long translate(long number){
        if(isInRange(number)){
            return number + destination - source;
        }
        throw new RuntimeException("number not is not in this range.");
    }


}
