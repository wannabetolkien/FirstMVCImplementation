import java.util.Scanner;
public class Controller  {
    public Model example=new Model();
    public static final String blue= "\u001B[34m";
    public static final String reset = "\u001B[0m";
    public static final String cyan = "\u001B[36m";
    public static final String red = "\u001B[31m";
    public String UserNameInventory() {
        return example.giveUserNameInventory();
    }
    public String PassWordInventory(){
        return example.givePassWordInventory();
    }

    public String UserNameBilling() {
        return example.giveUserNameBilling();
    }
    public String PassWordBilling(){
        return example.givePassWordBilling();
    }
    public void resetPasswordInventory(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Old Password");
        String oldPassword=Scan.nextLine();

        if(oldPassword.equals(PassWordInventory())) {
            System.out.println("Enter New Password");
            String a=Scan.nextLine();
            System.out.println("Confirm New Password");
            String b=Scan.nextLine();
            if(a.equals(b)) {
                example.setPassWordInventory(b);
            }
            else{
                System.out.println("New Password not Confirmed");
            }
        }
        else{
            System.out.println(red+"Wrong Old Password-Cannot Change Password"+reset);
        }
    }
    public void resetPasswordBilling(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Old Password");
        String oldPassword=Scan.nextLine();

        if(oldPassword.equals(example.givePassWordBilling())) {
            System.out.println("Enter New Password");
            String a=Scan.nextLine();
            System.out.println("Confirm New Password");
            String b=Scan.nextLine();
            if(a.equals(b)) {
                example.setPassWordBilling(b);
            }
            else{
                System.out.println("New Password not Confirmed");
            }
        }
        else{
            System.out.println(red+"Wrong Old Password-Cannot Change Password"+reset);
        }
    }
    public void resetUsernameInventory(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Old Username");
        String oldUsername=Scan.nextLine();

        if(oldUsername.equals(UserNameInventory())){
            System.out.println("Enter New Username");
            String a=Scan.nextLine();
            System.out.println("Confirm New Username");
            String b=Scan.nextLine();
            if(a.equals(b)) {
                example.setUserNameInventory(b);
            }
            else{
                System.out.println("New Username not Confirmed");
            }
        }
    }
    public void resetUsernameBilling(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Old Username");
        String oldUsername=Scan.nextLine();
        if(oldUsername.equals(UserNameBilling())){
            System.out.println("Enter New Username");
            String a=Scan.nextLine();
            System.out.println("Confirm New Username");
            String b=Scan.nextLine();
            if(a.equals(b)) {
                example.setUserNameBilling(b);
            }
            else{
                System.out.println("New Username not Confirmed");
            }
        }
    }
     class addToInventoryThread extends Thread {
        @Override
        public void run(){
            addToInventory();
        }
    }
    class findProductThread extends Thread{
        @Override
        public void run(){
            findProduct();
        }
    }
    class showAllItemsThread extends Thread{
        @Override
        public void run(){
            showInventory();
        }
    }
    class editInventoryThread extends Thread{
        @Override
        public void run(){
            editInventory();
        }
    }
    class changePasswordInventoryThread extends Thread{
        @Override
        public void run(){
            resetPasswordInventory();
        }
    }
    class changeUsernameInventoryThread extends Thread{
        @Override
        public void run(){
            resetUsernameInventory();
        }
    }
    class changeUsernameBillingThread extends Thread{
        @Override
        public void run(){resetUsernameBilling();}
    }
    class changePasswordBillingThread extends Thread{
        @Override
        public void run(){resetUsernameInventory();}
    }

