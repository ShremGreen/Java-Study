package Tree;
/*
需求：
创建二叉树并实现:
前序遍历、中序遍历、后序遍历
前序查找、中序查找、后续查找
 */
class BinaryTreeDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1,"AA");
        Node node2 = new Node(2,"BB");
        Node node3 = new Node(3,"CC");
        Node node4 = new Node(4,"DD");
        Node node5 = new Node(5,"EE");

        BinaryTree binaryTree = new BinaryTree(node1);

        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.preOrder();///12354
        binaryTree.infixOrder();//21354
        binaryTree.postOrder();//23541

        Node node = binaryTree.preSearch(5);
        System.out.println(node);
    }
}

class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public Node preSearch(int No) {
        if(root != null) {
            return root.preSearch(No);
        } else {
            return null;
        }
    }

    public Node infixSearch(int No) {
        if(root != null) {
            return root.infixSearch(No);
        } else {
            return null;
        }
    }

    public Node postSearch(int No) {
        if(root != null) {
            return this.root.postSearch(No);
        } else {
            return null;
        }
    }
}

class Node {
    private int No;
    private String name;
    private Node left;
    private Node right;

    public Node(int No, String name) {
        this.No = No;
        this.name = name;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "No=" + No +
                ", name='" + name +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {//检查左侧并递归
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if(this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this);
    }

    //前序查找,先查找左子节点，再查找右子节点
    public Node preSearch(int No) {
        //判断当前节点是不是想找的
        if(this.No == No) {
            return this;
        }
        //递归判断
        Node node = null;//保存当前节点
        if(this.left != null) {//如果当前节点不为空，进行深入递归，并将节点保存
            node = this.left.preSearch(No);
        }
        if(node != null) {
            return node;
        }

        //如果上述过程没找到，那么进入右递归
        if(this.right != null) {
            node = this.right.preSearch(No);
        }
        return node;
    }

    //中序
    public Node infixSearch(int No) {
        Node node = null;
        if(this.left != null) {
            node = this.left.preSearch(No);
        }
        if(node != null) {
            return node;
        }

        if(this.No == No) {
            return this;
        }

        if(this.right != null) {
            node = this.right.preSearch(No);
        }
        return node;
    }

    //后序
    public Node postSearch(int No) {
        Node node = null;
        if(this.left != null) {
            node = this.left.preSearch(No);
        }
        if(node != null) {
            return node;
        }

        if(this.right != null) {
            node = this.right.preSearch(No);
        }
        if(node != null) {
            return node;
        }

        if(this.No == No) {
            return this;
        }
        return node;
    }


}
