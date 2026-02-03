import java.util.EmptyStackException;

public class Stack {
    private int[] nums;
    public Stack(){
        nums = new int[0];
    }
    /**
     * adds element to the top of the stack O(n)
     * @param element
     */
    public void push(int element){
        int[] tempArrary = new int[nums.length + 1];
        for(int i = 0; i < nums.length - 1; i++) {
            tempArrary[i] = nums[i];
        }
        tempArrary[nums.length] = element;
        nums = tempArrary;
    }

    /**
     * removes the top element from the stack O(n)
     * @return the element that was removed
     */
    public int pop(){
        if (nums.length == 0){
            throw new EmptyStackException();
        }
        else{
            int[] tempArrary = new int[nums.length - 1];
            for(int i = 0; i < nums.length - 1; i++){
                tempArrary[i] = nums[i];
            }
            int ret = nums[nums.length - 1];
            nums = tempArrary;
            return ret;
        }
    }

    /**
     * looks at the top of the stack O(1)
     * @return the top of the stack
     */
    public int peek(){
        return nums[nums.length - 1];
    }

    /**
     * returns the amount of elements in the stack O(1)
     * @return size of stack
     */
    public int size(){
        return nums.length;
    }

    /**
     * checks if the stack is empty O(1)
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return nums.length == 0;
    }

}
