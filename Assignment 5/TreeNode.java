/**
 * Generic Data element that creates a tree node, used in MorseCodeTree
 * 
 * @author Rose Griffin
 * @param <T> - data type
 */
public class TreeNode<T> {
	
	protected T data;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	
	/**
	 * Create a new tree node with left and right child set as null and data set to dataNode
	 * @param dataNode - data to be stored in the node
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Create deep copy
	 * @param node - node to copy
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		left = new TreeNode<>(node.left);
		right = new TreeNode<>(node.right);
	}
	
	/**
	 * Returns data
	 * @return - data
	 */
	public T getData() {
		return data;
	}
}
