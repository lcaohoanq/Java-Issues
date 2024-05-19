package sample.product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import sample.book.BookDTO;

public class CartBookDTO implements Serializable {
    private Map<String, BookDTO> cart;

    public CartBookDTO() {
        cart = new HashMap<>();
    }

    public void add(BookDTO book) {
        if (cart.containsKey(book.getSKU())) {
            // Update quantity or any other logic if necessary
        } else {
            cart.put(book.getSKU(), book);
        }
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }
}
