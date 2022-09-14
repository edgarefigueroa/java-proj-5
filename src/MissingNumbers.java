package src;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumbers {

    public static void findMissing(int nums[], int maxNum)
    {
        int i;
        int temp[] = new int[maxNum + 1];
        for (i = 0; i <= maxNum; i++) {
            temp[i] = 0;
        }

        for (i = 0; i < maxNum; i++) {
            temp[nums[i] - 1] = 1;
        }

        int ans = 0;
        for (i = 0; i <= maxNum; i++) {
            if (temp[i] == 0)
                ans = i + 1;
        }
        System.out.println(ans);

    }
    public static int missingNumber(int[] nums, int maxNum){
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };

        System.out.print("Missing:");
        findMissing(missingMax, missingMax.length);
        System.out.print("Missing:");
        findMissing(missingNone, missingNone.length); // 11
        System.out.print("Missing:");
        findMissing(missingSeven, missingSeven.length);

        System.out.println("Missing Max:" + missingNumber(missingMax, 10));
        System.out.println("Missing None:" + missingNumber(missingNone, 10));
        System.out.println("Missing Seven:" + missingNumber(missingSeven, 10));



    }

}
