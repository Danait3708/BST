public class BSTNode {
    public static final BSTNode info = null;
    int key;
    BSTNode right;
    BSTNode left;
   public BSTNode(int key, BSTNode right, BSTNode left){
       this.key = key;
       this.right = right;
       this.left = left;
   }
   public BSTNode(int key){
       this(key,null,null);
   }
   
}
