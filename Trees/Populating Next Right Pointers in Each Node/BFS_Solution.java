//116. Populating Next Right Pointers in Each Node
class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node previous = null;
            for(int i=0;i<size;i++){
                Node current = queue.poll();

                if(previous==null){
                    previous = current;
                }
                else{
                    previous.next=current;
                    previous = current;
                }

                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
        }
        return root; 
    }
}
