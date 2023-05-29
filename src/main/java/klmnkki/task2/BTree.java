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
        else
        {
            System.out.println("Root is null");
        }
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