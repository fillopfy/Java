import java.util.*;

public class Print {
    public static void main(String[] args) {
        // print(5);
        // printReverse(5);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(0);
        list.add(3);
        list.add(2);
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(4);
        stack.add(0);
        stack.add(3);
        stack.add(2);
        sort(list);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static void print(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        print(n - 1);
        System.out.println(n);
    }

    public static void printReverse(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printReverse(n - 1);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public static int[] sortA(int[] arr, int index) {
        if (index <= 0) {
            return arr;
        }
        int el = arr[index];
        sortA(arr, index - 1);
        int[] newArr = new int[index + 1];
        for (int i = 0; i < index; i++) {
            if (arr[i] <= el) {
                newArr[i] = arr[i];
                continue;
            }
        }

        return newArr;
    }

    public static void sort(List<Integer> list) {
        if (list.size() == 1) {
            return;
        }
        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list);
        insert(list, temp);
    }

    public static void insert(List<Integer> list, int temp) {
        if (list.size() == 0 || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }
        int val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        insert(list, temp);
        list.add(val);
        return;
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        int temp = stack.pop();
        sortStack(stack);
        insertStack(stack, temp);
    }

    public static void insertStack(Stack<Integer> stack, int temp) {
        if (stack.size() == 0 || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insertStack(stack, temp);
        stack.push(val);
        return;
    }

    public static Stack<Integer> deleteMiddleOfStack(Stack<Integer> stack, int k) {
        if (stack.isEmpty() || k > stack.size()) {
            return stack;
        }

        if (k == 1) {
            stack.pop();
            return stack;
        }

        int val = stack.pop();
        deleteMiddleOfStack(stack, k - 1);

        stack.push(val);
        return stack;
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int val=stack.pop();
        reverseStack(stack);
        stack.push(val);
    }

}