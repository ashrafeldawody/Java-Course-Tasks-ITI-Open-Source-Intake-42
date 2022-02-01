public class Crud {
    public static void main(String args[]) {
        System.out.println("All Products");
        for (Product product : Product.getAll()) {
            product.printProduct();
        }
        System.out.println("-------------------------------------");

        System.out.println("Get By ID");
        Product foundProduct = new Product().getByID("1");
        foundProduct.printProduct();
        System.out.println("-------------------------------------");
        
        System.out.println("Insert Record");
        new Product("New Productjj",34,5).insert();
        System.out.println("-------------------------------------");

        System.out.println("Update Record");
        Product toBeUpdated = new Product().getByID("7");
        toBeUpdated.name = "New Updated Namie";
        toBeUpdated.update();

     System.out.println("-------------------------------------");
        System.out.println("Remove Record");
        new Product().getByID("7").delete();
        System.out.println("-------------------------------------");
        
    }
}
