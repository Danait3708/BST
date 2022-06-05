public class BST {
    BSTNode root;
    int info;
	public  BST(){
		this.root = null;
	}
	public boolean isEmpty(){
		return this.root == null;
	}
	public void insert(int key){
		if(this.root == null){
			this.root = new BSTNode(key);
		}
		else{
			BSTNode node = new BSTNode(key);
			BSTNode temp = root;
			BSTNode parent = null;
			while(temp!=null){
				parent = temp;
				if(temp.key<key) temp = temp.right;
				else temp = temp.left;
			}
			if(parent.key<key) parent.right = node;
			else parent.left = node;
		}
	}
	public BSTNode search(int key){
		BSTNode temp = this.root;
		while(temp!=null){
			if(temp.key==key) return temp;
			else if(temp.key<key) temp = temp.right;
			else temp = temp.left;
		}
		return null;
	}
	public void visit(BSTNode node){
		System.out.println(node.key);
	}
	public void preorder(BSTNode node){
		if(node!=null){
			visit(node);
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void inorder(BSTNode node){
		if(node!=null){
			inorder(node.left);
			visit(node);
			inorder(node.right);
		}
	}
	public void postorder(BSTNode node){
		if(node!=null){
			postorder(node.left);
			postorder(node.right);
			visit(node);
		}
	}
	public void bft(BSTNode node){
		Queue queue = new Queue();
		if(node!=null){
			queue.enqueue(node);
			while(!queue.isEmpty()){
				BSTNode temp = queue.dequeue();
				this.visit(temp);
				if(temp.left!=null) queue.enqueue(temp.left);
				if(temp.right!=null) queue.enqueue(temp.right);
			}
		}
	}
    /*Delete by copy */
    public void deleteByCopy(int key){
        root = delete(root,key);
    }
    BSTNode delete(BSTNode root,int key){
        if(root == null){
            return root;
        }
        else if(key<root.key){
            root.left = delete(root.left,key);
        }
        else if(key>root.key){
            root.right = delete(root.right,key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
             return root.left;
            }
            root.key = minValue(root.right);
            root.right = delete(root.right,root.key);
        }
        return root;
        }
    public int minValue(BSTNode root) {
        int minv = root.key;
        while(root.left !=null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
	public void deleteByMerge(int info) {
		root = delete(root.key);
	}
    private BSTNode delete(int key) {
        return null;
    }
    public BSTNode delete(BSTNode<T> node, int info) {
		if (node == null) {
			return node;
		 } 
		else if (info.compareTo(node.info) <0) {
			node.left = delete(node.left, info);
			return node;
		}
		 else {
			node.right = delete(node.right, info);
			return node;
		}
		 if (node.info==info) {
			if (node.left == null){
				return node.right;
			}
			if (node.right == null){
				return node.left;
			}
			BSTNode temp = node.left;
			while (temp.right != null)
				temp = temp.right;
			    temp.right = node.right;
			    return node.left;
		}
	}
}
