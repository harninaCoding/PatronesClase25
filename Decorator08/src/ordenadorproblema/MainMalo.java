package ordenadorproblema;

//MainMalo.java
public class MainMalo {
 public static void main(String[] args) {
     OrdenadorMalo pc = new OrdenadorMalo();
     pc.setCpuAlta(true);
     pc.setGpuMedia(true);
     pc.addDisco1TB(2);
     pc.addRam16(2);

     System.out.println(pc);
     System.out.println("Coste total: " + pc.calculateCost() + " €");
 }
}
