import org.junit.Assert;
import org.junit.Test;

public class TestLinkedListDeque {
    @Test
    public void BasicTest(){
        LinkedListDeque<Integer> li = createATestExample();
        Assert.assertEquals(li.size(),3);
        Assert.assertFalse(li.isEmpty());

        li.removeFirst();
        li.removeFirst();
        li.removeFirst();

        Assert.assertTrue(li.isEmpty());
    }

    @Test
    public void TestRemove(){
        LinkedListDeque<Integer> li = createATestExample();

        Assert.assertEquals(li.removeFirst().intValue(),2);
        Assert.assertEquals(li.size(),2);
        Assert.assertEquals(li.removeLast().intValue(),3);
        Assert.assertEquals(li.removeLast().intValue(),1);
        Assert.assertEquals(li.size(),0);
    }


    @Test
    public void TestRemoveWhenNothing(){
        LinkedListDeque<Integer> li = new LinkedListDeque<>();
        Assert.assertNull(li.removeLast());
        Assert.assertNull(li.removeFirst());
        Assert.assertEquals(li.size(),0);
    }

    @Test
    public void TestPrint(){
        LinkedListDeque<Integer> li = createATestExample();
        li.printDeque();
    }

    @Test
    public void TestGet(){
        LinkedListDeque<Integer> li = createATestExample();
        Assert.assertEquals(li.get(0).intValue(),2);
        Assert.assertEquals(li.get(1).intValue(),1);
        Assert.assertEquals(li.get(2).intValue(),3);

        Assert.assertNull(li.get(5));
    }

    @Test
    public void TestGetRecursive(){
        LinkedListDeque<Integer> li = createATestExample();
        Assert.assertEquals(li.getRecursive(0).intValue(),2);
        Assert.assertEquals(li.getRecursive(1).intValue(),1);
        Assert.assertEquals(li.getRecursive(2).intValue(),3);

        Assert.assertNull(li.getRecursive(5));
    }



    private LinkedListDeque<Integer> createATestExample() {
        LinkedListDeque<Integer> li = new LinkedListDeque<>();
        li.addFirst(1);
        li.addFirst(2);
        li.addLast(3);
        return li;
    }
}
