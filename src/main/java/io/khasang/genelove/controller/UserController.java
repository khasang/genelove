package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/account")
public class UserController {

    /** User registration" */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registrationPage";
    }

    /** Login user to system" */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }

    /** Logout user from system" */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "logoutPage";
    }

    /** Post message to another user" */
    @RequestMapping(value = "/postMessage", method = RequestMethod.POST)
    public String messagePost(){
        return "messagePostPage";
    }

    /** Get message from another user" */
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String messageGet(){
        return "messageGetPage";
    }

    /** Delete message from message list" */
    @RequestMapping(value = "/deleteMessage", method = RequestMethod.DELETE)
    public String messageDelete(){
        return "messageDeletePage";
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
