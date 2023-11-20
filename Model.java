public class Model {
    private final String[] product=new String [100];
    private final int[] price=new int[100];
    private final int[] quantity=new int[100];
    private  int numberOfItems=0;
    private String userNameInventory="Nabeel";
    private String passWordInventory="Akhter";
    private String passWordBilling="Akhter";
    private String userNameBilling="Shaheen";
    public String accessProduct(int i){
        return product[i];
    }
    public void setProduct(String a,int i){
        this.product[i]=a;
    }
    public int accessPrice(int i){
        return price[i];
    }
    public void setPrice(int a,int i){
        this.price[i]=a;
    }
    public void setQuantity(int a,int i) {
        this.quantity[i]=a;
    }
    public int accessQuantity(int i){
        return quantity[i];
    }
    public int accessNumberOfItems(){
        return numberOfItems;
    }
    public void setNumberOfItems(int a){
        this.numberOfItems=a;
    }
    public String giveUserNameInventory(){
        return userNameInventory;
    }
    public String givePassWordInventory(){
        return passWordInventory;
    }
    public void setPassWordInventory(String a){
        this.passWordInventory=a;
    }
    public void setUserNameInventory(String b){
        this.userNameInventory=b;
    }
    public String giveUserNameBilling(){
        return userNameBilling;
    }
    public String givePassWordBilling(){
        return passWordBilling;
    }
    public void setPassWordBilling(String a){
        this.passWordBilling=a;
    }
    public void setUserNameBilling(String b){
        this.userNameBilling=b;
    }
}
