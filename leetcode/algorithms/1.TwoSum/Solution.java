public class Solution {
    public class Node{
        int value;
        int position;
        
        public Node(int value, int position){
            this.value = value;
            this.position = position;
        }
        
        public int getValue(){
            return this.value;
        }
        
        public int getPosition(){
            return this.position;
        }
    }
    
    public class MyComparator implements Comparator<Node> {
        
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getValue() - o2.getValue();
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] rst = new int[2];
         
        int len = numbers.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++){
            nodes[i] = new Node(numbers[i], i + 1);
            hm.put(numbers[i], i + 1);
        }
        MyComparator cmp = new MyComparator();
        Arrays.sort(nodes, cmp);
        
        for (int i = 0; i< len && nodes[i].getValue() <= target / 2; i++){
            Integer j = hm.get(target-nodes[i].getValue());
            if (j != null) {
                if (nodes[i].getPosition() < j){
                    rst[0] = nodes[i].getPosition();
                    rst[1] = j;
                } else {
                    rst[1] = nodes[i].getPosition();
                    rst[0] = j;
                }
                return rst;
            }
        }
        
        return rst;
    }
}