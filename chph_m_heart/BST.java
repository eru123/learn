/**
   Binary Search Tree
*/
public class BST{
  //attributes
  private Object item; //data container
  private BST left,right,parent;
  //
  //constructor
  public BST(Object item) { this.item=item; }
  public BST()            {}
  //setters
  public void setItem(Object item) { this.item=item; }
  public void setLeft(BST left)    { this.left=left; }
  public void setRight(BST right)  { this.right=right; }
  public void setParent(BST parent){ this.parent=parent; }
  //getters
  public Object getItem()          { return item; }
  public BST getLeft()             { return left; }
  public BST getRight()            { return right; }
  public BST getParent()           { return parent; }
  //
  public BST addNode(Object item,BST root){
     //create a new node(tree)
     BST node=new BST(item);
        if(root==null) root=node;
        else{
           Comparable c=(Comparable)root.getItem();
           if(c.compareTo(item)>0){
              root.left=addNode(item,root.getLeft()); //recursive call
           }
           if(c.compareTo(item)<=0){
              root.right=addNode(item,root.getRight());
           }
        }
     return root;//return the updated root
  }
  //
  public BST findNode(Object item,BST root){ //search a node
     BST node=null;
     if(root!=null){
        node=root;
        Comparable c=(Comparable)item;
        if(c.compareTo(node.getItem())==0) return node;
        if(c.compareTo(node.getItem())>0) return findNode(item,node.getRight());
        if(c.compareTo(node.getItem())<0) return findNode(item,node.getLeft());
     }
     return node;
  }
  //
  public BST leftMax(BST root){
     BST node=null;
     if(root!=null){
        if(root.getLeft()!=null){
           node=root.getLeft();
           for(;node.getRight()!=null;node=node.getRight());
           return node;
        }
        else return null;
     }
     return node;
  }
  //
   //
  public BST rightMin(BST root){
     BST node=null;
     if(root!=null){
        if(root.getRight()!=null){
           node=root.getRight();
           for(;node.getLeft()!=null;node=node.getLeft());
           return node;
        }
        else return null;
     }
     return node;
  }
  //
  public boolean deleteNode(Object item,BST root){
      boolean flag=false;
      if(root!=null){
          Comparable c=(Comparable)item;
          if(c.compareTo(root.getItem())==0){
            if(root.getLeft()==null && root.getRight()==null){
                root=null;
                flag=true;
            }
            else if(root.getLeft()==null){
                root=root.getRight();
                flag=true;
            }
            else if(root.getRight()==null){
                root=root.getLeft();
                flag=true;
            }
            else{
                BST node=leftMax(root.getLeft());
                root.setItem(node.getItem());
                node=null;
            }
          }
          else if(c.compareTo(root.getItem())>0){
            flag=deleteNode(item,root.getRight());
          }
          else if(c.compareTo(root.getItem())<0){
            flag=deleteNode(item,root.getLeft());
          }
      }
      return flag;
    
  }
  //
  public void preOrder(BST root){
     if(root!=null){
        System.out.print(root.getItem()); //logical marker
        preOrder(root.getLeft());
        preOrder(root.getRight());
     }
  }
  //
  public void inOrder(BST root){
     if(root!=null){
        inOrder(root.getLeft());
        System.out.print(root.getItem()); //logical marker
        inOrder(root.getRight());
     }
  }
  //
  public void postOrder(BST root){
     if(root!=null){
        postOrder(root.getLeft());   
        postOrder(root.getRight());
        System.out.print(root.getItem()); //logical marker
     }
  }
  //
  public void levelOrder(BST root){
     java.util.Queue<BST> q=new java.util.LinkedList<BST>();
        q.add(root);
        while(!q.isEmpty()){
           BST temp=q.poll();
           System.out.print(temp.getItem());
           if(temp.getLeft()!=null)
              q.add(temp.getLeft());
           if(temp.getRight()!=null)
              q.add(temp.getRight());
        }
  }
  //
  static public void main(String... args){
     BST bst=null;
     bst=new BST().addNode(new String("6"),bst);
     bst=new BST().addNode(new String("4"),bst);
     bst=new BST().addNode(new String("9"),bst);
     bst=new BST().addNode(new String("7"),bst);
     bst=new BST().addNode(new String("2"),bst);
     bst=new BST().addNode(new String("8"),bst);
     bst=new BST().addNode(new String("5"),bst);
     bst=new BST().addNode(new String("0"),bst);
     bst=new BST().addNode(new String("3"),bst);
     bst=new BST().addNode(new String("1"),bst);
     bst=new BST().addNode(new String("6"),bst);
     /*System.out.print("Pre-Order:");
     new BST().preOrder(bst);
     System.out.print("\nIn-Order:");      
     new BST().inOrder(bst);
     System.out.print("\nPost-Order:");      
     new BST().postOrder(bst);
     System.out.print("\nLevel-Order:");      
     new BST().levelOrder(bst);*/
     System.out.print("Search for node: 4");
        BST mynode=new BST().findNode(new String("4"),bst);
        if(mynode!=null){
           
           if(mynode.getLeft()!=null)
              System.out.println("\nLeft Node:"+mynode.getLeft().getItem().toString());
           else
              System.out.println("\nLeft Node:->");
           if(mynode.getRight()!=null)
              System.out.println("Right Node:"+mynode.getRight().getItem().toString());
           else
              System.out.println("\nRight Node:->");
           BST lm=new BST().leftMax(mynode);
           if(lm!=null)
              System.out.println("Left Max: "+lm.getItem());
           else
              System.out.println("Left Max:->");
           //
           BST rm=new BST().rightMin(mynode);
           if(rm!=null)
              System.out.println("Right Min: "+rm.getItem());
           else
              System.out.println("Right Min:->");

        
        }
  }
}//end of class