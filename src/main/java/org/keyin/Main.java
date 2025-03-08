package org.keyin;

import java.io.IOException;
import java.util.Scanner;
import org.keyin.client.HttpClient;

public class Main {
    private static final String API_BASE_URL = "http://localhost:8080/api/";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean mainLoop = true;
        while (mainLoop) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Manage Cities");
            System.out.println("2. Manage Passengers");
            System.out.println("3. Manage Airports");
            System.out.println("4. Manage Aircraft");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    boolean citiesLoop = true;
                    while (citiesLoop) {
                        String citiesURL = API_BASE_URL + "cities";

                        System.out.println("Manage Cities");
                        System.out.println("1. List All Cities");
                        System.out.println("2. Add City");
                        System.out.println("3. Delete City");
                        System.out.println("4. Edit City");
                        System.out.println("5. Exit to Main Menu");

                        int cityChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (cityChoice) {
                            case 1:
                                System.out.println("All Cities: ");
                                System.out.println(HttpClient.sendGetRequest(citiesURL));
                                break;
                            case 2:
                                System.out.println("Add City");
                                System.out.println("Enter city name: ");
                                String cityName = scanner.nextLine();
                                System.out.println("Enter country of city: ");
                                String cityCountry = scanner.nextLine();
                                String cityJSON = "{\"name\": \"" + cityName + "\", \"country\": \"" + cityCountry + "\"}";
                                System.out.println(HttpClient.sendPostRequest(citiesURL, cityJSON));
                                break;

                            case 3:
                                System.out.println("Delete City: ");
                                System.out.println("Enter city ID to delete: ");
                                Long deleteId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println(HttpClient.sendDeleteRequest(citiesURL + "/" + deleteId));
                                break;

                            case 4:
                                System.out.println("Edit City: ");
                                System.out.println("Enter city ID to edit: ");
                                Long editId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println("Enter city name: ");
                                String editCity = scanner.nextLine();
                                System.out.println("Enter country of city: ");
                                String editCountry = scanner.nextLine();
                                String cityEditJSON = "{\"id\": " + editId + ", \"name\": \"" + editCity + "\", \"country\": \"" + editCountry + "\"}";
                                System.out.println(HttpClient.sendPutRequest(citiesURL + "/" + editId, cityEditJSON));
                                break;

                            case 5:
                                citiesLoop = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean passengerLoop = true;
                    while (passengerLoop) {
                        String passengersURL = API_BASE_URL + "passengers";

                        System.out.println("Manage Passengers");
                        System.out.println("1. List All Passengers");
                        System.out.println("2. Add Passenger");
                        System.out.println("3. Delete Passenger");
                        System.out.println("4. Edit Passenger");
                        System.out.println("5. Exit to Main Menu");

                        int passengerChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (passengerChoice) {
                            case 1:
                                System.out.println("All Passengers: ");
                                System.out.println(HttpClient.sendGetRequest(passengersURL));
                                break;

                            case 2:
                                System.out.println("Add Passenger");
                                System.out.println("Enter passenger name: ");
                                String passengerName = scanner.nextLine();
                                System.out.println("Enter passengers city ID: ");
                                Long passengerCityID = scanner.nextLong();
                                scanner.nextLine();
                                String passengerJSON = String.format(
                                        "{\"name\": \"%s\", \"city\": {\"id\": %d}}",
                                        passengerName, passengerCityID
                                );
                                System.out.println(HttpClient.sendPostRequest(passengersURL, passengerJSON));
                                break;

                            case 3:
                                System.out.println("Delete Passenger: ");
                                System.out.println("Enter passenger ID to delete: ");
                                Long deleteId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println(HttpClient.sendDeleteRequest(passengersURL + "/" + deleteId));
                                break;

                            case 4:
                                System.out.println("Edit Passenger: ");
                                System.out.println("Enter passenger ID to edit: ");
                                Long editId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println("Enter name of passenger: ");
                                String editName = scanner.nextLine();
                                System.out.println("Enter city ID of passenger: ");
                                Long editCityId = scanner.nextLong();
                                scanner.nextLine();
                                String passengerEditJSON = String.format(
                                        "{\"id\": %d, \"name\": \"%s\", \"city\": {\"id\": %d}}",
                                        editId, editName, editCityId
                                );
                                System.out.println(HttpClient.sendPutRequest(passengersURL + "/" + editId, passengerEditJSON));
                                break;

                            case 5:
                                passengerLoop = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean airportLoop = true;
                    while (airportLoop) {
                        String airportsURL = API_BASE_URL + "airports";

                        System.out.println("Manage Airports");
                        System.out.println("1. List All Airports");
                        System.out.println("2. Add Airport");
                        System.out.println("3. Delete Airport");
                        System.out.println("4. Edit Airport");
                        System.out.println("5. Exit to Main Menu");

                        int airportChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (airportChoice) {
                            case 1:
                                System.out.println("All Airports: ");
                                System.out.println(HttpClient.sendGetRequest(airportsURL));
                                break;

                            case 2:
                                System.out.println("Add Airport");
                                System.out.print("Enter airport name: ");
                                String airportName = scanner.nextLine();
                                System.out.print("Enter city ID where airport is located: ");
                                Long cityId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.print("Enter airport code: ");
                                String airportCode = scanner.nextLine();
                                String airportJSON = String.format(
                                        "{\"name\": \"%s\", \"city\": {\"id\": %d}, \"airportCode\": \"%s\"}",
                                        airportName, cityId, airportCode
                                );
                                System.out.println(HttpClient.sendPostRequest(airportsURL, airportJSON));
                                break;

                            case 3:
                                System.out.println("Delete Airport: ");
                                System.out.println("Enter airport ID to delete: ");
                                Long deleteId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println(HttpClient.sendDeleteRequest(airportsURL + "/" + deleteId));
                                break;

                            case 4:
                                System.out.println("Edit Airport: ");
                                System.out.print("Enter airport ID to edit: ");
                                Long editId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.print("Enter name of airport: ");
                                String editName = scanner.nextLine();
                                System.out.print("Enter city ID of airport: ");
                                Long editCityId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.print("Enter airport code: ");
                                String editCode = scanner.nextLine();
                                String airportEditJSON = String.format(
                                        "{\"id\": %d, \"name\": \"%s\", \"city\": {\"id\": %d}, \"airportCode\": \"%s\"}",
                                        editId, editName, editCityId, editCode
                                );
                                System.out.println(HttpClient.sendPutRequest(airportsURL + "/" + editId, airportEditJSON));
                                break;

                            case 5:
                                airportLoop = false;
                                break;
                        }
                    }
                    break;
                    case 4:
                        boolean aircraftLoop = true;
                        while (aircraftLoop) {
                            String aircraftURL = API_BASE_URL + "aircraft";

                            System.out.println("Manage Aircraft");
                            System.out.println("1. List All Aircraft");
                            System.out.println("2. Add Aircraft");
                            System.out.println("3. Delete Aircraft");
                            System.out.println("4. Edit Aircraft");
                            System.out.println("5. Exit to Main Menu");

                            int aircraftChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (aircraftChoice) {
                                case 1:
                                    System.out.println("All Aircraft: ");
                                    System.out.println(HttpClient.sendGetRequest(aircraftURL));
                                    break;
                                case 2:
                                    System.out.println("Add Aircraft");
                                    System.out.println("Enter aircraft name: ");
                                    String aircraftName = scanner.nextLine();
                                    String aircraftJSON = "{\"name\": \"" + aircraftName + "\"}";
                                    System.out.println(HttpClient.sendPostRequest(aircraftURL, aircraftJSON));
                                    break;

                                case 3:
                                    System.out.println("Delete Aircraft: ");
                                    System.out.println("Enter aircraft ID to delete: ");
                                    Long deleteId = scanner.nextLong();
                                    scanner.nextLine();
                                    System.out.println(HttpClient.sendDeleteRequest(aircraftURL + "/" + deleteId));
                                    break;

                                case 4:
                                    System.out.println("Edit Aircraft: ");
                                    System.out.println("Enter aircraft ID to edit: ");
                                    Long editId = scanner.nextLong();
                                    scanner.nextLine();
                                    System.out.println("Enter aircraft name: ");
                                    String editName = scanner.nextLine();
                                    String aircraftEditJSON = "{\"id\": " + editId + ", \"name\": \"" + editName + "\"}";
                                    System.out.println(HttpClient.sendPutRequest(aircraftURL + "/" + editId, aircraftEditJSON));
                                    break;

                                case 5:
                                    aircraftLoop = false;
                                    break;
                            }
                        }
                        mainLoop = false;
                    }
            }
        }
    }