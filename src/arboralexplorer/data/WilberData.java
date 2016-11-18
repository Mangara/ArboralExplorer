/*
 * Copyright 2016 ingo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package arboralexplorer.data;

import arboralexplorer.Pair;
import java.util.ArrayList;
import java.util.List;

public class WilberData {

    private List<Pair<Integer, Integer>> hubSet = null;
    private List<Pair<Integer, Integer>> morePoints = null;
    private List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> splitLines = null;
    private List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> moreLines = null;
    private final boolean[][] grid;

    public WilberData(boolean[][] grid) {
        this.grid = grid;
        hubSet = new ArrayList<>();
        splitLines = new ArrayList<>();
        moreLines = new ArrayList<>();
        morePoints = new ArrayList<>();
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getLines() {
        return splitLines;
    }

    public List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getLines(identifier id) {
        switch (id) {
            case REDLINES:
                return moreLines;
            default:
                return null;
        }
    }

    public void setLines(List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> lines) {
        this.splitLines = lines;
    }

    public List<Pair<Integer, Integer>> getHubs() {
        return hubSet;
    }

    public List<Pair<Integer, Integer>> getPoints(identifier id) {
        switch (id) {
            case REDPOINTS:
                return morePoints;
            default:
                return null;
        }
    }

    public void addLine(int l, int c1, int c2, boolean invert) {
        if (invert) {
            splitLines.add(new Pair<>(new Pair<>(c1, l), new Pair<>(c2, l)));
        } else {
            splitLines.add(new Pair<>(new Pair<>(l, c1), new Pair<>(l, c2)));
        }
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        splitLines.add(new Pair<>(new Pair<>(x1, y1), new Pair(x2, y2)));
    }

    public void addLine(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> line, identifier id) {
        addLine(line.getFirst().getFirst(), line.getFirst().getSecond(), line.getSecond().getFirst(), line.getSecond().getSecond(), id);
    }
    
    public void addLine(int x1, int y1, int x2, int y2, identifier id) {
        switch (id) {
            case REDLINES:
                moreLines.add(new Pair<>(new Pair<>(x1, y1), new Pair(x2, y2)));
            default:
                return;
        }
    }

    public void addHub(int x, int y, boolean invert) {
        setGridPoint(x, y, invert);
        if (invert) {
            hubSet.add(new Pair<>(y, x));
        } else {
            hubSet.add(new Pair<>(x, y));
        }
    }

    public void addPoint(Pair<Integer, Integer> point, identifier id) {
        addPoint(point.getFirst(), point.getSecond(), id);
    }
    
    public void addPoint(int x, int y, identifier id) {
        switch (id) {
            case GREENPOINTS:
                hubSet.add(new Pair<>(x, y));
            case REDPOINTS:
                morePoints.add(new Pair<>(x, y));
            default:
                return;
        }
    }

    public void setGridPoint(int x, int y, boolean invert) {
        if (invert) {
            grid[y][x] = true;
        } else {
            grid[x][y] = true;
        }
    }

    public enum identifier {
        REDLINES, REDPOINTS, GREENPOINTS
    }
}