    class createBillThread extends Thread{
        @Override
        public void run(){
            createBill();
        }
    }
    public void netView(Controller A) throws Exception {

        Scanner Scan = new Scanner(System.in);
        System.out.println("========WELCOME TO INVENTORY MANAGEMENT AND BILLING SYSTEM=======");
        System.out.println("1) INVENTORY SYSTEM");
        System.out.println("2) BILLING SYSTEM");

        try{
            while(true){
                int option=Scan.nextInt();
                switch(option){
                    case 1:{
                        viewInventory(A);
                    }
                    break;
                    case 2:{
                        viewBilling(A);
                    }
                    break;
                }
            }
        }
        catch(Exception E){
            System.out.println("Exception caught !");
        }
    }
    public void viewBilling(Controller A) throws Exception{
        Scanner Scan=new Scanner(System.in);

        if(A.loginBilling(A)){

            System.out.print("\033[H\033[2J");
            System.out.flush();

            while(true){
                System.out.println(cyan+"WELCOME TO BILLING SYSTEM"+reset);
                System.out.println(cyan+"SELECT YOUR OPTION"+reset);
                System.out.println(cyan+"1) CREATE BILL"+reset);
                System.out.println(cyan+"2) FIND PRODUCT"+reset);
                System.out.println(cyan+"3) CHANGE PASSWORD"+reset);
                System.out.println(cyan+"4) CHANGE USERNAME"+reset);
                System.out.println(cyan+"5) LOGOUT"+reset);

                int option=Scan.nextInt();
                switch(option){
                    case 1:{
                        createBillThread t1=new createBillThread();
                        t1.run();
                        Thread.sleep(2000);
                        System.out.println(blue+"======================================================================="+reset);
                    }
                    break;

                    case 2:{
                        findProductThread t2=new findProductThread();
                        t2.run();
                        Thread.sleep(2000);
                        System.out.println(blue+"======================================================================="+reset);
                    }
                    break;

                    case 3:{
                        changePasswordBillingThread t3=new changePasswordBillingThread();
                        t3.run();
                        Thread.sleep(2000);
                        System.out.println(blue+"======================================================================="+reset);
                    }
                    break;

                    case 4:{
                        changeUsernameBillingThread t4=new changeUsernameBillingThread();
                        t4.run();
                        Thread.sleep(2000);
                        System.out.println(blue+"======================================================================="+reset);

                    }
                    break;

                    case 5:{
                        netView(A);
                        System.out.println(blue+"======================================================================="+reset);
                    }

                    default:{
                        System.out.println("Wrong Option Selected");
                    }
                }
            }
        }
        else{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            viewBilling(A);
        }
    }
    public  void viewInventory(Controller A) throws Exception{
        Scanner Scan= new Scanner(System.in);

        if(A.loginInventory(A)) {

                System.out.print("\033[H\033[2J");  
                System.out.flush();

                while (true) {
                    System.out.println(cyan+"WELCOME TO INVENTORY MANAGEMENT SYSTEM !"+reset);
                    System.out.println(cyan+"SELECT YOUR OPTION !"+reset);
                    System.out.println(cyan+"1) ADD ITEM TO YOUR INVENTORY."+reset);
                    System.out.println(cyan+"2) FIND PRODUCT."+reset);
                    System.out.println(cyan+"3) SHOW ALL THE PRODUCTS IN INVENTORY!."+reset);
                    System.out.println(cyan+"4) EDIT INVENTORY"+reset);
                    System.out.println(cyan+"5) CHANGE PASSWORD"+reset);
                    System.out.println(cyan+"6) CHANGE USERNAME"+reset);
                    System.out.println(cyan+"7) LOGOUT."+reset);

                    int option = Scan.nextInt();
                    switch (option) {
                        case 1: {
                            addToInventoryThread t1=new addToInventoryThread();
                            t1.run();
                            Thread.sleep(2000);
                            System.out.println(blue+"======================================================================="+reset);
                        }
                        break;

                        case 2: {
                            findProductThread t2=new findProductThread();
                            t2.run();
                            Thread.sleep(2000);
                            System.out.println(blue+"======================================================================="+reset);

                        }
                        break;

                        case 3: {
                            showAllItemsThread t3=new showAllItemsThread();
                            t3.run();
                            Thread.sleep(2000);
                            System.out.println(blue+"======================================================================="+reset);
                        }
                        break;

                        case 4: {
                            editInventoryThread t4=new editInventoryThread();
                            t4.run();
                            Thread.sleep(2000);
                            System.out.println(blue+"======================================================================="+reset);
                        }
                        break;

                        case 5: {
                            changePasswordInventoryThread t5=new changePasswordInventoryThread();
                            t5.run();
                            Thread.sleep(2000);
                            System.out.println(blue+"======================================================================="+reset);
                        }
                        break;

                        case 6: {
                            changeUsernameInventoryThread t6=new changeUsernameInventoryThread();
                            t6.run();
                            Thread.sleep(2000);
                            System.out.println(blue+"======================================================================="+reset);
                        }
                        break;

                        case 7: {
                            netView(A);
                            break;
                        }

                        default: {
                            System.out.println("Wrong Option !");
                        }
                        break;
                    }
                }
        }
        else{
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                viewInventory(A);
            }
    }
    public  boolean loginInventory(Controller example){

        System.out.print("\033[H\033[2J");
        System.out.flush();
       
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Username !");
        String a=Scan.nextLine();
        System.out.println("Enter Password !");
        String b=Scan.nextLine();
        

        if(a.equals(example.UserNameInventory()) && b.equals(example.PassWordInventory())){
            return true;
        }
        else{
            System.out.println("Wrong Username or Password !");
            return false;
        }
    }

