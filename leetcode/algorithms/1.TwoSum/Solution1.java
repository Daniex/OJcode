public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] rst = new int[2];

        int len = numbers.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < len; i++){
            hm.put(numbers[i], i + 1);
        }

        for (int i = 0; i < len; i++){;
            Integer j = hm.get(target - numbers[i]);
            int position = i +1;
            if (j != null && position != j) {
                if (position < j) {
                    rst[0] = position;
                    rst[1] = j;
                } else {
                    rst[1] = position;
                    rst[0] = j;
                }
                return rst;
            }
        }
        return rst;
    }
}