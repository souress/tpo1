package klmnkki.task2;

public class BTree
{
    public BTreeNode root;
    public int t; // at least (t-1) (except root), at most (2*t-1) keys in a node

    public BTree(int t)
    {
        this.root = null;
        this.t = t;
    }

    public void traverse()
    {
        if (this.root != null)
        {
            this.root.traverse();
        }
        System.out.println();
    }

    public BTreeNode searchKey(int key)
    {
        if (this.root == null)
        {
            return null;
        }
        else
        {
            return this.root.search(key);
        }
    }

    public void insert(int key)
    {
        if (this.root == null)
        {
            this.root = new BTreeNode(this.t, true);
            this.root.keys[0] = key;
            this.root.numberOfKeys = 1;
        }
        else
        {
            if (this.root.numberOfKeys == 2 * this.t - 1)
            {
                var s = new BTreeNode(this.t, false);
                s.children[0] = this.root;
                s.splitChild(0, this.root);
                int i = 0;
                if (s.keys[0] < key)
                {
                    i += 1;
                }
                s.children[i].insertNonFull(key);
                this.root = s;
            }
            else
            {
                this.root.insertNonFull(key);
            }
        }
    }
}

class BTreeNode
{
    int[] keys;
    int t;
    BTreeNode[] children;
    int numberOfKeys;
    boolean isLeaf;

    BTreeNode(int t, boolean isLeaf)
    {
        this.t = t;
        this.isLeaf = isLeaf;
        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
        numberOfKeys = 0;
    }

    public void traverse()
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

    BTreeNode search(int key)
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

    public void insertNonFull(int key)
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

    public void splitChild(int i, BTreeNode child)
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

class Main
{
    public static void main(String[] args)
    {
        var tree = new BTree(3);
//        for (int i = 10; i <= 150; i += 10)
//        {
//            tree.insert(i);
//        }
        tree.insert(1);

        tree.traverse();
    }
}