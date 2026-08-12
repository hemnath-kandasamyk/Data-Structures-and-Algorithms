//449. Serialize and Deserialize BST
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        StringBuilder res = new StringBuilder();
        res.append(root.val+" ");
        while(!queue.isEmpty()){

            TreeNode curr = queue.poll();

            if(curr.left!=null){
                queue.offer(curr.left);
                res.append(curr.left.val+" ");
            }
            else{
                res.append("# ");
            }

            if(curr.right != null){

                queue.offer(curr.right);
                res.append(curr.right.val+" ");
            }
            else{
                res.append("# ");
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] nums = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int i =1;

        while(i<nums.length){
            TreeNode curr = queue.poll();
            if(!nums[i].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(nums[i]));
                queue.add(curr.left);
            }
            i++;
            if(i==nums.length){
                break;
            }
            if(!nums[i].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(nums[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
