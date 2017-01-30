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
        messageSender.sendMessage(prepareUser(user));
    }

    private UserWrapper prepareUser(User user){
        UserWrapper userWrapper = new UserWrapper();
        userWrapper.setId(user.getId());
        userWrapper.setLogin(user.getLogin());
        userWrapper.setFirstName(user.getFirstName());
        userWrapper.setLastName(user.getLastName());
        userWrapper.setEmail(user.getEmail() != null ? user.getEmail() : "");
        userWrapper.setInspectionStatus(user.getInspectionStatus() != null ? user.getInspectionStatus().toString() : "");
        userWrapper.setAccountStatus(user.getAccountStatus() != null ? user.getAccountStatus().toString() : "");

        return userWrapper;
    }
}
