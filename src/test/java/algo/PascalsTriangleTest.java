package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangleTest {
    PascalsTriangle cl = new PascalsTriangle();

    @Test
    void generate() {
        assertEquals(
                new LinkedList<List<Integer>>() {{
                    add(new LinkedList<Integer>() {{ add(1); }});
                }}, cl.generate(1));
        assertEquals(
                new LinkedList<List<Integer>>() {{
                    add(new LinkedList<Integer>() {{ add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(1); }});
                }}, cl.generate(2));
        assertEquals(
                new LinkedList<List<Integer>>() {{
                    add(new LinkedList<Integer>() {{ add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(2); add(1); }});
                }}, cl.generate(3));
        assertEquals(
                new LinkedList<List<Integer>>() {{
                    add(new LinkedList<Integer>() {{ add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(2); add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(3); add(3); add(1); }});
                }}, cl.generate(4));
        assertEquals(
                new LinkedList<List<Integer>>() {{
                    add(new LinkedList<Integer>() {{ add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(2); add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(3); add(3); add(1); }});
                    add(new LinkedList<Integer>() {{ add(1); add(4); add(6); add(4); add(1); }});
                }}, cl.generate(5));
    }
}