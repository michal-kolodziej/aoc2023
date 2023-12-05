package day05;

import java.util.OptionalLong;
import java.util.stream.LongStream;

import static day05.Line.translate;

class SolutionPart2 {
    public static void main(String[] args) {
        new SolutionPart2().solve();
    }

    private void solve() {
        ParsedInput parsed = InputParser.parse(Input.lines);
        long lowest = Long.MAX_VALUE;

        for (int i = 0; i < parsed.getSeeds().size(); i+=2) {
            System.out.println("i: " + i);
            long rangeStart = parsed.getSeeds().get(i);
            long rangeEnd = rangeStart + parsed.getSeeds().get(i+1);

            OptionalLong min = LongStream.range(rangeStart, rangeEnd).map(seed -> {
                long soil = translate(seed, parsed.getSeedToSoil());
                long fertilizer = translate(soil, parsed.getSoilToFertilizer());
                long water = translate(fertilizer, parsed.getFertilizerToWater());
                long light = translate(water, parsed.getWaterToLight());
                long temperature = translate(light, parsed.getLightToTemperature());
                long humidity = translate(temperature, parsed.getTemperatureToHumidity());
                long location = translate(humidity, parsed.getHumidityToLocation());
                return location;
            }).min();

            System.out.println("min: " + min.getAsLong());

            if(min.getAsLong() < lowest){
                lowest = min.getAsLong();
            }
        }


        System.out.println("min: " + lowest);

    }
}
