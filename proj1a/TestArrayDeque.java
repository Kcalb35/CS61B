import org.junit.Assert;
import org.junit.Test;

public class TestArrayDeque {

    private ArrayDeque<Integer> createTestExample() {
        /*
         4 3 2 5 6
         */
        ArrayDeque<Integer> li = new ArrayDeque<>();
        li.addFirst(2);
        li.addFirst(3);
        li.addFirst(4);
        li.addLast(5);
        li.addLast(6);
        return li;
    }

    @Test
    public void testBasic() {
        ArrayDeque<Integer> li = createTestExample();

        Assert.assertEquals(li.size(), 5);
        Assert.assertFalse(li.isEmpty());
    }

    @Test
    public void testPrint() {
        var li = new ArrayDeque<Integer>();
        for (int i = 0; i < 20; i++) {
            li.addFirst(i);
        }
        li.printDeque();

        for (int i = 0; i < 20; i++) {
            li.removeLast();
        }

        for (int i = 0; i < 30; i++) {
            li.addFirst(i);
        }
        li.printDeque();
    }

    @Test
    public void testRemove() {
        var li = new ArrayDeque<Integer>();

        for (int i = 0; i < 22; i++) {
            li.addFirst(i);
        }
        Assert.assertEquals(li.removeLast().intValue(), 0);
    }

    @Test
    public void testWhenNull() {
        var li = new ArrayDeque<Integer>();

        Assert.assertNull(li.removeLast());
        Assert.assertNull(li.removeFirst());
        Assert.assertEquals(li.size(), 0);
    }

    @Test
    public void testGet() {
        var li = new ArrayDeque<Integer>();
        for (var i = 0; i <= 22; i++) {
            li.addFirst(i);
        }
        li.printDeque();

        Assert.assertEquals(li.get(21).intValue(), 1);

    }


    @Test
    public void testResize()
            throws NoSuchFieldException, IllegalAccessException {
        ArrayDeque<Integer> li = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            li.addFirst(i);
        }
        Assert.assertEquals(li.size(), 16);
        li.printDeque();

        for (int i = 0; i < 16; i++) {
            li.removeLast();
        }
        Assert.assertEquals(li.size(), 0);
    }
}
