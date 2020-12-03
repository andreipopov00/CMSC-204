import java.util.ArrayList;

/**
 * Binary linked tree data structure, inherits from LinkedConverterTreeInterface
 * @author Rose Griffin
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root;
	
	/**
	 * Constructor
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<>(newNode);
		
	}

	@Override
	public MorseCodeTree insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
			if (code.equals(".")) {
				root.left = new TreeNode<>(letter);
			} else if (code.equals("-")) {
				root.right = new TreeNode<>(letter);
			}
		} else if (code.length() > 1) {
			if (code.charAt(0) == '.') {
				addNode(root.left, code.substring(1), letter);
			} else if (code.charAt(0) == '-') {
				addNode(root.right, code.substring(1), letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter = "";
		
		if (code.length() == 1) {
			if (code.equals(".")) {
				letter = root.left.data;
			} else if (code.equals("-")) {
				letter = root.right.data;
			}
		} else if (code.length() > 1) {
			if (code.charAt(0) == '.') {
				letter = fetchNode(root.left, code.substring(1));
			} else if (code.charAt(0) == '-') {
				letter = fetchNode(root.right, code.substring(1));
			}
		}
		return letter;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void buildTree() {
		root = new TreeNode<>("");
		
		//Level 1
		insert(".", "e");
		insert("-", "t");
		
		//Level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//Level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//Level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert("", "");
		insert(".-..", "l");
		insert("", "");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		insert("", "");
		insert("", "");
		
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.data);
			LNRoutputTraversal(root.right, list);
		}
	}
	
}
