import java.util.Scanner;
public class Controller  {
    Model example=new Model();
    private String UserName() {
        return example.giveUserName();
    }
    private String PassWord(){
        return example.givePassWord();
    }

    public void resetPassword(){
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter New Password");
        example.setPassWord(Scan.nextLine());
    }

    public void resetUsername(){
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter New Username");
        example.setUserName(Scan.nextLine());
    }

    public  void view(Controller A) throws Exception{


        Scanner Scan= new Scanner(System.in);

        if(A.login(A)) {


                while (true) {
                    System.out.println("WELCOME TO INVENTORY MANAGEMENT SYSTEM !");
                    System.out.println("SELECT YOUR OPTION !");
                    System.out.println("1) ADD ITEM TO YOUR INVENTORY.");
                    System.out.println("2) FIND PRODUCT.");
                    System.out.println("3) SHOW ALL THE PRODUCTS IN INVENTORY!.");
                    System.out.println("4) EDIT INVENTORY");
                    System.out.println("5) CHANGE PASSWORD");
                    System.out.println("6) CHANGE USERNAME");
                    System.out.println("7) LOGOUT.");

                    int option = Scan.nextInt();
                    switch (option) {
                        case 1: {
                            A.addToInventory();
                        }
                        break;

                        case 2: {
                            A.findProduct();
                        }
                        break;

                        case 3: {
                            A.showInventory();
                        }
                        break;

                        case 4: {
                            A.editInventory();

                        }
                        break;

                        case 5: {
                            A.resetPassword();
                        }
                        break;

                        case 6: {
                            A.resetUsername();
                        }
                        break;

                        case 7: {
                            view(A);
                        }
                        break;

                        default: {
                            System.out.println("Wrong Option !");
                        }
                        break;
                    }
                }

        }
        else{
                view(A);

            }


    }
    public  boolean login(Controller example){
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Username !");
        String a=Scan.nextLine();
        System.out.println("Enter Password !");
        String b=Scan.nextLine();

        if(a.equals(example.UserName()) && b.equals(example.PassWord())){
            return true;
        }
        else{
            System.out.println("Wrong Username or Password !");
            return false;
        }
    }
    void addToInventory() {

        for (int i = example.accessNumberOfItems(); i < 100; i++) {
            Scanner Scan = new Scanner(System.in);

            System.out.println("Enter the name of the product.");
            example.setProduct(Scan.nextLine(), i);
            System.out.println("Enter the price of the product.");
            example.setPrice(Scan.nextInt(), i);
            System.out.println("Enter the quantity of the product in the inventory");
            example.setQuantity(Scan.nextInt(), i);

            System.out.println("Do you want to add more? true or false");
            boolean options = Scan.nextBoolean();

            if (options) {
                continue;
            } else {
                example.setNumberOfItems(i);
                break;
            }

        }
    }
    void showInventory()
    {
        for(int i=0;i<=example.accessNumberOfItems();i++)
        {
            System.out.println("Product :"+ example.accessProduct(i) +" || Price :"+ example.accessPrice(i) +" || Quantity : "+ example.accessQuantity(i));
        }
    }
    void findProduct()
    {
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter the name of the product !");
        String toFind=Scan.nextLine();

        boolean flag=false;

        for(int i=0;i<100;i++)
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

    void editInventory(){
        System.out.println("Enter the product you want to edit.");
        Scanner Scan=new Scanner(System.in);
        String a=Scan.nextLine();
        for(int i=0;i<= example.accessNumberOfItems();i++){
            if(example.accessProduct(i).equals(a)){
                System.out.println("1) Edit Product");
                System.out.println("2) Edit Price");
                System.out.println("3) Edit Quantity");
                System.out.println("4) Edit all the above");

                int t=Scan.nextInt();
                switch(t){
                    case 1:{
                        System.out.println("Enter New Product Name ");
                        example.setProduct(Scan.nextLine(),i);
                    }
                    break;

                    case 2:{
                        System.out.println("Enter New Price");
                        example.setPrice(Scan.nextInt(),i);
                    }
                    break;

                    case 3:{
                        System.out.println("Enter New Quantity");
                        example.setQuantity(Scan.nextInt(),i);
                    }
                    break;

                    case 4:{
                        System.out.println("Enter New Product Name ");
                        example.setProduct(Scan.nextLine(),i);
                        System.out.println("Enter New Price");
                        example.setPrice(Scan.nextInt(),i);
                        System.out.println("Enter New Quantity");
                        example.setQuantity(Scan.nextInt(),i);
                    }
                    break;
                }
            }
        }
    }
}
