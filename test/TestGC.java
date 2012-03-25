public class TestGC {
	
	public static void main(String args[]) {
		//System.gc();
		Runtime rt = Runtime.getRuntime();//
		TestGC gc1 = new TestGC();
		TestGC gc2 = new TestGC();
		TestGC gc3 = new TestGC();
		System.out.println("\nAfter created objects...\n");
		System.out.println("Free/Total Memory:" + rt.freeMemory() + "/" + rt.totalMemory());
		
		gc1 = null;
		gc2 = null;
		gc3 = null;
		System.out.println("\nAfter realise objects...\n");
		System.out.println("Free/Total Memory:" + rt.freeMemory() + "/" + rt.totalMemory());
		
		Runtime.getRuntime().gc();//调用System.gc();时，等效调用Runtime.getRuntime().gc();
		System.out.println("\nAfter collected garbage...\n");
		System.out.println("Free/Total Memory:" + rt.freeMemory() + "/" + rt.totalMemory());
	}
}