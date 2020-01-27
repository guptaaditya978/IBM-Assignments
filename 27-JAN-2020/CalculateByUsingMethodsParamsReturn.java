class CalculateByUsingMethodsParamsReturn{
    public static void main(String[] args) {
        
        new CalculateByUsingMethodsParamsReturn().input();
        
 
    }
    void input()
    {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Enter two numbers");
        System.out.println("Addition of no's is : " + this.add(scan.nextInt(), scan.nextInt()));
    }
    int add(int firstNum, int secondNum){
        return firstNum + secondNum;
    }
}