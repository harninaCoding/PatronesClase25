package ordenadorproblema;

//OrdenadorMalo.java
public class OrdenadorMalo {
 // precios “quemados”
 private static final double BASE = 400.0;
 private static final double DISCO_1TB = 50.0;
 private static final double DISCO_2TB = 80.0;
 private static final double RAM_8GB = 30.0;
 private static final double RAM_16GB = 55.0;
 private static final double GPU_MEDIA = 220.0;
 private static final double GPU_ALTA = 450.0;
 private static final double CPU_MEDIA = 150.0;
 private static final double CPU_ALTA = 280.0;

 // configuración “a base de flags”
 private int discos1TB;     // permite “repetir” componente, pero obliga a más ifs
 private int discos2TB;
 private int modulosRam8;   // nº de módulos de 8 GB
 private int modulosRam16;
 private boolean gpuMedia;
 private boolean gpuAlta;
 private boolean cpuMedia;
 private boolean cpuAlta;

 // setters “de batalla”
 public void addDisco1TB(int n) { this.discos1TB += Math.max(0, n); }
 public void addDisco2TB(int n) { this.discos2TB += Math.max(0, n); }
 public void addRam8(int n)     { this.modulosRam8 += Math.max(0, n); }
 public void addRam16(int n)    { this.modulosRam16 += Math.max(0, n); }
 public void setGpuMedia(boolean v) { this.gpuMedia = v; if (v) this.gpuAlta = false; }
 public void setGpuAlta(boolean v)  { this.gpuAlta = v;  if (v) this.gpuMedia = false; }
 public void setCpuMedia(boolean v) { this.cpuMedia = v; if (v) this.cpuAlta = false; }
 public void setCpuAlta(boolean v)  { this.cpuAlta = v;  if (v) this.cpuMedia = false; }

 public double calculateCost() {
     double total = BASE;

     // CPU (colisiones y reglas metidas a mano)
     if (cpuMedia && cpuAlta) {
         // parche chapucero: si ambas a true, prioriza alta
         total += CPU_ALTA;
     } else if (cpuAlta) {
         total += CPU_ALTA;
     } else if (cpuMedia) {
         total += CPU_MEDIA;
     }

     // GPU
     if (gpuMedia && gpuAlta) {
         total += GPU_ALTA;
     } else if (gpuAlta) {
         total += GPU_ALTA;
     } else if (gpuMedia) {
         total += GPU_MEDIA;
     }

     // Discos y RAM (sumas repetitivas)
     if (discos1TB > 0) total += discos1TB * DISCO_1TB;
     if (discos2TB > 0) total += discos2TB * DISCO_2TB;
     if (modulosRam8 > 0) total += modulosRam8 * RAM_8GB;
     if (modulosRam16 > 0) total += modulosRam16 * RAM_16GB;

     // REGLAS ESPECIALES “hardcodeadas” (anti-OCP):
     // Si hay GPU alta y CPU media, añade “cuello de botella” en forma de fuente más cara
     if (gpuAlta && cpuMedia) total += 40.0;

     // Si hay más de 2 discos, añade coste de bahías/adaptadores
     int totalDiscos = discos1TB + discos2TB;
     if (totalDiscos > 2) total += 15.0;

     return total;
 }

 @Override public String toString() {
     return "OrdenadorMalo{" +
             "discos1TB=" + discos1TB +
             ", discos2TB=" + discos2TB +
             ", ram8=" + modulosRam8 +
             ", ram16=" + modulosRam16 +
             ", gpuMedia=" + gpuMedia +
             ", gpuAlta=" + gpuAlta +
             ", cpuMedia=" + cpuMedia +
             ", cpuAlta=" + cpuAlta +
             '}';
 }
}
