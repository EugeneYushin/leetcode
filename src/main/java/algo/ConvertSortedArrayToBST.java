package algo;

import java.util.Arrays;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);
        else if (nums.length == 2) return new TreeNode(nums[0], null, new TreeNode(nums[1]));
        else if (nums.length == 3) return new TreeNode(nums[1], new TreeNode(nums[0]), new TreeNode(nums[2]));
        else {
            TreeNode root = new TreeNode(nums[nums.length / 2]);
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
            return root;
        }
    }
}
