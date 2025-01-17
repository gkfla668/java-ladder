package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> line;

    public Line(int width) {
        this.line = createLine(width);
    }

    private List<Boolean> createLine(int width) {
        Random random = new Random();
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            points.add(random.nextBoolean());
        }

        return createValidLine(points);
    }

    private List<Boolean> createValidLine(List<Boolean> points) {
        int width = points.size();

        for (int i = 0; i < width; i++) {
            modifyPoint(points, i);
        }

        return points;
    }

    private void modifyPoint(List<Boolean> points, int pointIdx) {
        int width = points.size();
        int lastIdx = width - 1;

        if (pointIdx != lastIdx && isValidPoints(points, pointIdx)) {
            points.set(pointIdx + 1, false);
        }
    }

    private boolean isValidPoints(List<Boolean> points, int index) {
        return points.get(index) && points.get(index + 1);
    }

    public List<Boolean> getLine() {
        return this.line;
    }
}