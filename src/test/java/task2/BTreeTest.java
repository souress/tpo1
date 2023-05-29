package task2;

import klmnkki.task2.BTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class BTreeTest
{


    @Test
    void insertWhenRootIsNull() throws IOException
    {
        // Arrange
        BTree btree = new BTree(3);
        File file = File.createTempFile("log", "tmp");

        // Act
        btree.insert(1);


        // Assert

    }
}
