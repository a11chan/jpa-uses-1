package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) { //파라미터가 너무 많으면 별도 DTO 생성해서 관리 가능
        Item foundItem = itemRepository.findOne(itemId); //Tx 안에서 엔티티 조회를 해야 영속성 상태로 관리되고 변경 감지 기능이 제대로 작동
        foundItem.setName(name); //setter보단 바로 추적할 수 있는 메서드를 만들자. -> foundItem.change(name, price, stockQuantity)
        foundItem.setPrice(price);
        foundItem.setStockQuantity(stockQuantity);
        //마지막 줄까지 실행 후 commit -> foundItem:Item 객체를 dirty checking 후 DB에 반영
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
