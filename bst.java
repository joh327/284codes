public class bst {
  
  public class SetNode {
    int data;
    SetNode left;
    SetNode right;
    SetNode parent;

    public SetNode(int data, SetNode p) {
      this.data = data;
      this.parent = p;
    }
  }
  
  public class TreeSet{
    SetNode root;

    boolean contains(int data) {
      SetNode node = root;
      while (node != null) {
        if (data == node.data) {
          return true;
        } else if (data < node.data) {
          node = node.left;
        } else {
          node = node.right;
        }
      }
      return false;
    }
    void add(int key) {
      if (root == null) {
        root = new SetNode(key, null);
        return;
      }

        SetNode node = root;
        while (node != null) {
          if (key == node.data) {
            return;
          } else if (key < node.data) {
            if (node.left == null) {
              node.left = new SetNode(key, node);
              return;
            } else {
              node = node.left;
            }
          } else {
            if (node.right == null) {
              node.right = new SetNode(key, node);
              return;
            } else {
              node = node.right;
            }
          }
        }
      }

      SetNode findMax(SetNode node) {
        while (node.right != null) {
          node = node.right;
        }
        return node;
      }

      SetNode findMin(SetNode node) {
        while (node.left != null) {
          node = node.left;
        }
        return node;
      }

      SetNode findNextLarger (SetNode node) {
        if (node.right != null) {
          return findMin(node.right);
        } else if (node.parent ==null) {
          return null;
        } else {
          while (node.parent != null && node.parent.right == node) {
            node = node.parent;
          }
          return node.parent;
        }
      }
      
      SetNode find (int data) {
        SetNode node = root;
        while (node != null) {
          if (data == node.data) {
            return node;
          } else if (data < node.data) {
            node = node.left;
          } else {
            node = node.right;
          }
        }
        return null;
      }

      // case 1 and 2
      void simpleRemove(SetNode node) {
        if (node.left == null && node.right == null) {
          if (node.parent == null) {
            root = null;
          } else if (node.parent.left == node) {
            node.parent.left = null;
          } else {
            node.parent.right = null;
          }
        
       } else if (node.left != null && node.right == null) {
          if (node.parent == null) {
            root = node.left;
          } else if (node.parent.left == node) {
            node.parent.left = node.left;
          } else {
            node.parent.right = node.left;
          }

      } else if (node.left == null && node.right != null) {
          if (node.parent == null) {
              root = node.right;
            } else if (node.parent.left == node) {
              node.parent.left = node.right;
            } else {
              node.parent.right = node.right;
            }
      
      
      
          }
    }
    void advancedRemove(int data) {
      SetNode node = find(data);
      if (node == null) {
        return;
      }

      if (node.right == null) {
        simpleRemove(node);
      } else {
        SetNode nextNode = findMin(node.right);
        simpleRemove(nextNode);
        node.data = nextNode.data;
      }
    }
    void rotate(SetNode node) {
      if (node.parent == null) {
        return;
      }
      SetNode parent = node.parent;
      SetNode grandparent = parent.parent;
      if (grandparent == null) {
        root = node;
      } else if (grandparent.left == parent) {
        grandparent.left = node;
      } else {
        grandparent.right = node;
      }
      node.parent = grandparent;
      if (parent.left == node) {
        parent.left = node.right;
        if (node.right != null) {
          node.right.parent = parent;
        }
        node.right = parent;
      } else {
        parent.right = node.left;
        if (node.left != null) {
          node.left.parent = parent;
        }
        node.left = parent;
      }
      parent.parent = node;
    }


    void rotateMyself(SetNode node) {
      if (node.parent == null) {
        return;
      }

      SetNode parent = node.parent;
      SetNode grandparent = parent.parent;

      if (parent.left == node) {
        parent.left = node.right;
        if (node.right != null) {
          node.right.parent = parent;
        }
        node.right = parent;
      } else if (parent.right == node) {
        parent.right = node.left;
        if (node.left != null) {
          node.left.parent = parent;
        }
        node.left = parent;
      }

      parent.parent = node;
      node.parent = grandparent;
        if (grandparent == null) {
          root = node;
        } else if (grandparent.left == parent) {
          grandparent.left = node;
        } else {
          grandparent.right = node;   
        }
        }
      }
    }
  }
}