    public boolean loginBilling(Controller example){

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Username !");
        String a=Scan.nextLine();
        System.out.println("Enter Password !");
        String b=Scan.nextLine();

        if(a.equals(example.UserNameBilling()) && b.equals(example.PassWordBilling())){
            return true;
        }
        else{
            System.out.println("Wrong Username or Password !");
            return false;
        }
    }
    int findProductQuantity(String toFind){
        for(int i=0;i<example.accessNumberOfItems();i++){
            if(example.accessProduct(i).equals(toFind)){
                return example.accessQuantity(i);
            }
        }
        return 0;
    }
    int findProductPrice(String toFind){
        for(int i=0;i<example.accessNumberOfItems();i++){
            if(example.accessProduct(i).equals(toFind)){
                return example.accessPrice(i);
            }
        }
        return 0;
    }
    public void createBill(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        String Product[]=new String[100];
        int Quantity[]=new int[100];

        boolean endOfBill=true;
        int numberOfItems=0;

        int totalBillAmount=0;

        while(endOfBill){

            Scanner Scan=new Scanner(System.in);

            System.out.print("Product : ");
            Product[numberOfItems]=Scan.nextLine();
            System.out.print("Quantity : ");
            Quantity[numberOfItems]=Scan.nextInt();

            int a=Quantity[numberOfItems];
            int b=findProductPrice(Product[numberOfItems]);

            System.out.println("Amount : "+ a*b);
            totalBillAmount+=Quantity[numberOfItems]*findProductPrice(Product[numberOfItems]);

            System.out.println("Add more Item?");
            endOfBill=Scan.nextBoolean();

            for(int i=0;i<example.accessNumberOfItems();i++){
                if(example.accessProduct(i).equals(Product[numberOfItems])){
                    example.setQuantity((example.accessQuantity(i)-Quantity[numberOfItems]),i);
                }
            }
            numberOfItems++;
        }

        for(int i=0;i<numberOfItems;i++){
            System.out.println("Product : "+Product[i]+"Quantity : "+Quantity[i]+" Amount : "+Quantity[i]*findProductPrice(Product[i]));
        }
        System.out.println("Total Amount : "+totalBillAmount);
    }
    public void addToInventory() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = example.accessNumberOfItems(); i < 100; i++) {
            Scanner Scan = new Scanner(System.in);

            System.out.println("Enter the name of the product.");
            example.setProduct(Scan.nextLine(), i);
            System.out.println("Enter the price of the product.");
            example.setPrice(Scan.nextInt(), i);
            System.out.println("Enter the quantity of the product in the inventory");
            example.setQuantity(Scan.nextInt(), i);
            example.setNumberOfItems(i+1);

            System.out.println("Do you want to add more? true or false");
            boolean options = Scan.nextBoolean();

            if(!options){
                break;
            }
        }
    }
    public void showInventory() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("=============INVENTORY=============");
        for(int i=0;i<example.accessNumberOfItems();i++)
        {
            System.out.println("Product :"+ example.accessProduct(i) +" || Price :"+ example.accessPrice(i) +" || Quantity : "+ example.accessQuantity(i));
        }
    }
    public void findProduct() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter the name of the product !");
        String toFind=Scan.nextLine();

        boolean flag=false;

        for(int i=0;i<example.accessNumberOfItems();i++)
        {
            if(example.accessProduct(i).equals(toFind)){
                System.out.println("Product :"+example.accessProduct(i)+" || Price :"+example.accessPrice(i)+"|| Quantity :"+example.accessQuantity(i));
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Product not in Inventory !");
        }
    }
    public void editInventory(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("Enter the product you want to edit.");
        Scanner Scan=new Scanner(System.in);
        String a=Scan.nextLine();

        for(int i=0;i<example.accessNumberOfItems();i++){
            if(example.accessProduct(i).equals(a)){
                System.out.println("1) Edit Product");
                System.out.println("2) Edit Price");
                System.out.println("3) Edit Quantity");
                System.out.println("4) Edit all the above");

                Scanner A=new Scanner(System.in);
                int t=A.nextInt();
                String k=A.nextLine();
                switch(t){
                    case 1:{
                        System.out.println("Enter New Product Name ");
                        example.setProduct(A.nextLine(),i);
                    }
                    break;

                    case 2:{
                        System.out.println("Enter New Price");
                        example.setPrice(A.nextInt(),i);
                    }
                    break;

                    case 3:{
                        System.out.println("Enter New Quantity");
                        example.setQuantity(A.nextInt(),i);
                    }
                    break;

                    case 4:{
                        System.out.println("Enter New Product Name ");
                        example.setProduct(A.nextLine(),i);
                        System.out.println("Enter New Price");
                        example.setPrice(A.nextInt(),i);
                        System.out.println("Enter New Quantity");
                        example.setQuantity(A.nextInt(),i);
                    }
                    break;
                }
            }
        }
    }
}
