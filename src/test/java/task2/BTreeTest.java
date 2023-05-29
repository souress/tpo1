package task2;

import klmnkki.task2.BTree;
import klmnkki.task2.BTreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class BTreeTest
{
    private static File file;

    @BeforeAll
    static void setup() throws IOException
    {
        file = File.createTempFile("log", "tmp");

        System.setOut(new PrintStream(file));
    }

    @Test
    void insert() throws IOException
    {
        // Arrange
        BTree btree = new BTree(3);
        String expected = "1";

        // Act
        btree.insert(1);
        btree.traverse();

        // Assert
        String result = Files.readString(file.toPath()).trim();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void traverseWhenRootIsNull() throws IOException
    {
        // Arrange
        BTree btree = new BTree(3);
        String expected = "Root is null";

        // Act
        btree.traverse();

        // Assert
        String result = Files.readString(file.toPath()).trim();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void traverse() throws IOException
    {
        // Arrange
        BTree btree = new BTree(3);
        for (int i = 0; i < 10; i++)
        {
            btree.insert(i);
        }
        var expected = """
                0 1 \r
                2 3 4 \r
                5 \r
                6 7 8 9""";

        // Act
        btree.traverse();

        // Assert
        String result = Files.readString(file.toPath()).trim();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void searchKeyWhenRootIsNull()
    {
        // Arrange
        BTree btree = new BTree(3);

        // Act
        var result = btree.searchKey(1);

        // Assert
        Assertions.assertNull(result);
    }

    @Test
    void searchKey()
    {
        // Arrange
        BTree btree = new BTree(3);
        var result = new ArrayList<BTreeNode>();
        var count = 10;
        for (int i = 0; i < count; i++)
        {
            btree.insert(i);
        }

        // Act
        for (int i = 0; i < count; i++)
        {
            result.add(btree.searchKey(i));
        }

        // Assert
        Assertions.assertEquals(count, result.size());
    }
}
