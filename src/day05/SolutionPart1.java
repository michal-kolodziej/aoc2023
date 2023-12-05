package day05;

import java.util.*;

import static day05.Line.translate;

class SolutionPart1 {
    public static void main(String[] args) {
        new SolutionPart1().solve();
    }

    private void solve() {
        ParsedInput parsed = InputParser.parse(Input.lines);

        OptionalLong min = parsed.getSeeds().stream().mapToLong(seed -> {
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

    }
}
