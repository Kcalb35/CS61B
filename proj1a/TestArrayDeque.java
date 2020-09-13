import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

public class TestArrayDeque {

    private ArrayDeque<Integer> createTestExample() {
        // 4 3 2 5 6
        ArrayDeque<Integer> li = new ArrayDeque<>();
        li.addFirst(2);
        li.addFirst(3);
        li.addFirst(4);
        li.addLast(5);
        li.addLast(6);
        return li;
    }

    @Test
    public void TestBasic(){
        ArrayDeque<Integer> li = createTestExample();

        Assert.assertEquals(li.size(),5);
        Assert.assertFalse(li.isEmpty());
    }

    @Test
    public void TestPrint(){
        var li = createTestExample();
        li.printDeque();
    }

    @Test
    public void TestRemove(){
        var li = createTestExample();

        Assert.assertEquals(li.removeFirst().intValue(),4);
        Assert.assertEquals(li.size(),4);
        Assert.assertEquals(li.removeLast().intValue(),6);
        Assert.assertEquals(li.size(),3);

        // 清空list
        for (int i = 0; i < 3; i++) {
            li.removeFirst();
        }

        Assert.assertNull(li.removeLast());
        Assert.assertNull(li.removeFirst());
        Assert.assertEquals(li.size(),0);
    }

    @Test
    public void TestGet(){
        var li = createTestExample();
        Assert.assertEquals(li.get(2).intValue(),2);
        Assert.assertEquals(li.get(4).intValue(),6);

        Assert.assertNull(li.get(10));
        Assert.assertNull(li.get(-5));
    }


    @Test
    public void TestResize() throws NoSuchFieldException, IllegalAccessException {
        ArrayDeque<Integer> li = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            li.addFirst(i);
        }
        Assert.assertEquals(li.size(),16);
        li.printDeque();

        for (int i = 0; i < 16; i++) {
            li.removeLast();
        }
        Assert.assertEquals(li.size(),0);
    }
}
