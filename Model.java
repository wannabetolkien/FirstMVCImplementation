public class Model {
    private final String[] product=new String [100];
    private final int[] price=new int[100];
    private final int[] quantity=new int[100];
    private  int numberOfItems=0;
    private String userName="Nabeel";
    private String passWord="Akhter";

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
    public String giveUserName(){
        return userName;
    }
    public String givePassWord(){
        return passWord;
    }
    public void setPassWord(String a){
        this.passWord=a;
    }
    public void setUserName(String b){
        this.userName=b;
    }
}
