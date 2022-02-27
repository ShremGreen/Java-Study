package Tree;

public class AVL {
    public static void main(String[] args) {
        int[] arr = {4,3,6,5,7,8};
        AVLTree avl = new AVLTree();

        for(int i = 0; i < arr.length; i ++) {
            avl.add(new Node2(arr[i]));
        }

        System.out.println(avl.getRoot().height());//4
        System.out.println(avl.getRoot().getLeft().height());//1
        System.out.println(avl.getRoot().getRight().height());//3
    }
}

class AVLTree {
    private Node2 root;

    public Node2 getRoot() {
        return root;
    }

    //添加节点
    public void add(Node2 node) {
        if(root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //遍历节点
    public void infixOrder() {
        if(root != null) {
            root.infixOrder();
        } else {
            System.out.println("树空，不能遍历");
        }
    }

    //查找节点
    public Node2 search(int value) {
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node2 searchParent(int value) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //查找右子树最小节点
    public int rightMinSearch(Node2 node) {
        Node2 target = node;
        //循环向左查找，直到找到最小值
        while(target.getLeft() != null) {
            target = target.getLeft();
        }
        delNode(target.getValue());//删除该值对应的节点
        return target.getValue();//返回该值
    }

    //删除节点
    public void delNode(int value) {
        if(root == null) {
            return;
        } else {
            //找到要删除的节点
            Node2 target = search(value);
            //1.若没找到节点
            if(target == null) {
                return;
            }
            //2.若找到的节点没有父节点，即根节点
            if(root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            //3.若要删除的节点是叶子节点
            Node2 parent = searchParent(value);
            if(target.getRight() == null && target.getLeft() == null) {
                //继续判断左右
                if(parent.getLeft() != null && parent.getLeft().getValue() == value) {
                    parent.setLeft(null);
                } else if(parent.getRight() != null && parent.getRight().getValue() == value) {
                    parent.setRight(null);
                }
            } else if(target.getRight() != null && target.getLeft() != null) {//4.若要删除的节点有两棵子树
                int minValue= rightMinSearch(target.getRight());//获得右子树下最小值
                target.setValue(minValue);
            } else {//若要删除的节点有一棵子树
                if(target.getLeft() != null) {//此时删除的节点有左子树
                    if(parent != null) {
                        if (parent.getLeft().getValue() == value) {//判断 该节点是父节点的左子节点
                            parent.setLeft(target.getLeft());
                        } else {
                            parent.setRight(target.getLeft());//该节点是父节点的右子节点
                        }
                    } else {
                        root = target.getLeft();
                    }
                } else {//此时删除节点有右子树
                    if(parent != null) {
                        if (parent.getRight().getValue() == value) {//该节点是父节点的右子节点
                            parent.setRight(target.getRight());
                        } else {
                            parent.setLeft(target.getRight());//该节点是父节点的左子节点
                        }
                    } else {
                        root = target.getRight();
                    }
                }
            }
        }
    }
}

class Node2 {
    private int value;
    private Node2 left;
    private Node2 right;

    public Node2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node2 getLeft() {
        return left;
    }

    public void setLeft(Node2 left) {
        this.left = left;
    }

    public Node2 getRight() {
        return right;
    }

    public void setRight(Node2 right) {
        this.right = right;
    }

    //返回左子树的高度
    public int leftHeight() {
        if(left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if(right == null) {
            return 0;
        }
        return right.height();
    }

    //返回当前节点的高度，即以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转
    /*
    过程：
    1.以当前节点值，创建新的节点
    2.把新节点的左子树设置成当前节点的左子树
    3.把新节点的右子树设置成当前节点的右子树的左子树
    4.把当前节点值替换成右子节点的值
    5.把当前节点的右子树设置成右子树的右子树
    6.吧当前节点的左子树设置成新节点

     */
    private void leftRotate() {
        Node2 newNode = new Node2(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    private void rightRotate() {
        Node2 newNode = new Node2(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
    //添加节点
    public void add(Node2 node) {
        if(node == null) {//判断当前节点是否为空
            return;
        }

        if(node.value < this.value) {//判断节点值，以及添加的位置
            //左子节点
            if(this.left == null) {
                this.left = node;//若左子节点位空，则直接添加
            } else {
                this.left.add(node);//否则递归添加
            }
        } else {//右子节点
            if(this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        //添加完一个节点后，判断是否需要进行左旋转
        if(rightHeight() - leftHeight() > 1) {
            if(right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;//提高效率
        }

        if(leftHeight() - rightHeight() > 1) {
            //若当前节点的左子树的右子树的高度大于左子树的高度，需要先左旋再右旋
            if(left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    //中序遍历二叉树
    //即从小到大，顺序输出
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * @param value 节点值
     * @return  返回节点,没找到则返回null
     */
    public Node2 search(int value) {//找到节点位置
        if(value == this.value) {
            return this;
        } else if(value < this.value) {//左子节点
            if(this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else{
            if(this.right == null) {//左子节点
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * @param value 节点值
     * @return  返回父节点
     */
    public Node2 searchParent(int value) {
        if(this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
            return this;//找到则直接返回
        } else {//找不到则进入递归
            if(this.left != null && this.value > value) {//左子树，递归
                return this.left.searchParent(value);
            } else if(this.right != null && this.value < value) {//右子树，递归
                return this.right.searchParent(value);
            } else {//找不到父节点
                return null;
            }
        }
    }
}