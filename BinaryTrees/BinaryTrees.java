package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;;

class BinaryTrees {
	int idx = -1;

	public class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public Node addData(int[] nodes) {
		idx++;
		if (nodes[idx] == -1) {
			return null;
		}
		Node node = new Node(nodes[idx]);
		node.left = addData(nodes);
		node.right = addData(nodes);
		return node;
	}

	public void inOrder(Node node) { // Left Root Right
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.data + " -> ");
		inOrder(node.right);
	}

	public void preOrder(Node node) { // Root Left Right
		if (node == null) {
			return;
		}
		System.out.print(node.data + " -> ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node) { // Left Right Root
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " -> ");
	}

	public int countNodes(Node root) {
		if (root == null) {
			return 0;
		}
		// int count=0;
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		int total = left + right + 1;
		return total;

	}

	public void levelOrder1(Node node) {
		if (node == null) {
			System.out.println("Empty tree");
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		while (!q.isEmpty()) {
			Node currentNode = q.remove();
			if (currentNode == null) {
				System.out.println("");
				if (q.isEmpty()) {
					break;
				} else
					q.add(null);
			} else {
				System.out.print(currentNode.data + " ");
				if (currentNode.left != null) {
					q.add(currentNode.left);
				}
				if (currentNode.right != null)
					q.add(currentNode.right);

			}

		}
	}

	public void printLeft(Node root) {
		if (root == null)
			return;
		printLeft(root.right);
		System.out.print(root.data + " ");
	}

	public int sumNodes(Node root) {
		if (root == null)
			return 0;
		int leftSum = sumNodes(root.left);
		int rightSum = sumNodes(root.right);
		// System.out.println(leftSum+" "+rightSum);
		return leftSum + rightSum + root.data;
	}

	public int height(Node root) {
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public int diameter(Node root, int[] diam) {
		if (root == null)
			return 0;
		int diam1 = diameter(root.left, diam);
		int diam2 = diameter(root.right, diam);
		diam[0] = Math.max(diam[0], diam1 + diam2);
		// int diam3 = height(root.left)+height(root.right)+1;
		return Math.max(diam1, diam2) + 1;
	}

	public class TreeInfo {
		int ht;
		int diam;

		public TreeInfo(int ht, int diam) {
			this.ht = ht;
			this.diam = diam;
		}
	}

	public TreeInfo diameterLinear(Node root) { // Linear Time complexity
		if (root == null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo leftInfo = diameterLinear(root.left);
		TreeInfo rightInfo = diameterLinear(root.right);
		int myHeight = Math.max(leftInfo.ht, rightInfo.ht) + 1;
		int diam1 = leftInfo.diam;
		int diam2 = rightInfo.diam;
		int diam3 = leftInfo.ht + rightInfo.ht + 1;
		int myDiam = Math.max(diam3, Math.max(diam1, diam2));
		TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
		return myInfo;
	}
	// public boolean isSubtree(Node root, Node subRoot) {
	// if(subRoot==null){
	// return true;
	// }
	// if(root==null){
	// return false;
	// }
	// if(root.val==subRoot.val){
	// if(isValid(root,subRoot))
	// return true;
	// }
	// return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
	// }
	// public boolean isValid(Node root, Node subRoot){
	// if(root==null&&subRoot==null)
	// return true;
	// if(root=null||subRoot==null)
	// return false;
	// if(root.val==subRoot.val){
	// return isValid(root.left,subRoot.left)&&isValid(root.right,subRoot.right);
	// }
	// return false;

	// }
	public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
		ArrayList<Integer> inner = new ArrayList<>();
		ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node removed = q.remove();
			// System.out.println(removed);
			if (removed == null) {

				if (q.isEmpty()) {
					outer.add(inner);
					return outer;
				} else {
					outer.add(inner);
					inner = new ArrayList<>();
					q.add(null);
				}
			} else {

				inner.add(removed.data);
				// System.out.println( inner);
				if (removed.left != null) {
					q.add(removed.left);
				}
				if (removed.right != null)
					q.add(removed.right);
			}
		}
		// System.out.println( inner);
		// outer.add(inner);
		return outer;
	}

	public boolean balanced(Node root) {
		if (heightBalanced(root) == -1)
			return false;
		return true;
	}

	public int heightBalanced(Node root) {
		if (root == null)
			return 0;
		int lh = heightBalanced(root.left);
		if (lh == -1)
			return -1;
		int rh = heightBalanced(root.right);
		if (rh == -1)
			return -1;
		if (Math.abs(rh - lh) > 1)
			return -1;
		return Math.max(lh, rh) + 1;

	}

	public int maxSumPath(Node root, int[] max) {
		if (root == null) {
			return 0;
		}
		int leftSum = Math.max(0, maxSumPath(root.left, max));
		int rightSum = Math.max(0, maxSumPath(root.right, max));
		max[1] = Math.max(max[1], leftSum + rightSum + root.data);
		return root.data + Math.max(leftSum, rightSum);
	}

	public ArrayList<ArrayList<Integer>> zigzagTraversal(Node root) {
		ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
		ArrayList<Integer> inner = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		boolean flag = true;
		while (!q.isEmpty()) {
			Node removed = q.remove();
			if (removed == null) {
				if (q.isEmpty()) {
					if (flag)
						outer.add(inner);
					else {
						ArrayList<Integer> temp = new ArrayList<>();
						for (int i = inner.size() - 1; i >= 0; i--) {
							temp.add(inner.get(i));
						}
						outer.add(temp);
					}
					flag = !flag;
					return outer;
				} else {
					if (flag)
						outer.add(inner);
					else {
						ArrayList<Integer> temp = new ArrayList<>();
						for (int i = inner.size() - 1; i >= 0; i--) {
							temp.add(inner.get(i));
						}
						outer.add(temp);
					}
					flag = !flag;
					inner = new ArrayList<>();
					q.add(null);

				}
			} else {
				inner.add(removed.data);
				if (removed.left != null)
					q.add(removed.left);
				if (removed.right != null)
					q.add(removed.right);

			}
		}
		return outer;
	}

	boolean isLeaf(Node root) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return true;
		return false;
	}

	void leftBoundary(Node root, ArrayList<Integer> res) {
		while (root != null) {
			if (!isLeaf(root))
				res.add(root.data);
			if (root.left == null)
				root = root.right;
			else
				root = root.left;
		}
	}

	void rightBoundary(Node root, ArrayList<Integer> res) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		while (root != null) {
			if (!isLeaf(root))
				tmp.add(root.data);
			if (root.right == null)
				root = root.left;
			else
				root = root.right;
		}
		for (int i = tmp.size() - 1; i >= 0; i--) {
			res.add(tmp.get(i));
		}
	}

	void findLeaf(Node root, ArrayList<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.data);
			return;
		}
		if (root.left != null)
			findLeaf(root.left, res);
		if (root.right != null)
			findLeaf(root.right, res);
	}

	public ArrayList<Integer> traverseBoundary(Node root) {
		// Write your code here.
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		ans.add(root.data);
		leftBoundary(root.left, ans);
		findLeaf(root, ans);
		rightBoundary(root.right, ans);
		return ans;

	}

	public class Tuple {
		Node node;
		int row;
		int col;

		public Tuple(Node node, int row, int col) {
			this.node = node;
			this.row = row;
			this.col = col;
		}
	}

	public List<List<Integer>> verticalTraversal(Node root) {
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(root, 0, 0));
		while (!q.isEmpty()) {
			Tuple tuple = q.remove();
			Node node = tuple.node;
			int row = tuple.row;
			int col = tuple.col;
			if (!map.containsKey(row))
				map.put(row, new TreeMap<>());
			if (!map.get(row).containsKey(col))
				map.get(row).put(col, new PriorityQueue<>());
			map.get(row).get(col).add(node.data);
			if (node.left != null)
				q.add(new Tuple(node.left, row - 1, col + 1));
			if (node.right != null)
				q.add(new Tuple(node.right, row + 1, col + 1));

		}
		List<List<Integer>> ans = new ArrayList<>();
		for (TreeMap<Integer, PriorityQueue<Integer>> level : map.values()) {
			ans.add(new ArrayList<>());
			for (PriorityQueue<Integer> nodes : level.values()) {
				while (!nodes.isEmpty()) {
					ans.get(ans.size() - 1).add(nodes.remove());
				}
			}
		}
		return ans;
	}

	class Pair {
		int hd;
		Node node;

		public Pair(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}

	public List<Integer> topView(Node root) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair pair = q.remove();
			int hd = pair.hd;
			Node node = pair.node;
			if (!map.containsKey(hd))
				map.put(hd, node.data);
			if (node.left != null)
				q.add(new Pair(node.left, hd - 1));
			if (node.right != null)
				q.add(new Pair(node.right, hd + 1));
		}
		List<Integer> ans = new ArrayList<>();
		for (int node : map.values()) {
			ans.add(node);
		}
		// List<Integer> ans= new ArrayList<>();
		return ans;
	}

	// Right View of the Binary Tree
	public List<Integer> rightView(Node root) {
		Queue<Pair> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair pair = q.remove();
			int hd = pair.hd;
			Node node = pair.node;
			if (!map.containsKey(hd))
				map.put(hd, node.data);
			if (node.right != null)
				q.add(new Pair(node.right, hd + 1));
			if (node.left != null)
				q.add(new Pair(node.left, hd + 1));
		}
		List<Integer> ans = new ArrayList<>();
		for (int nodes : map.values())
			ans.add(nodes);
		return ans;
	}

	public void rightViewRec(Node root, List<Integer> list, int depth) {
		if (root == null)
			return;
		if (list.size() == depth)
			list.add(root.data);
		rightViewRec(root.right, list, depth + 1);
		rightViewRec(root.left, list, depth + 1);
	}

	public boolean isSymmetric(Node left, Node right) {
		if (left == null || right == null)
			return left == right;
		if (left.data != right.data)
			return false;
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 4, 7, 14, -1, -1, -1, 8, -1, -1, 19, 9, -1, 15, -1, -1, 10, -1, -1, 3, 5, -1, 11, 16, -1,
				-1, 17, -1, -1, 6, 12, -1, -1, 13, -1, 18, -1, -1 };
		BinaryTrees tree = new BinaryTrees();
		Node root = tree.addData(data);
		int[] arr = new int[2];
		arr[1] = Integer.MIN_VALUE;
		tree.levelOrder1(root);
		tree.diameter(root, arr);
		System.out.println(tree.levelOrder(root));
		System.out.println(tree.zigzagTraversal(root));
		// System.out.println(tree.countNodes(root));
		System.out.println(tree.sumNodes(root));
		// System.out.println(tree.height(root));
		// tree.printLeft(root);
		System.out.println("Diameter: " + tree.diameterLinear(root).diam + " Height: " + tree.diameterLinear(root).ht);
		System.out.println("Diameter= " + arr[0]);
		tree.maxSumPath(root, arr);
		System.out.println(arr[1]);
		System.out.println(tree.isLeaf(root));
		System.out.println(tree.traverseBoundary(root));
		System.out.println(tree.verticalTraversal(root));
		System.out.println(tree.topView(root));
		System.out.println(tree.rightView(root));
		List<Integer> list = new ArrayList<>();
		tree.rightViewRec(root, list, 0);
		System.out.println(list);
		System.out.println(tree.isSymmetric(root.left, root.right));
	}

}