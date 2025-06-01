/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vadim
 */
import com.example.orderservice.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void shouldSaveAndFindOrder() {
        // Подготовка тестовых данных
        Order testOrder = new Order("TEST123", "Test Product", "Test Description");
        
        // Сохраняем заказ
        orderRepository.save(testOrder);
        
        // Проверяем сохранение
        Order found = orderRepository.findById("TEST123").orElseThrow();
        
        // Проверки
        assertEquals("Test Product", found.getName());
        assertEquals("Test Description", found.getDescription());
    }
}
