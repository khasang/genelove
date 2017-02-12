package io.khasang.genelove.controller;

import io.khasang.genelove.entity.*;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.ProfileService;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class UserController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @RequestMapping("/qwerty")
    public String test(Model model){
        model.addAttribute("hello", "");
        return "hello";
    }

    /** View menu page */
    @RequestMapping(value = "/menuPage", method = RequestMethod.GET)
    public String menuPage(){
        return "menuPage";
    }

    /** Logout user from system" */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
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
    public String messagesWithOther (@PathVariable("otherId") long otherId, Model model) {
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
    @RequestMapping(value = "/addFavourite", method = RequestMethod.POST)
    @ResponseBody
    public Object addFavorite(@ModelAttribute("favourite") Favourite favourite,
                              Model model,
                              HttpServletResponse response) {
        try {
            userService.addToFavourites(userService.getCurrentUser(), favourite.getFavouriteKey().getFavourite());
            return "Favourite was added successfully";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding favourite: " + e.getMessage();
        }
    }

    /** Delete favorite user from favorite list" */
    @RequestMapping(value = "/removeFavourite", method = RequestMethod.POST)
    @ResponseBody
    public Object removeFavorite(@ModelAttribute("favourite") Favourite favourite,
                                 Model model,
                                 HttpServletResponse response) {
        try {
            userService.removeFromFavourites(userService.getCurrentUser(), favourite.getFavouriteKey().getFavourite());
            return "Favourite was removed successfully";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error removing favourite: " + e.getMessage();
        }
    }

    /** View favorite user list" */
    @RequestMapping(value = "/myFavourites", method = RequestMethod.GET)
    public String myFavorites(Model model) {
        model.addAttribute("favourite", new Favourite());
        model.addAttribute("favouriteList", userService.getFavouritesForUser(userService.getCurrentUser()));
        return "myFavourites";
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
    @RequestMapping(value = "/myTree", method = RequestMethod.GET)
    public String relativeNodeAll(){
        return "myTree";
    }

    /** Add person info about user" */
    @RequestMapping(value = "/profileNew", method = RequestMethod.GET)
    public String profileNew(){
        return "profileNew";
    }


    @RequestMapping(value = "/addProfile", method = RequestMethod.POST)
    public String addProfile(@ModelAttribute("addProfile") Profile profile,
                               RedirectAttributes redirectAttributes) {
        String message;
        try {
            profileService.addProfile(profile);
            message = "New profile " + profile.getNickname() + " successfully created.";
        } catch (Exception e) {
            message = "Profile creation error: " + e.getMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/account/profiles";
    }

    /**View profiles list**/
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String userProfiles (Model model) {
        User user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Profile> list = profileService.getUserProfiles(user);
        model.addAttribute("currentUser", user);
        model.addAttribute("profiles", list);
        return "profiles";
    }

    /**Find profile**/

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findProfiles (){
        return "profileFind";
    }

    @RequestMapping(value = "/findProfile", method = RequestMethod.GET)
    public String findProfilesWithParam (@RequestParam("ageFrom") int ageFrom, @RequestParam("ageTo") int ageTo,
                                @RequestParam ("gender") String gender, @RequestParam ("marital") String marital,
                                         Model model) {
        List<Profile> list = profileService.getProfiles(ageFrom, ageTo, gender, marital);
        model.addAttribute("profiles", list);
        return "profiles";
    }

    /** View person info" */
    @RequestMapping(value = "/viewPersInfo/{id}", method = RequestMethod.GET)
    public String persInfoView(@PathVariable("id") long id, Model model){
        model.addAttribute("profile", profileService.getProfileById(id));
        return "profile";
    }

    /** Update person info about user" */

    @RequestMapping(value = "/editProfile/{id}", method = RequestMethod.GET)
    public String editProfile(@PathVariable("id") long id, Model model){
        model.addAttribute("profile", profileService.getProfileById(id));
        return "profileEdit";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("profile") Profile profile){
        profileService.updateProfile(profile);
        return "profiles";
    }

    /** Delete person info about user" */
    @RequestMapping(value = "/deletePersInfo", method = RequestMethod.DELETE)
    public String persInfoDelete(){
        return "persInfoDeletePage";
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
