package testng_test_book;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/6/8.
 *         迭代器
 */
public interface Iterator {
    boolean hasNext();

    Object next();

    void remove();
}
class IteratorTest implements Iterator{

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }
}