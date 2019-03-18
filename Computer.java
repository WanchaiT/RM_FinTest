import java.util.*;


class Device{
    private int id;
    private int type;
    private int price;
    private int stock;

    public Device(int id, int type, int price, int stock) {
        this.id = id;
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

    public int getStock(){
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

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
    public void printInfo(){
        System.out.println("ID : " + id);
        System.out.println("Type : " + type);
        System.out.println("Price : " + price);
        System.out.println("Stock : " + stock);
    }
}

class Computer {

    static Scanner scan = new Scanner(System.in);
    static Map<Integer, Device> lhm = new LinkedHashMap<Integer, Device>();
    // static Map<Integer, Device> lhm = new TreeMap<Integer, Device>(); sort 
    public static void main(String[] args) {
        
       
        
        int numDevice = scan.nextInt();
        
        for(int i = 0 ;i < numDevice ;i++){
            int id = scan.nextInt();
            lhm.put(id, createDevive( id));
        }

        System.out.println(lhm.keySet());

        print();

        int numOrder = scan.nextInt();

        for (int i = 0; i < numOrder; i++) {
            
            Device[] d = getDevice(scan.nextInt(), scan.nextInt(), scan.nextInt());
           
           
            
            if (!checkInvalid(d[0], d[1], d[2])) {
                System.out.println("invalid order");
            }else if (checkStock(d[0], d[1], d[2])) {
                System.out.println("out of stock");
            }else{
                int sum = getSum(d[0], d[1], d[2]);
                System.out.println(sum);

            }
        }
    }

    public static boolean checkInvalid(Device d1, Device d2, Device d3){
        Set<Integer> set = new HashSet<Integer>();
        set.add(d1.getType());
        set.add(d2.getType());
        set.add(d3.getType());
        return set.size() == 3;

    }

    public static Device createDevive(int id) {
        return new Device(id, scan.nextInt(), scan.nextInt(), scan.nextInt());
    }

    public static boolean checkStock(Device d1, Device d2, Device d3) {
        return  d1.getStock() == 0 ||
                d2.getStock() == 0 ||
                d3.getStock() == 0 ; 
    }

    public static Device[] getDevice(int d1, int d2, int d3){
        Device[] d = {lhm.get(d1), lhm.get(d2), lhm.get(d3)};

        return d;
    }

    public static int getSum(Device d1, Device d2, Device d3){
        int sum = d1.getPrice() + d2.getPrice() + d3.getPrice();
        sellOne(d1, d2 ,d3);
        return sum;
    }

    public static void sellOne(Device d1, Device d2, Device d3){
        d1.sellOne();
        d2.sellOne();
        d3.sellOne();
    }

    public static void print(){
        for (Device d : lhm.values()) {
            d.printInfo();
            System.out.println();
        }
    }
}