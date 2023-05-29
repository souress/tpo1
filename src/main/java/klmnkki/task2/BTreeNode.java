package klmnkki.task2;

public class BTreeNode
{
    protected int[] keys;
    protected int t;
    protected BTreeNode[] children;
    protected int numberOfKeys;
    protected boolean isLeaf;

    public BTreeNode(int t, boolean isLeaf)
    {
        this.t = t;
        this.isLeaf = isLeaf;
        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
        numberOfKeys = 0;
    }

    protected void traverse()
    {
        int i;
        for (i = 0; i < numberOfKeys; i++)
        {
            if (!isLeaf)
            {
                children[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }
        System.out.println();
        if (!isLeaf)
        {
            children[i].traverse();
        }
    }

    protected BTreeNode search(int key)
    {
        int i = 0;
        while (i < numberOfKeys && key > keys[i])
        {
            i++;
        }

        if (keys[i] == key)
        {
            return this;
        }

        if (isLeaf)
        {
            return null;
        }

        return children[i].search(key);
    }

    protected void insertNonFull(int key)
    {
        var i = numberOfKeys - 1;
        if (isLeaf)
        {
            while (i >= 0 && keys[i] > key)
            {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            numberOfKeys++;
        }
        else
        {
            while (i >= 0 && keys[i] > key)
            {
                i--;
            }
            if (children[i + 1].numberOfKeys == 2 * t - 1)
            {
                splitChild(i + 1, children[i + 1]);
                if (keys[i + 1] < key)
                {
                    i++;
                }
            }
            children[i + 1].insertNonFull(key);
        }
    }

    protected void splitChild(int i, BTreeNode child)
    {
        var newChild = new BTreeNode(child.t, child.isLeaf);
        newChild.numberOfKeys = t - 1;
        if (t - 1 >= 0)
        {
            System.arraycopy(child.keys, t, newChild.keys, 0, t - 1);
        }
        if (!child.isLeaf)
        {
            if (t >= 0)
            {
                System.arraycopy(child.children, t, newChild.children, 0, t);
            }
        }
        child.numberOfKeys = t - 1;
        for (int j = numberOfKeys; j > i; j--)
        {
            children[j + 1] = children[j];
        }
        children[i + 1] = newChild;
        for (int j = numberOfKeys - 1; j >= i; j--)
        {
            keys[j + 1] = keys[j];
        }
        keys[i] = child.keys[t - 1];
        numberOfKeys += 1;
    }
}
