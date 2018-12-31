/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package lambdas.stream;

import org.junit.Assert;
import org.junit.Test;

import lambdas.stream.domain.Track;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mr.24
 * @version Id: MaxAndMinDemo, v 1.0 2018/12/31 上午10:12 Exp $$
 */
public class MaxAndMinDemo {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("wilson", 234));
        tracks.add(new Track("Kobe", 233));
        tracks.add(new Track("James", 231));

        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }

        Assert.assertEquals(tracks.get(2), shortestTrack);
    }

    @Test
    public void testMaxAndMin() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("wilson", 234));
        tracks.add(new Track("Kobe", 233));
        tracks.add(new Track("James", 231));

        Track shortestTrack = tracks.stream()
                // 使用曲目长度作为排序指标
                .min(Comparator.comparing(track -> track.getLength()))
                .get();

        Assert.assertEquals(tracks.get(2), shortestTrack);
    }

    @Test
    public void testAnyMatch() {
        List<Track> tracks = new LinkedList<>();
        tracks.add(new Track("wilson", 234));
        tracks.add(new Track("Kobe", 233));
        tracks.add(new Track("James", 231));

        boolean result = tracks.stream()
                .anyMatch(data -> data.getLength() > 12);

        Assert.assertEquals(result, true);
    }

    @Test
    public void testFindFirst() {
        List<Track> tracks = new LinkedList<>();
        tracks.add(new Track("wilson", 234));
        tracks.add(new Track("Kobe", 233));
        tracks.add(new Track("James", 231));
        tracks.add(new Track("KD", 231));

        Track track = tracks.stream()
                .findFirst().get();

        Assert.assertEquals(track.getLength(), 234);
    }
}
