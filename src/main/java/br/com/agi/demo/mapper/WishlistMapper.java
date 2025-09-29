package br.com.agi.demo.mapper;

import br.com.agi.demo.dto.requests.CriarWishlistRequest;
import br.com.agi.demo.entity.Wishlist;
import org.springframework.stereotype.Component;

@Component
public class WishlistMapper {
    public static Wishlist map(final CriarWishlistRequest request){
        return new Wishlist();
    }
}
