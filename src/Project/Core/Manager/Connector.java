package Project.Core.Manager;

import Project.Core.Models.Client;
import Project.Core.Models.Comment;
import Project.Core.Models.Country;
import Project.Core.Models.Deal;
import jdk.jshell.spi.ExecutionControlProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class Connector {


    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(""+
                    "jdbc:postgresql://localhost:5432/JavaEEFinalProject","postgres", "postgres");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Deal> getAllDeals(){

        ArrayList<Deal> allDeals = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT d.id, d.header, d.short_description, d.description, d.price, d.picture1, d.picture2, d.picture3, "+
                    "client.id AS client_id, client.name AS client_name, client.company AS client_company,  " +
                    "country.id AS country_id, country.name AS country "+
                    "FROM deals d "+
                    "INNER JOIN clients client ON client.id = d.client_id "+
                    "INNER JOIN countries country ON client.country_id = country.id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Deal newDeal = new Deal();
                newDeal.setId(resultSet.getLong("id"));
                newDeal.setMain(resultSet.getString("header"));
                newDeal.setShortDescription(resultSet.getString("short_description"));
                newDeal.setDescription(resultSet.getString("description"));
                newDeal.setPrice(resultSet.getInt("price"));
                newDeal.setPicture1(resultSet.getString("picture1"));
                newDeal.setPicture2(resultSet.getString("picture2"));
                newDeal.setPicture3(resultSet.getString("picture3"));

                Client newClient = new Client();
                newClient.setId(resultSet.getLong("client_id"));
                newClient.setCompany(resultSet.getString("client_company"));
                newClient.setName(resultSet.getString("client_name"));

                Country newCountry = new Country();
                newCountry.setId(resultSet.getLong("country_id"));
                newCountry.setName(resultSet.getString("country"));

                newClient.setCountry(newCountry);

                newDeal.setClient(newClient);

                allDeals.add(newDeal);
            }
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return allDeals;
    }

    public static Deal getDeal(Long id){

        Deal newDeal = new Deal();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT d.id, d.header, d.short_description, d.description, d.price, d.picture1, d.picture2, d.picture3, "+
                    "client.id AS client_id, client.name AS client_name, client.company AS client_company,  " +
                    "country.id AS country_id, country.name AS country "+
                    "FROM deals d "+
                    "INNER JOIN clients client ON client.id = d.client_id "+
                    "INNER JOIN countries country ON client.country_id = country.id WHERE d.id = ?");

            statement.setLong(1,id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                newDeal.setId(resultSet.getLong("id"));
                newDeal.setMain(resultSet.getString("header"));
                newDeal.setShortDescription(resultSet.getString("short_description"));
                newDeal.setDescription(resultSet.getString("description"));
                newDeal.setPrice(resultSet.getInt("price"));
                newDeal.setPicture1(resultSet.getString("picture1"));
                newDeal.setPicture2(resultSet.getString("picture2"));
                newDeal.setPicture3(resultSet.getString("picture3"));

                Client newClient = new Client();
                newClient.setId(resultSet.getLong("client_id"));
                newClient.setCompany(resultSet.getString("client_company"));
                newClient.setName(resultSet.getString("client_name"));

                Country newCountry = new Country();
                newCountry.setId(resultSet.getLong("country_id"));
                newCountry.setName(resultSet.getString("country"));

                newClient.setCountry(newCountry);

                newDeal.setClient(newClient);

            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return newDeal;
    }



    public static Client login(String login, String password){

        Client theClient = null;

        try{

            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT client.id, client.name, client.company, client.login, client.password, " +
                    "country.name AS country, country.id AS countryid "+
                    "FROM clients client " +
                    "INNER JOIN countries country ON client.country_id = country.id "+
                    "WHERE client.login = ? AND client.password = ?");
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                theClient = new Client();

                theClient.setId(resultSet.getLong("id"));
                theClient.setName(resultSet.getString("name"));

                Country theCountry = new Country();

                theCountry.setId(resultSet.getLong("countryid"));
                theCountry.setName(resultSet.getString("country"));

                theClient.setCountry(theCountry);

                theClient.setCompany(resultSet.getString("company"));
                theClient.setLogin(resultSet.getString("login"));
                theClient.setPassword(resultSet.getString("password"));

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return theClient;
    }

    public static ArrayList<Deal> getClientsDeals(Long id){

        ArrayList<Deal> deals = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT d.id, d.header, d.short_description, d.description, d.price, d.picture1, d.picture2, d.picture3, "+
                    "client.id AS client_id, client.name AS client_name, client.company AS client_company,  " +
                    "country.id AS country_id, country.name AS country "+
                    "FROM deals d "+
                    "INNER JOIN clients client ON client.id = d.client_id "+
                    "INNER JOIN countries country ON client.country_id = country.id WHERE client.id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Deal newDeal = new Deal();
                newDeal.setId(resultSet.getLong("id"));
                newDeal.setMain(resultSet.getString("header"));
                newDeal.setShortDescription(resultSet.getString("short_description"));
                newDeal.setDescription(resultSet.getString("description"));
                newDeal.setPrice(resultSet.getInt("price"));
                newDeal.setPicture1(resultSet.getString("picture1"));
                newDeal.setPicture2(resultSet.getString("picture2"));
                newDeal.setPicture3(resultSet.getString("picture3"));

                Client newClient = new Client();
                newClient.setId(resultSet.getLong("client_id"));
                newClient.setCompany(resultSet.getString("client_company"));
                newClient.setName(resultSet.getString("client_name"));

                Country newCountry = new Country();
                newCountry.setId(resultSet.getLong("country_id"));
                newCountry.setName(resultSet.getString("country"));

                newClient.setCountry(newCountry);

                newDeal.setClient(newClient);

                deals.add(newDeal);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return deals;
    }

    public static ArrayList<Comment> getComments(Long dealId){

        ArrayList<Comment> comments = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT comment.id, comment.client_id, comment.deal_id, comment.body, comment.date, " +
                    "client.name AS clientName, client.company, "+
                    "deal.id AS dealid "+
                    "FROM comments comment "+
                    "INNER JOIN clients client ON client.id = comment.client_id "+
                    "INNER JOIN deals deal ON deal.id = comment.deal_id "+
                    "WHERE comment.deal_id = ? "+
                    "ORDER BY comment.date DESC");

            statement.setLong(1, dealId);

            ResultSet resultSet =statement.executeQuery();

            while (resultSet.next()){

                Comment newComment = new Comment();

                Client newClient = new Client();
                newClient.setId(resultSet.getLong("client_id"));
                newClient.setName(resultSet.getString("clientName"));
                newClient.setCompany(resultSet.getString("company"));
                newComment.setClient(newClient);

                Deal newDeal = new Deal();
                newDeal.setId(resultSet.getLong("dealid"));
                newComment.setDeal(newDeal);

                newComment.setId(resultSet.getLong("id"));
                newComment.setComment(resultSet.getString("body"));
                newComment.setDate(resultSet.getTimestamp("date"));

                comments.add(newComment);

            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return comments;
    }

    public static ArrayList<Country> getAllCountries(){

        ArrayList<Country> countries = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * FROM countries");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Country c = new Country();

                c.setId(resultSet.getLong("id"));
                c.setName((resultSet.getString("name")));

                countries.add(c);
            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return countries;
    }

    public static Country getCountry(Long id){

        Country c = new Country();

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * FROM countries WHERE id=?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                c.setId(resultSet.getLong("id"));
                c.setName((resultSet.getString("name")));

            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return c;
    }

    public static void addClient(Client client){

        try {
         PreparedStatement statement = connection.prepareStatement("" +
                 "INSERT INTO clients (name, company, country_id, login, password) values ( ?, ?, ?, ?, ?)");
         statement.setString(1, client.getName());
         statement.setString(2, client.getCompany());
         statement.setLong(3, client.getCountry().getId());
         statement.setString(4, client.getLogin());
         statement.setString(5, client.getPassword());

         statement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addComment(Comment comment){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (client_id, deal_id, body, date) values ( ?, ?, ?, NOW() )");
            statement.setLong(1, comment.getClient().getId());
            statement.setLong(2, comment.getDeal().getId());
            statement.setString(3, comment.getComment() );

            statement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Client> getAllClients(){

        ArrayList <Client> allClients = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT c.id, c.name, c.company, country.name AS country_name FROM clients c INNER JOIN countries country ON country.id = c.country_id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Client c = new Client();
                c.setId(resultSet.getLong("id"));
                c.setName(resultSet.getString("name"));
                c.setCompany(resultSet.getString("company"));

                Country country = new Country();
                country.setName(resultSet.getString("country_name"));
                c.setCountry(country);

                allClients.add(c);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return allClients;
    }

    public static void addDeal(Deal d){


        try{

            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO deals (header, short_description, description, price, picture1, picture2, picture3, client_id) "+
                    "values ( ?, ?, ?, ?, ?, ?, ?, ? )");

            statement.setString(1, d.getMain());
            statement.setString(2, d.getShortDescription());
            statement.setString(3, d.getDescription());
            statement.setInt(4, d.getPrice());
            statement.setString(5, d.getPicture1());
            statement.setString(6, d.getPicture2());
            statement.setString(7, d.getPicture3());
            statement.setLong(8, d.getClient().getId());

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void addCounty(Country c){
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO countries (name) "+
                    "values (?)");
            statement.setString(1, c.getName());
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteCountry(Long id){

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "DELETE FROM countries WHERE id = ?");
            statement.setLong(1, id);

            PreparedStatement statement1 = connection.prepareStatement(""+
                    "DELETE FROM clients WHERE country_id = ?");
            statement1.setLong(1, id);

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteDeal(Long id){

        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "DELETE FROM deals WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
