package day05;

import java.util.List;

public class ParsedInput {
    private final List<Long> seeds;
    private final List<Line> seedToSoil;
    private final List<Line> soilToFertilizer;
    private final List<Line> fertilizerToWater;
    private final List<Line> waterToLight;
    private final List<Line> lightToTemperature;
    private final List<Line> temperatureToHumidity;
    private final List<Line> humidityToLocation;

    ParsedInput(List<Long> seeds, List<Line> seedToSoil, List<Line> soilToFertilizer, List<Line> fertilizerToWater, List<Line> waterToLight, List<Line> lightToTemperature, List<Line> temperatureToHumidity, List<Line> humidityToLocation) {
        this.seeds = seeds;
        this.seedToSoil = seedToSoil;
        this.soilToFertilizer = soilToFertilizer;
        this.fertilizerToWater = fertilizerToWater;
        this.waterToLight = waterToLight;
        this.lightToTemperature = lightToTemperature;
        this.temperatureToHumidity = temperatureToHumidity;
        this.humidityToLocation = humidityToLocation;
    }

    List<Long> getSeeds() {
        return seeds;
    }

    List<Line> getSeedToSoil() {
        return seedToSoil;
    }

    List<Line> getSoilToFertilizer() {
        return soilToFertilizer;
    }

    List<Line> getFertilizerToWater() {
        return fertilizerToWater;
    }

    List<Line> getWaterToLight() {
        return waterToLight;
    }

    List<Line> getLightToTemperature() {
        return lightToTemperature;
    }

    List<Line> getTemperatureToHumidity() {
        return temperatureToHumidity;
    }

    List<Line> getHumidityToLocation() {
        return humidityToLocation;
    }
}
