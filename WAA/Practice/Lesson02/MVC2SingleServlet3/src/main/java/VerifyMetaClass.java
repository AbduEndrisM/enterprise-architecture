import mum.edu.domain.Product;

public class VerifyMetaClass {

	public static void main(String[] args) {
		Product product = new Product();

		if (Class.class.isInstance(Class.class))
			System.out.println("Class is instance of Class");
//	 if (Class.class instanceof Class) System.out.println("Class is instance of Class");	 
		System.out.println();

		if (Object.class instanceof Class)
			System.out.println("Object is instance of Class");
//	 if (Class.class.isInstance(Object.class)) System.out.println("Object is instance of Class");
		if (Object.class.isAssignableFrom(Class.class))
			System.out.println("Object is superclass of Class");
		System.out.println();

		if (Product.class instanceof Class)
			System.out.println("Product is instance of Class");
		
		
//	 if (Class.class.isInstance(Product.class)) System.out.println("Product is instance of Class");
		if (Object.class.isAssignableFrom(Product.class))
			System.out.println("Object is superclass of Product");
		System.out.println();

		if (product instanceof Product)
			System.out.println("product is instance of Product");
		
		

	}
}
