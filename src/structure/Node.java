package src.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zjn
 * @date 2022/6/18
 * 多叉树节点
 */
public class Node {
    public int val;
    public List<Node> children = new LinkedList<>();

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
