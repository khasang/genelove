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

import java.io.File;
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
/*    @Autowired
    QuestionService questionService;*/
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

    private static String path = "/home/alex/khasang/my/genelove/src/main/resources/files/";

    public static String getPath() {
        return path;
    }

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

     /** Main page of DBService */
    @RequestMapping(value = "/DBService", method = RequestMethod.GET)
    public String DBMain(Model model) {
        String message = "DB Service is ready";
        String tableTitle = "List of tables in database Genelove";
        String hiddenAction = "viewTablesList";
        model.addAttribute("currentUser", getCurrentUserName());
        List<Table> tables = dbLoader.getTablesList();
        for (Table table: tables) {
            table.setRecords(dbLoader.getAmountRecordsInTable(table.getName()));
        }
        //int amountOfRecords = dbLoader.getAmountRecordsInTable(table);
        model.addAttribute("tables", tables);
        model.addAttribute("message", message);
        model.addAttribute("tableTitle", tableTitle);
        //model.addAttribute("amountOfRecords", amountOfRecords);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    @RequestMapping(value = "/DBService/view/{table}", method = RequestMethod.GET)
    public String DBMainView(@PathVariable("table") String table, Model model) {
        String message = "View all records from table '" + table + "'";
        String tableTitle = "View of table '" + table + "'";
        String hiddenAction = "viewTable";
        model.addAttribute("currentUser", getCurrentUserName());
        List<Map<String, Object>> tableData = dbLoader.getTableDataList(table);

        Map<String, Object> map;
        Set<String> keys = null;
        if (!tableData.isEmpty()) {
            map = tableData.get(0);
            keys = map.keySet();
        }

        model.addAttribute("message", message);
        model.addAttribute("tableTitle", tableTitle);
        model.addAttribute("keys", keys);
        model.addAttribute("tableData", tableData);
        model.addAttribute("table", table);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /** Clear table 'table_name' (Delete all records from table 'table_name') */
    @RequestMapping(value = "/DBService/clear/{table}", method = RequestMethod.GET)
    public String clearTable(@PathVariable("table") String table, Model model) {
        String message = "Clear table '" + table + "'";
        String hiddenAction = "clearTable";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.clearTable(table);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /** Delete table 'table_name' (Delete table 'table_name' from database) */
    @RequestMapping(value = "/DBService/delete/{table}", method = RequestMethod.GET)
    public String deleteTable(@PathVariable("table") String table, Model model) {
        String message = "Delete table '" + table + "'";
        String hiddenAction = "deleteTable";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.deleteTable(table);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /** Save table 'table_name' in file (Save all records from table 'table_name' in file) */
    @RequestMapping(value = "/DBService/save/{table}", method = RequestMethod.GET)
    public String saveTable(@PathVariable("table") String table, Model model) {
        String hiddenAction = "saveTable";
        model.addAttribute("currentUser", getCurrentUserName());
        String message = dbLoader.saveTable(table);
        model.addAttribute("message", message);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /** Load data in table 'table_name' from file (Load all records in table 'table_name' from file) */
    @RequestMapping(value = "/DBService/load/{table}", method = RequestMethod.GET)
    public String loadTable(@PathVariable("table") String table, Model model) {
        String message = "Load table '" + table + "'";
        String hiddenAction = "loadTable";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.loadTable(table);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);

        if (response.equals("Ok")) {
            message = "Data were loaded from file <strong>" + table + ".csv" +
                    "</strong> into table <strong>" + table + "</strong>";
            model.addAttribute("message", message);
            return "DBService/DBService";
        }
        else
            model.addAttribute("errorMessage", response);
        return "mailService/sendMailError";
    }

    /** Clear/ReLoad data in table 'table_name' from file (Reload all records in table 'table_name' from file) */
    @RequestMapping(value = "/DBService/reload/{table}", method = RequestMethod.GET)
    public String reloadTable(@PathVariable("table") String table, Model model) {
        String message = "Reload table '" + table + "'";
        String hiddenAction = "reloadTable";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.reloadTable(table);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /** Add record in table 'table_name' */
    @RequestMapping(value = "/DBService/addRecord/{table}", method = RequestMethod.GET)
    public String addRecordGET(@PathVariable("table") String table, Model model) {
        String message = "Add table '" + table + "'";
        String hiddenAction = "addRecord";
        model.addAttribute("currentUser", getCurrentUserName());
        //String response = dbLoader.addRecord(table);
        model.addAttribute("message", message);
        //model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /** Add record in table 'table_name' */
    @RequestMapping(value = "/DBService/addRecord/{table}", method = RequestMethod.POST)
    public String addRecordPOST(@PathVariable("table") String table, Model model) {
        String message = "Add table '" + table + "'";
        String hiddenAction = "addRecord";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.addRecord(table);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }


    /** Update record in table 'table_name' */
    @RequestMapping(value = "/DBService/update/{table}/{id}", method = RequestMethod.GET)
    public String updateRecord(@PathVariable("table") String table,
                              @PathVariable("id") int id, Model model) {
        String message = "Update table '" + table + "'";
        String hiddenAction = "updateRecord";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.updateRecord(table, id);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /** Delete record in table 'table_name' */
    @RequestMapping(value = "/DBService/delete/{table}/{id}", method = RequestMethod.GET)
    public String deleteRecord(@PathVariable("table") String table,
                              @PathVariable("id") int id, Model model) {
        String message = "Update table '" + table + "'";
        String hiddenAction = "deleteRecord";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.deleteRecord(table, id);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        model.addAttribute("hiddenAction", hiddenAction);
        return "DBService/DBService";
    }

    /**
     * DBLoader old version
     * @param model represents model
     * @return link to "mailService/DBActions"
     */
    @RequestMapping(value = "/DBLoader", method = RequestMethod.GET)
    public String DBLoader(Model model) {
        String message = "DB Loader is ready";
        model.addAttribute("currentUser", getCurrentUserName());
        model.addAttribute("message", message);
        return "DBService/DBActions";
    }

    @RequestMapping(value = "/clearTables", method = RequestMethod.POST)
    public String clearTables(Model model)
            throws UnsupportedEncodingException {
        String message = "DB Loader is ready";
        model.addAttribute("currentUser", getCurrentUserName());
        String table = "test";
        model.addAttribute("currentUser", getCurrentUserName());
        String response = dbLoader.clearTable(table);
        model.addAttribute("message", message);
        model.addAttribute("response", response);
        return "DBService/DBActions";
    }

    @RequestMapping(value = "/loadTables", method = RequestMethod.POST)
    public String loadTables(Model model)
            throws UnsupportedEncodingException, FileNotFoundException {
        String message = "DB Loader is ready";
        model.addAttribute("currentUser", getCurrentUserName());

        String file = "test.csv";
        String filename = DBServiceController.getPath() + file;

        String response = dbLoader.insertFromFile(dbLoader.loadFromFile(new File(filename)));
        if (response.equals("Ok")) {
            message = "Data were loaded from file <strong>" + filename +
                    "</strong> into table <strong>" +
                    file.substring(0, file.length() - 4) + "</strong>";
            model.addAttribute("message", message);
            return "DBService/DBActions";
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
            return "DBService/DBActions";
        }
        else
            model.addAttribute("errorMessage", response);
        return "mailService/sendMailError";
    }
    /*************************** End of the Mail Sender Service ****************************/
}
