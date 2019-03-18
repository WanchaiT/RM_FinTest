import java.util.*;

class Device {
    int type;
    int price;
    int stock;

    public Device(int type, int price, int stock) {
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void sellOne(){
        stock--;
    }

}

class Computer {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Device> lhm = new LinkedHashMap<Integer, Device>();
        
        int numDevice = scan.nextInt();
        
        for(int i = 0 ;i < numDevice ;i++){
            lhm.put(scan.nextInt(), new Device(scan.nextInt(), scan.nextInt(), scan.nextInt()));
        }

        int numOrder = scan.nextInt();

        for (int i = 0; i < numOrder; i++) {
            Device d1 = lhm.get(scan.nextInt());
            Device d2 = lhm.get(scan.nextInt());
            Device d3 = lhm.get(scan.nextInt());
            
            if (d1.getType() == d2.getType() || 
                d1.getType() == d3.getType() || 
                d2.getType() == d3.getType()) {
                
                System.out.println("invalid order");
            }else if (d1.getStock() == 0 ||
                        d2.getStock() == 0 ||
                        d3.getStock() == 0 ) {

                System.out.println("out of stock");
            }else{
                int sum = d1.getPrice() + d2.getPrice() + d3.getPrice();
                System.out.println(sum);
                d1.sellOne();
                d2.sellOne();
                d3.sellOne();

            }
        }
    }
}