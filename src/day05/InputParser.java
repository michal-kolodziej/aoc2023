package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static ParsedInput parse(String linesString) {
        List<String> lines = Arrays.stream(linesString.split("\n")).toList();
        List<Long> seeds = Arrays.stream(lines.get(0).split(":")[1].strip().split(" ")).map(Long::parseLong).toList();

        List<Line> seedToSoil = parseInternal("seed-to-soil map:", lines);
        List<Line> soilToFertilizer = parseInternal("soil-to-fertilizer map:", lines);
        List<Line> fertilizerToWater = parseInternal("fertilizer-to-water map:", lines);
        List<Line> waterToLight = parseInternal("water-to-light map:", lines);
        List<Line> lightToTemperature = parseInternal("light-to-temperature map:", lines);
        List<Line> temperatureToHumidity = parseInternal("temperature-to-humidity map:", lines);
        List<Line> humidityToLocation = parseInternal("humidity-to-location map:", lines);

        return new ParsedInput(seeds, seedToSoil, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation);
    }

    private static List<Line> parseInternal(String s, List<String> lines) {
        int headerIndex = lines.indexOf(s);
        int lineIndex = headerIndex + 1;
        List<Line> result = new ArrayList<>();
        while (lineIndex < lines.size() && !lines.get(lineIndex).isBlank()) {
            result.add(new Line(lines.get(lineIndex)));
            lineIndex++;
        }
        return result;
    }
}
