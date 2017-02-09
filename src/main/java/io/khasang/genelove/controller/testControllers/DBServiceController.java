package io.khasang.genelove.controller.testControllers;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.entity.entity_training.Table;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.service.DBLoader;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  This class designed for maintenance tables in database.
 *
 *  @author Pyankov Alexander
 *  @version DBLoaderController Beta
 *  @since January 31, 2017
 */

@Controller
public class DBServiceController {

    @Autowired
    MyMessage myMessage;
    @Autowired
    SQLExamples sqlExamples;
    @Autowired
    CreateTable createTable;
    @Autowired
    QuestionService questionService;
    @Autowired
    MessageService messageService;
    @Autowired
    MailSender emailService;
    @Autowired
    Environment environment;
	@Autowired
    UserService userService;
    @Autowired
    DBLoader dbLoader;

    private String message = "DB Main is ready";

    private String getCurrentUserName () {
        User currentUser = userService.getUserByLogin(SecurityContextHolder
                .getContext().getAuthentication().getName());
        String name = currentUser.getFirstName();
        String lastName = currentUser.getLastName();
        if (name != null && lastName != null)
            return name + " " + lastName;
        else return "Anonymous User";
    }

     /**
     * ********************************* DB Loader Service **********************************
     * In this section represents code of Mail Sender Service.
     * Begin of this section here.
     ****************************************************************************************
     * /

    /**
     * Main page for DBService
     * @param model represents model
     * @return link to "mailService/DBMain"
     */
    @RequestMapping(value = "/DBService", method = RequestMethod.GET)
    public String DBMain(Model model) {
        String tableTitle = "List of tables in database Genelove";
        String hiddenAction = "viewTablesList";
        model.addAttribute("currentUser", getCurrentUserName());
        List<Table> tables = dbLoader.getTablesList();
        model.addAttribute("tables", tables);
        model.addAttribute("message", message);
        model.addAttribute("tableTitle", tableTitle);
        model.addAttribute("hiddenAction", hiddenAction);
        return "mailService/DBService";
    }

    @RequestMapping(value = "/DBService/view/{table}", method = RequestMethod.GET)
    public String DBMainView(@PathVariable("table") String table, Model model) {
        String tableTitle = "View of table '" + table + "'";
        String hiddenAction = "viewTable";
        model.addAttribute("currentUser", getCurrentUserName());
        //List<Map<String, Object>> tableHeaders = dbLoader.getTableHeaderList(table);
        List<Map<String, Object>> tableData = dbLoader.getTableDataList(table);
        Map<String, Object> map = null;
        Set<String> keys = null;
        if (!tableData.isEmpty()) {
            map = tableData.get(0);
            keys = map.keySet();
        }


/*        boolean firstIteration = true;
        for (Map<String, Object> map: tableData) {
            for (String key: map.keySet()) {
                if (firstIteration)
                    System.out.print (key + "\t");
                else
                    System.out.print (map.get(key) + "\t");
            }
            firstIteration = false;
            System.out.println();
        }*/

        //model.addAttribute("tableHeaders", tableHeaders);
        model.addAttribute("message", message);
        model.addAttribute("tableTitle", tableTitle);
        //model.addAttribute("tableHeaders", tableHeaders);
        model.addAttribute("keys", keys);
        model.addAttribute("tableData", tableData);
        model.addAttribute("hiddenAction", hiddenAction);
        return "mailService/DBService";
    }

    /**
     * DBLoader old version
     * @param model represents model
     * @return link to "mailService/DBActions"
     */
    @RequestMapping(value = "/DBLoader", method = RequestMethod.GET)
    public String DBLoader(Model model) {
        model.addAttribute("currentUser", getCurrentUserName());
        model.addAttribute("message", message);
        return "mailService/DBActions";
    }

    @RequestMapping(value = "/clearTables", method = RequestMethod.POST)
    public String clearTables(Model model)
            throws UnsupportedEncodingException {
        model.addAttribute("currentUser", getCurrentUserName());
        String table = "test";
        model.addAttribute("currentUser", getCurrentUserName());
        String message = dbLoader.clearTable(table);
        model.addAttribute("message", message);
        return "mailService/DBActions";
    }

    @RequestMapping(value = "/loadTables", method = RequestMethod.POST)
    public String loadTables(Model model)
            throws UnsupportedEncodingException, FileNotFoundException {
        model.addAttribute("currentUser", getCurrentUserName());
        String path = "/home/alex/khasang/my/genelove/src/main/resources/files/";
        String file = "test.csv";
        String filename = path + file;
        String response = dbLoader.insertFromFile(dbLoader.loadFromFile(filename));
        if (response.equals("Ok")) {
            message = "Data were loaded from file <strong>" + filename +
                    "</strong> into table <strong>" +
                    file.substring(0, file.length() - 4) + "</strong>";
            model.addAttribute("message", message);
            return "mailService/DBActions";
        }
        else
            model.addAttribute("errorMessage", response);
        return "mailService/sendMailError";
    }

    @RequestMapping(value = "/viewTables", method = RequestMethod.POST)
    public String viewTables(Model model)
            throws UnsupportedEncodingException, FileNotFoundException {
        model.addAttribute("currentUser", getCurrentUserName());
        String message, response = "";
        if (true) {
            message = "Data were loaded from file <strong>" ;
            model.addAttribute("message", message);
            return "mailService/DBActions";
        }
        else
            model.addAttribute("errorMessage", response);
        return "mailService/sendMailError";
    }
    /*************************** End of the Mail Sender Service ****************************/
}
