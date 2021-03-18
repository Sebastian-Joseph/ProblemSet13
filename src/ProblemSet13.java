public class ProblemSet13 {
    public boolean groupSum(int start, int[] nums, int target) {
        if (target == 0)
            return true;

        if (start == nums.length)
            return false;

        if (groupSum(start + 1, nums, target - nums[start]))
            return true;

        return groupSum(start + 1, nums, target);
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start >= numbers.length) {
            return false;
        }
        if (start < 0) {
            return false;
        }
        if (numbers[start] == 6) {
            return groupSum6(start + 1, numbers, target - numbers[start]);
        }
        if (groupSum6(start + 1, numbers, target - numbers[start])) {
            return true;
        }
        return groupSum6(start + 1, numbers, target);
    }

    public boolean groupNoAdj(int start, int[] nums, int target)
    {
        if(target == 0)
            return true;

        if(start >= nums.length)
            return false;

        if(groupNoAdj(start + 2, nums, target - nums[start]))
            return true;

        return groupNoAdj(start + 1, nums, target);
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start >= numbers.length) {
            return false;
        }
        if (start < 0) {
            return false;
        }
        if (numbers[start] % 5 == 0) {
            if (start < numbers.length - 1 && numbers[start + 1] == 1) {
                return groupSum5(start + 2, numbers, target - numbers[start]);
            }

            return groupSum5(start + 1, numbers, target - numbers[start]);
        }

        if (groupSum5(start + 1, numbers, target - numbers[start])) {
            return true;
        }

        return groupSum5(start + 1, numbers, target);
    }

    public boolean groupSumClump(int start, int[] nums, int target)
    {
        if(start >= nums.length)
        {
            if(target == 0)
                return true;

            return false;
        }
        int i = start + 1;
        for(;  i < nums.length && nums[start] == nums[i]; i++);

        if(groupSumClump(i, nums, target - ((i - start) * nums[start])))
            return true;

        return groupSumClump(i, nums, target);
    }

    public boolean splitArray(int[] numbers) {

        return sidesAreEqual(numbers, 0, 0);
    }

    public boolean sidesAreEqual(int[] nums, int i, int balance)
    {
        if(i == nums.length)
            return (balance == 0);
        if(sidesAreEqual(nums, i + 1, balance + nums[i]))
            return true;
        return sidesAreEqual(nums, i + 1, balance - nums[i]);
    }

    public boolean splitOdd10(int[] nums)
    {	return sidesAreOdd10(nums, 0, 0, 0);
    }

    public boolean sidesAreOdd10(int[] nums, int i, int group1, int group2)
    {
        if(i == nums.length)
            return (group1 % 2 == 1 && group2 % 10 == 0 || group2 % 2 == 1 && group1 % 10 == 0);
        if(sidesAreOdd10(nums, i + 1, group1 + nums[i], group2))
            return true;
        return sidesAreOdd10(nums, i + 1, group1, group2 + nums[i]);
    }

}