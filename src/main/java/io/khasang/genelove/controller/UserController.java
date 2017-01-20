package io.khasang.genelove.controller;

import io.khasang.genelove.entity.*;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class UserController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @RequestMapping("/qwerty")
    public String test(Model model){
        model.addAttribute("hello", "");
        return "hello";
    }

    /** Logout user from system" */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "logoutPage";
    }

    /** Post message to another user" */
    @RequestMapping(value = "/postMessage", method = RequestMethod.POST)
    @ResponseBody
    public Object messagePost(@RequestBody Message message, HttpServletResponse response){
        try {
            messageService.addMessage(message);
            return message;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding message: " + e.getMessage();
        }
    }

    /** Get message from another user" */
    @RequestMapping(value = "/messagesWith/{otherId}", method = RequestMethod.GET)
    public String messagesWithOther (@PathVariable("otherId") int otherId, Model model) {
        List<Message> list = messageService.getMessagesWith(otherId);
        model.addAttribute("messages", list);
        return "messages";
    }


    /** Delete message from message list" */
    @RequestMapping(value = "/deleteMessage/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMessage(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int messageId = Integer.valueOf(inputId);
            Message message = messageService.getMessageById(messageId);
            if (message != null) {
                messageService.deleteMessage(message);
                return "Message with id:" + messageId + " successfully deleted.";
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Message with id: " + messageId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad message id format: " + inputId;
        }
    }

    /** View message list" */
    @RequestMapping(value = "/allMessage", method = RequestMethod.GET)
    public String messageAll(){
        return "messageAllPage";
    }

    /** Add favorite user to favorite list" */
    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
    public String favoriteAdd(){
        return "favoriteAddPage";
    }

    /** Delete favorite user from favorite list" */
    @RequestMapping(value = "/deleteFavorite", method = RequestMethod.DELETE)
    public String favoriteDelete(){
        return "favoriteDeletePage";
    }

    /** View favorite user list" */
    @RequestMapping(value = "/allFavorite", method = RequestMethod.GET)
    public String favoriteAll(){
        return "favoriteAllPage";
    }

    /** Add relative to user relative tree" */
    @RequestMapping(value = "/addRelativeNode", method = RequestMethod.POST)
    public String relativeNodeAdd(){
        return "relativeNodeAddPage";
    }

    /** Delete relative from user relative tree" */
    @RequestMapping(value = "/deleteRelativeNode", method = RequestMethod.DELETE)
    public String relativeNodeDelete(){
        return "relativeNodeDeletePage";
    }

    /** Update relative in user relative tree" */
    @RequestMapping(value = "/updateRelativeNode", method = RequestMethod.POST)
    public String relativeNodeUpdate(){
        return "relativeNodeUpdatePage";
    }

    /** View user relative tree" */
    @RequestMapping(value = "/allRelativeNode", method = RequestMethod.GET)
    public String relativeNodeAll(){
        return "relativeNodeAllPage";
    }

    /** Add person info about user" */
    @RequestMapping(value = "/addPersInfo", method = RequestMethod.POST)
    public String persInfoAdd(){
        return "persInfoAddPage";
    }

    /** Delete person info about user" */
    @RequestMapping(value = "/deletePersInfo", method = RequestMethod.DELETE)
    public String persInfoDelete(){
        return "persInfoDeletePage";
    }

    /** Update person info about user" */
    @RequestMapping(value = "/updatePersInfo", method = RequestMethod.POST)
    public String persInfoUpdate(){
        return "persInfoUpdatePage";
    }

    /** View person info" */
    @RequestMapping(value = "/viewPersInfo", method = RequestMethod.GET)
    public String persInfoView(){
        return "persInfoViewPage";
    }

    /** Add album to user relative album list" */
    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    public String albumAdd(){
        return "albumAddPage";
    }

    /** Delete album from user relative album list" */
    @RequestMapping(value = "/deleteAlbum", method = RequestMethod.DELETE)
    public String albumDelete(){
        return "albumDeletePage";
    }

    /** Update album in user relative album list" */
    @RequestMapping(value = "/updateAlbum", method = RequestMethod.POST)
    public String albumUpdate(){
        return "albumUpdatePage";
    }

    /** View this album in user relative album list (all photos and videos)" */
    @RequestMapping(value = "/viewAlbum", method = RequestMethod.GET)
    public String albumView(){
        return "albumViewPage";
    }

    /** View user relative album list" */
    @RequestMapping(value = "/allAlbum", method = RequestMethod.GET)
    public String albumAll(){
        return "albumAllPage";
    }

    /** Add file(photo or video) to user relative album" */
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    public String fileAdd(){
        return "fileAddPage";
    }

    /** Delete file(photo or video) from user relative album" */
    @RequestMapping(value = "/deleteFile", method = RequestMethod.DELETE)
    public String fileDelete(){
        return "fileDeletePage";
    }

    /** Update file(photo or video) in user relative album" */
    @RequestMapping(value = "/updateFile", method = RequestMethod.POST)
    public String fileUpdate(){
        return "fileUpdatePage";
    }
}
