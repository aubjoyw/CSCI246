package HW4;

import java.util.ArrayList;

public class Primes {

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> composite = new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int i = 3; i <= 1000; i++){
            nums.add(i);
        }

        int counter = 2;
        while (counter <= Math.sqrt(1000)) {
            for (Integer num : nums) {
                if (num % counter == 0) {
                    composite.add(num);
                }
            }
            for (Integer integer : composite) {
                nums.remove(integer);
            }
            composite.clear();
            primes.add(nums.get(0));
            counter = nums.get(0);
            nums.remove(0);
        }
        primes.addAll(nums);

        for (Integer prime : primes) {
            System.out.printf("%d\n", prime);
        }
    }
}
