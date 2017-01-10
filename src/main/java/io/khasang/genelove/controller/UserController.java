package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/account")
public class UserController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registrationPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logout(){
        return "logoutPage";
    }

    @RequestMapping(value = "/postMessage", method = RequestMethod.POST)
    public String messagePost(){
        return "messagePostPage";
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String messageGet(){
        return "messageGetPage";
    }

    @RequestMapping(value = "/deleteMessage", method = RequestMethod.DELETE)
    public String messageDelete(){
        return "messageDeletePage";
    }

    @RequestMapping(value = "/allMessage", method = RequestMethod.GET)
    public String messageAll(){
        return "messageAllPage";
    }

    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
    public String favoriteAdd(){
        return "favoriteAddPage";
    }

    @RequestMapping(value = "/deleteFavorite", method = RequestMethod.DELETE)
    public String favoriteDelete(){
        return "favoriteDeletePage";
    }

    @RequestMapping(value = "/allFavorite", method = RequestMethod.GET)
    public String favoriteAll(){
        return "favoriteAllPage";
    }

    @RequestMapping(value = "/addPersonNode", method = RequestMethod.POST)
    public String personNodeAdd(){
        return "personNodeAddPage";
    }

    @RequestMapping(value = "/deletePersonNode", method = RequestMethod.DELETE)
    public String personNodeDelete(){
        return "personNodeDeletePage";
    }

    @RequestMapping(value = "/updatePersonNode", method = RequestMethod.POST)
    public String personNodeUpdate(){
        return "personNodeUpdatePage";
    }

    @RequestMapping(value = "/allPersonNode", method = RequestMethod.GET)
    public String personNodeAll(){
        return "personNodeAllPage";
    }

    @RequestMapping(value = "/addPersInfo", method = RequestMethod.POST)
    public String persInfoAdd(){
        return "persInfoAddPage";
    }

    @RequestMapping(value = "/deletePersInfo", method = RequestMethod.DELETE)
    public String persInfoDelete(){
        return "persInfoDeletePage";
    }

    @RequestMapping(value = "/updatePersInfo", method = RequestMethod.POST)
    public String persInfoUpdate(){
        return "persInfoUpdatePage";
    }

    @RequestMapping(value = "/viewPersInfo", method = RequestMethod.GET)
    public String persInfoView(){
        return "persInfoViewPage";
    }

    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    public String albumAdd(){
        return "albumAddPage";
    }

    @RequestMapping(value = "/deleteAlbum", method = RequestMethod.DELETE)
    public String albumDelete(){
        return "albumDeletePage";
    }

    @RequestMapping(value = "/updateAlbum", method = RequestMethod.POST)
    public String albumUpdate(){
        return "albumUpdatePage";
    }

    @RequestMapping(value = "/viewAlbum", method = RequestMethod.POST)
    public String albumView(){
        return "albumViewPage";
    }

    @RequestMapping(value = "/allAlbum", method = RequestMethod.GET)
    public String albumAll(){
        return "albumAllPage";
    }

    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    public String fileAdd(){
        return "fileAddPage";
    }

    @RequestMapping(value = "/deleteFile", method = RequestMethod.DELETE)
    public String fileDelete(){
        return "fileDeletePage";
    }

    @RequestMapping(value = "/updateFile", method = RequestMethod.POST)
    public String fileUpdate(){
        return "fileUpdatePage";
    }
}
