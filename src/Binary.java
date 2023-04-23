public class Binary {

    private Node root;

    private class Node
    {
        int value;
        Node left;
        Node right;

        Node(int value)
        {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Binary()
    {
        root = null;
    }

    public void insert(int value)
    {
        root = insert(root, value);
    }

    private Node insert(Node current, int value)
    {
        if (current == null)
        {
            return new Node(value);
        }
        if (value < current.value)
        {
            current.left = insert(current.left, value);
        }
        else if (value > current.value)
        {
            current.right = insert(current.right, value);
        }
        else
        {
            return current;
        }
        return current;
    }

    public void delete(int value)
    {
        root = delete(root, value);
    }

    private Node delete(Node current, int value)
    {
        if (current == null)
        {
            return null;
        }
        if (value == current.value)
        {
            if (current.left == null && current.right == null)
            {
                return null;
            }
            if (current.left == null)
            {
                return current.right;
            }
            if (current.right == null)
            {
                return current.left;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = delete(current.right, smallestValue);
            return current;
        }
        if (value < current.value)
        {
            current.left = delete(current.left, value);
            return current;
        }
        current.right = delete(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root)
    {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public Node search(int value)
    {
        return search(root, value);
    }

    private Node search(Node current, int value)
    {
        if (current == null || current.value == value)
        {
            return current;
        }
        if (value < current.value)
        {
            return search(current.left, value);
        }
        return search(current.right, value);
    }

    public void preorderTraversal()
    {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node current)
    {
        if (current != null)
        {
            System.out.print(current.value + " ");
            preorderTraversal(current.left);
            preorderTraversal(current.right);
        }
    }
    public void postorderTraversal()
    {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node current)
    {
        if (current != null)
        {
            postorderTraversal(current.left);
            postorderTraversal(current.right);
            System.out.print(current.value + " ");
        }
    }
}
