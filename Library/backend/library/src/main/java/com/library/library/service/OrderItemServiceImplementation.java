package com.library.library.service;

import com.library.library.dto.BookDto;
import com.library.library.dto.BookOrderDto;
import com.library.library.dto.CustomerDto;
import com.library.library.dto.OrderItemDto;
import com.library.library.model.Book;
import com.library.library.model.BookOrder;
import com.library.library.model.Customer;
import com.library.library.model.OrderItem;
import com.library.library.repository.BookOrderRepository;
import com.library.library.repository.BookRepository;
import com.library.library.repository.OrderItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class OrderItemServiceImplementation implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookOrderRepository bookOrderRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Collection<OrderItemDto> getAllItems() {
        Collection<OrderItem> orderItems = orderItemRepository.findAll();
        Collection<OrderItemDto> orderItemsDto = new ArrayList<>();
        OrderItemDto orderItemDto = new OrderItemDto();
        for (OrderItem orderItem : orderItems) {
            orderItemDto = entityToDto(orderItem);
            if (orderItem.getOrder() != null) {
                orderItemDto.setBookOrderDto(bookOrderEntityToDto(orderItem.getOrder()));
            }
            orderItemDto.setBookDto(bookEntityToDto(orderItem.getBook()));
            orderItemsDto.add(orderItemDto);
        }
        return orderItemsDto;
    }

    @Override
    public OrderItemDto getItemById(Integer id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find order item with specified id=" + id));
        OrderItemDto orderItemDto = entityToDto(orderItem);
        orderItemDto.setBookOrderDto(bookOrderEntityToDto(orderItem.getOrder()));
        orderItemDto.setBookDto(bookEntityToDto(orderItem.getBook()));
        return orderItemDto;
    }

    @Override
    public OrderItemDto postItem(OrderItemDto orderItemDto) {
        Book book = bookRepository.findById(orderItemDto.getBookDto().getId()).orElseThrow(() -> new EntityNotFoundException("Could not find book"));
        orderItemDto.setBookDto(bookEntityToDto(book));
        if(orderItemDto.getBookOrderDto() != null) {
            BookOrder order = bookOrderRepository.findById(orderItemDto.getBookOrderDto().getId()).orElseThrow(() -> new EntityNotFoundException("Could not find order"));
            orderItemDto.setBookOrderDto(bookOrderEntityToDto(order));
        }
        OrderItem orderItem = dtoToEntity(orderItemDto);
        OrderItem orderItemSaved = orderItemRepository.save(orderItem);
        OrderItemDto orderItemDtoSaved = entityToDto(orderItemSaved);
        return orderItemDtoSaved;
    }

    @Override
    public void deleteItem(Integer id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public OrderItemDto updateItem(OrderItemDto orderItemDto, Integer id) {
        OrderItem updatedOrderItem = dtoToEntity(orderItemDto);
        OrderItem orderItemFromDB = orderItemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find order item with specified id=" + id));
        orderItemFromDB.setOrder(updatedOrderItem.getOrder());
        orderItemFromDB.setBook(updatedOrderItem.getBook());
        orderItemFromDB.setItemPrice(updatedOrderItem.getItemPrice());
        orderItemFromDB.setItemQuantity(updatedOrderItem.getItemQuantity());
        OrderItem orderItemSaved = orderItemRepository.save(orderItemFromDB);
        OrderItemDto orderItemDto1 = entityToDto(orderItemSaved);
        return orderItemDto1;
    }

    private OrderItemDto entityToDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setBookDto(bookEntityToDto(orderItem.getBook()));
        if(orderItem.getOrder() != null) {
            orderItemDto.setBookOrderDto(bookOrderEntityToDto(orderItem.getOrder()));
        }
        orderItemDto.setItemPrice(orderItem.getItemPrice());
        orderItemDto.setItemQuantity(orderItem.getItemQuantity());
        orderItemDto.setCustomerId(orderItem.getCustomerId());
        return orderItemDto;
    }

    private OrderItem dtoToEntity(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        orderItem.setBook(bookDtoToEntity(orderItemDto.getBookDto()));
        if (orderItemDto.getBookOrderDto()!= null) {
            orderItem.setOrder(bookOrderDtoToEntity(orderItemDto.getBookOrderDto()));
        }
        orderItem.setItemPrice(orderItemDto.getItemPrice());
        orderItem.setItemQuantity(orderItemDto.getItemQuantity());
        orderItem.setCustomerId(orderItemDto.getCustomerId());
        return orderItem;
    }

    private BookDto bookEntityToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookAuthor(book.getBookAuthor());
        bookDto.setBookDescription(book.getBookDescription());
        bookDto.setBookName(book.getBookName());
        bookDto.setBookLanguage(book.getBookLanguage());
        bookDto.setBookPrice(book.getBookPrice());
        bookDto.setBookPublisher(book.getBookPublisher());
        bookDto.setBookYear(book.getBookYear());
        bookDto.setBookQuantity(book.getBookQuantity());
        bookDto.setBookCover(book.getBookCover());
        return bookDto;
    }

    private Book bookDtoToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setBookAuthor(bookDto.getBookAuthor());
        book.setBookDescription(bookDto.getBookDescription());
        book.setBookName(bookDto.getBookName());
        book.setBookLanguage(bookDto.getBookLanguage());
        book.setBookPrice(bookDto.getBookPrice());
        book.setBookPublisher(bookDto.getBookPublisher());
        book.setBookYear(bookDto.getBookYear());
        book.setBookQuantity(bookDto.getBookQuantity());
        book.setBookCover(bookDto.getBookCover());
        return book;
    }

    private BookOrderDto bookOrderEntityToDto(BookOrder bookOrder) {
        BookOrderDto bookOrderDto = new BookOrderDto();
        bookOrderDto.setId(bookOrder.getId());
        bookOrderDto.setOrderDate(bookOrder.getOrderDate());
        bookOrderDto.setOrderPrice(bookOrder.getOrderPrice());
        bookOrderDto.setOrderStatus(bookOrder.getOrderStatus());
        bookOrderDto.setCustomerDto(customerEntityToDto(bookOrder.getCustomer()));
        return bookOrderDto;
    }

    private BookOrder bookOrderDtoToEntity(BookOrderDto bookOrderDto) {
        BookOrder bookOrder = new BookOrder();
        bookOrder.setId(bookOrderDto.getId());
        bookOrder.setOrderDate(bookOrderDto.getOrderDate());
        bookOrder.setOrderStatus(bookOrderDto.getOrderStatus());
        bookOrder.setOrderPrice(bookOrderDto.getOrderPrice());
        bookOrder.setCustomer(customerDtoToEntity(bookOrderDto.getCustomerDto()));
        return bookOrder;
    }

    private CustomerDto customerEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setCustomerSurname(customer.getCustomerSurname());
        customerDto.setCustomerGender(customer.getCustomerGender());
        customerDto.setCustomerPhoneNum(customer.getCustomerPhoneNum());
        customerDto.setCustomerEmail(customer.getCustomerEmail());
        customerDto.setCustomerCountry(customer.getCustomerCountry());
        customerDto.setCustomerCity(customer.getCustomerCity());
        customerDto.setCustomerStreet(customer.getCustomerStreet());
        customerDto.setCustomerPassword(customer.getCustomerPassword());
        return customerDto;
    }

    private Customer customerDtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerSurname(customerDto.getCustomerSurname());
        customer.setCustomerGender(customerDto.getCustomerGender());
        customer.setCustomerPhoneNum(customerDto.getCustomerPhoneNum());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setCustomerCountry(customerDto.getCustomerCountry());
        customer.setCustomerCity(customerDto.getCustomerCity());
        customer.setCustomerStreet(customerDto.getCustomerStreet());
        customer.setCustomerPassword(customerDto.getCustomerPassword());
        return customer;
    }
}
