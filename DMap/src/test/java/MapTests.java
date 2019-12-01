import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapTests {

    private DashaMapOne dMap1;
    private DashaMapTwo dMap2;
    private DashaMapThree dMap3;

    @Before
    public void setUp() {
        dMap1 = new DashaMapOne();
        dMap2 = new DashaMapTwo();
        dMap3 = new DashaMapThree();
        setMaps();
    }

    private void setMaps() {
        String file = "word-list.txt";
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNext()) {
                String[] currentLine = scanner.nextLine().split(" ");

                dMap1.set(currentLine[0], currentLine[1]);
                dMap2.set(currentLine[0], currentLine[1]);
                dMap3.set(currentLine[0], currentLine[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testSize() {
        long expected = 124;

        Assert.assertEquals(expected, dMap1.size());
        Assert.assertEquals(expected, dMap2.size());
        Assert.assertEquals(expected, dMap3.size());
    }

    @Test
    public void testGet() {
        Integer expected = 34;

        Assert.assertEquals(expected, dMap1.get("both"));
        Assert.assertEquals(expected, dMap2.get("both"));
        Assert.assertEquals(expected, dMap3.get("both"));
    }

    @Test
    public void testDelete() {
        long expected = 123;

        dMap1.delete("both");
        dMap2.delete("both");
        dMap3.delete("both");

        Assert.assertEquals(expected, dMap1.size());
        Assert.assertEquals(expected, dMap2.size());
        Assert.assertEquals(expected, dMap3.size());
    }

}

