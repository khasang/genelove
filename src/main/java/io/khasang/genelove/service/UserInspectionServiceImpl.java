package io.khasang.genelove.service;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inspectionService")
public class UserInspectionServiceImpl implements UserInspectionService{

//    static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    JmsSender messageSender;

    @Autowired
    UserService userService;

    @Override
    public void sendInspection(User user) {
//        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        userService.setOrderId(BasicUtil.getUniqueId());
//        user.setInspectionStatus(User.InspectionStatus.NEW);
//        orderRepository.putOrder(order);
//        LOG.info("Application : sending order request {}", order);

        messageSender.sendMessage(prepareUser(user));
//        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /*@Override
    public void updateOrder(InventoryResponse response) {

        Order order = orderRepository.getOrder(response.getOrderId());
        if(response.getReturnCode()==200){
            order.setStatus(OrderStatus.CONFIRMED);
        }else if(response.getReturnCode()==300){
            order.setStatus(OrderStatus.FAILED);
        }else{
            order.setStatus(OrderStatus.PENDING);
        }
        orderRepository.putOrder(order);
    }

    public Map<String, Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }*/

    private UserWrapper prepareUser(User user){

        UserWrapper userWrapper = new UserWrapper();

        userWrapper.setId(user.getId());
        userWrapper.setLogin(user.getLogin());
        userWrapper.setFirstName(user.getFirstName());
        userWrapper.setLastName(user.getLastName());
        userWrapper.setEmail(user.getEmail() != null ? user.getEmail() : "");
        //userWrapper.setInspectionStatus(user.getInspectionStatus() != null ? user.getInspectionStatus().toString() : "");
        userWrapper.setAccountStatus(user.getAccountStatus() != null ? user.getAccountStatus().toString() : "");

        return userWrapper;
    }
}
