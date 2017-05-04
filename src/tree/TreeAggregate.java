package tree;

import list.Iterator;

public interface TreeAggregate {
    public abstract Iterator preIterator();
    public abstract Iterator midIterator();
    public abstract Iterator postIterator();
}
