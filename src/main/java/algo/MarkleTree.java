package algo;
/*
Implement a file syncing algorithm for two computers over a low-bandwidth network.
What if we know the files in the two computers are mostly the same?
Idea: Idea is to use Markle tree for a fixed size data blocks. If the data block
changes, we identify only the node that needs to be updated by comparing
CRC32 hash value of the nodes.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.zip.CRC32;

public class MarkleTree {
    private Node root;

    private static class Node {
        String data;
        Node left;
        Node right;

        Node(String value) {
            data = value;
        }
    }

    public static void main(String[] args) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node("A"));
        q.add(new Node("B"));
        q.add(new Node("C"));
        q.add(new Node("D"));
        q.add(new Node("E"));
        MarkleTree mt = new MarkleTree();
        mt.buildTree(q);
        System.out.println("Root Hash of current data: " + mt.root.data);

        Queue<Node> q2 = new LinkedList<>();
        q2.add(new Node("A")); //data at this block changed
        q2.add(new Node("B"));
        q2.add(new Node("C"));
        q2.add(new Node("D"));
        q2.add(new Node("E"));
        MarkleTree mt2 = new MarkleTree();
        mt2.buildTree(q2);
        System.out.println("Root Hash of updated data: " + mt2.root.data);

        if (mt.detectChange(mt.root, mt2.root)) {
            mt.root = mt.mergeChange(mt.root, mt2.root);
        }

        if (mt.detectChange(mt.root, mt2.root)) {
            mt.root = mt.mergeChange(mt.root, mt2.root);
        }
    }

    public void buildTree(Queue<Node> q) {
        while (q.size() > 1) {
            int size = q.size();
            for (int i = 0; i < size; ) {
                Node left = q.poll();
                i++;
                Node right = null;
                if (i < size) {
                    right = q.poll();
                    i++;
                }

                CRC32 crc = new CRC32();
                crc.update((left.data + ((right != null) ? right.data : "")).getBytes());
                Node parent = new Node(crc.getValue() + "");
                parent.left = left;
                parent.right = right;
                q.offer(parent);
            }
        }

        root = q.poll();
    }

    public boolean detectChange(Node refNode, Node newNode) {
        if (refNode == null && newNode == null) return false;
        if (refNode == null || newNode == null) {
            System.out.println("Change detected. Change: data added/deleted");
            return true;
        }
        //Before printing the change, recurse to find the node that has changed
        boolean leftChanged = detectChange(refNode.left, newNode.left);
        boolean rightChanged = detectChange(refNode.right, newNode.right);
        if (refNode.data != newNode.data) {
            System.out.println("Change in the data detected. RootHash of the change: " + newNode.data);
            return true;
        }
        return leftChanged || rightChanged;
    }

    private Node mergeChange(Node refNode, Node newNode) {
        if (refNode == null && newNode == null) return null;
        else if (refNode != null && newNode == null) {
            System.out.println("Change detected. Change: data deleted");
            return null;
        } else if (refNode == null && newNode != null) {
            System.out.println("Change detected. Change: data added");
            return newNode;
        } else if (refNode.data != newNode.data) {
            refNode.data = newNode.data;
        }
        //Before printing the change, recurse to find the node that has changed
        refNode.left = mergeChange(refNode.left, newNode.left);
        refNode.right = mergeChange(refNode.right, newNode.right);

        return refNode;
    }
}
