package HW5;

import java.util.ArrayList;
import java.util.Scanner;

public class PowerSets {

    public static void findPowerSet(ArrayList<Integer> n, int index, ArrayList<Integer> curr){
        if (index == n.size()){
            return;
        }
        System.out.println(curr.toString());
        for (int i = index+1; i < n.size(); i++){
            curr.add(n.get(i));
            findPowerSet(n, i, curr);
            curr.remove(curr.size()-1);
        }
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = Integer.parseInt(input.nextLine());

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ps = new ArrayList<>();
        for (int j = 1; j <= n; j++){
            arr.add(j);
        }
        findPowerSet(arr, -1, ps);
    }
}


