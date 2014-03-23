public class CalculadoraJNI {
   static {
	System.loadLibrary("NatLibrary"); // Load native library at runtime calculadora.dll (Windows) or calculadora.so (Unixes)
   }
 
	// Declare a native method sumar restar multiplicar and dividir that receive two longs and returns long
	private native long sumar(long a, long b);
	private native long restar(long a, long b);
	private native long multiplicar(long a, long b);
	private native long dividir(long a, long b);
	
   // Test Driver
   public long suma (long x, long y) {
		return new CalculadoraJNI().sumar(x,y);  // invoke the native method
   }
   
   public long resta (long x, long y) {
		return new CalculadoraJNI().sumar(x,y);  // invoke the native method
  }
   
   public long multi (long x, long y) {
		return new CalculadoraJNI().sumar(x,y);  // invoke the native method
  }
   
   public long div (long x, long y) {
		return new CalculadoraJNI().sumar(x,y);  // invoke the native method
  }
   
}