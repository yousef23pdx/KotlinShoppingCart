package shoppingCart

/**
 * Returns a map of productId -> MutableMap("name" to String, "price" to Double, "stock" to Int).
 * Your task: Add exactly 5 items with correct details (IDs 1..5).
 * Example:
 *   1 -> { "name"="Laptop", "price"=350.000, "stock"=10 },
 *   2 -> { "name"="Smart TV", "price"=200.000, "stock"=5 },
 *   3 -> { "name"="Headphones", "price"=50.000, "stock"=20 },
 *   4 -> { "name"="Gaming Console", "price"=150.000, "stock"=8 },
 *   5 -> { "name"="Wireless Mouse", "price"=8.500, "stock"=15 },
 */


fun createStoreInventory(): MutableMap<Int, MutableMap<String, Any>> {
    //TODO("Implement createStoreInventory()")

    val storeInventory =
        mutableMapOf<Int, MutableMap<String, Any>>(
            1 to mutableMapOf("name" to "Laptop", "price" to 350.000, "stock" to 10),
            2 to mutableMapOf("name" to "Smart TV", "price" to 200.000, "stock" to 5),
            3 to mutableMapOf("name" to "Headphones", "price" to 50.000, "stock" to 20),
            4 to mutableMapOf("name" to "Gaming Console", "price" to 150.000, "stock" to 8),
            5 to mutableMapOf("name" to "Wireless Mouse", "price" to 8.500, "stock" to 15)
        )
    return storeInventory


}

/**
 * Tries to add [quantity] of [productId] to [cart], if there's enough stock in [storeInventory].
 * - If valid, reduce the stock and increase the cart quantity for this product.
 * - Return true if successful, false otherwise.
 */
fun addToCart(
    storeInventory: MutableMap<Int, MutableMap<String, Any>>,
    cart: MutableMap<Int, Int>,
    productId: Int,
    quantity: Int
): Boolean {
    //TODO("Implement addToCart()")
    if(productId !in storeInventory.keys){
        return false;
    }

    val item = storeInventory[productId]
    var stock: Int = item?.getValue("stock") as Int

    if(cart[productId] != null) {
        cart[productId] = quantity + cart[productId] as Int
        stock -= quantity
        storeInventory[productId]?.set("stock",stock)
        return true
    } else if(quantity <= stock){
        cart[productId] = quantity
        stock -= quantity
        storeInventory[productId]?.set("stock",stock)
        return true
    } else
        return false
}

/**
 * Removes [quantity] of [productId] from [cart], restoring the same amount to [storeInventory].
 * - If cart has enough of this product, remove it and restore stock.
 * - Return true if successful, false otherwise.
 */
fun removeFromCart(
    storeInventory: MutableMap<Int, MutableMap<String, Any>>,
    cart: MutableMap<Int, Int>,
    productId: Int,
    quantity: Int
): Boolean {
    //TODO("Implement removeFromCart()")

    if(productId !in storeInventory.keys){
        return false;
    }

    val item = storeInventory[productId]
    var stock: Int = item?.getValue("stock") as Int

    if(cart[productId] != null) {
        cart[productId] = quantity - cart[productId] as Int
        stock += quantity
        storeInventory[productId]?.set("stock",stock)
        return true
    } else
        return false
}


/**
 * Calculates the total cost of items in [cart].
 * - For each (productId -> quantity), retrieve the price from [storeInventory].
 * - Multiply (price * quantity) and sum for the final total.
 */
fun calculateTotal(
    storeInventory: MutableMap<Int, MutableMap<String, Any>>,
    cart: MutableMap<Int, Int>
): Double {
    //TODO("Implement calculateTotal()")


    

    var stock: Double = storeInventory.getValue("price") as Double
    var sum = 0

    for(i in cart){

        cart


    }
}

/**
 * Returns a list of product IDs whose "name" contains [keyword].
 * - For example, if keyword = "lap", then "Laptop" (ID 1) should match.
 * - Matching is case-insensitive.
 */
fun filterProductsByName(
    storeInventory: MutableMap<Int, MutableMap<String, Any>>,
    keyword: String
): List<Int> {
    TODO("Implement filterProductsByName()")
}

/**
 * Entry point for the project.
 * Run the JUnit tests to see if you've implemented each function correctly.
 */
fun main() {
    println("Welcome to the Kotlin Store project!")
    println("All functions currently throw NotImplementedError.")
    println("Open each function and replace TODO(...) with your implementation.")
}
