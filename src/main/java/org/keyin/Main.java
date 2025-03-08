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
                        switch (cityChoice) {
                            case 1:
                                System.out.println("All Cities: ");
                                System.out.println(HttpClient.sendGetRequest(citiesURL));
                                break;
                            case 2:
                                System.out.println("Add City");
                                System.out.println("Enter city name: ");
                                String cityName = scanner.next();
                                System.out.println("Enter country of city: ");
                                String cityCountry = scanner.next();
                                String cityJSON = "{\"name\": \"" + cityName + "\", \"country\": \"" + cityCountry + "\"}";
                                System.out.println(HttpClient.sendPostRequest(citiesURL, cityJSON));
                                break;

                            case 3:
                                System.out.println("Delete City: ");
                                System.out.println("Enter city ID to delete: ");
                                Long deleteId = scanner.nextLong();
                                System.out.println(HttpClient.sendDeleteRequest(citiesURL + "/" + deleteId));
                                break;

                            case 4:
                                System.out.println("Edit City: ");
                                System.out.println("Enter city ID to edit: ");
                                Long editId = scanner.nextLong();
                                System.out.println("Enter city name: ");
                                String editCity = scanner.next();
                                System.out.println("Enter country of city: ");
                                String editCountry = scanner.next();
                                String cityEditJSON = "{\"id\": " + editId + ", \"name\": \"" + editCity + "\", \"country\": \"" + editCountry + "\"}";
                                System.out.println(HttpClient.sendPutRequest(citiesURL + "/" + editId, cityEditJSON));
                                break;

                            case 5:
                                citiesLoop = false;
                        }
                    }
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
                        switch (passengerChoice) {
                            case 1:
                                System.out.println("All Passengers: ");
                                System.out.println(HttpClient.sendGetRequest(passengersURL));
                                break;

                            case 2:
                                System.out.println("Add Passenger");
                                System.out.println("Enter passenger name: ");
                                String passengerName = scanner.next();
                                System.out.println("Enter passengers city: ");
                                String passengerCity = scanner.next();
                                String passengerJSON = "{\"name\": \"" + passengerName + "\", \"city\": \"" + passengerCity + "\"}";
                                System.out.println(HttpClient.sendPostRequest(passengersURL, passengerJSON));
                                break;

                            case 3:
                                System.out.println("Delete Passenger: ");
                                System.out.println("Enter passenger ID to delete: ");
                                Long deleteId = scanner.nextLong();
                                System.out.println(HttpClient.sendDeleteRequest(passengersURL + "/" + deleteId));
                                break;

                            case 4:
                                System.out.println("Edit Passenger: ");
                                System.out.println("Enter passenger ID to edit: ");
                                Long editId = scanner.nextLong();
                                System.out.println("Enter name of passenger: ");
                                String editName = scanner.next();
                                System.out.println("Enter city of passenger: ");
                                String editCity = scanner.next();
                                String passengerEditJSON = "{\"id\": " + editId + ", \"name\": \"" + editName + "\", \"city\": \"" + editCity + "\"}";
                                System.out.println(HttpClient.sendPutRequest(passengersURL + "/" + editId, passengerEditJSON));
                                break;

                            case 5:
                                passengerLoop = false;
                        }
                    }
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
                        switch (airportChoice) {
                            case 1:
                                System.out.println("All Airports: ");
                                System.out.println(HttpClient.sendGetRequest(airportsURL));
                                break;

                            case 2:
                                System.out.println("Add Airport");
                                System.out.println("Enter airport name: ");
                                String airportName = scanner.next();
                                System.out.println("Enter airport city: ");
                                String airportCity = scanner.next();
                                System.out.println("Enter airport code: ");
                                String airportCode = scanner.next();
                                String airportJSON = "{\"name\": \"" + airportName + "\", \"city\": \"" + airportCity + "\" + \"airportCode\": \"" + airportCode + "\"}";
                                System.out.println(HttpClient.sendPostRequest(airportsURL, airportJSON));
                                break;

                            case 3:
                                System.out.println("Delete Airport: ");
                                System.out.println("Enter airport ID to delete: ");
                                Long deleteId = scanner.nextLong();
                                System.out.println(HttpClient.sendDeleteRequest(airportsURL + "/" + deleteId));
                                break;

                            case 4:
                                System.out.println("Edit Airport: ");
                                System.out.println("Enter airport ID to edit: ");
                                Long editId = scanner.nextLong();
                                System.out.println("Enter name of airport: ");
                                String editName = scanner.next();
                                System.out.println("Enter city of airport: ");
                                String editCity = scanner.next();
                                System.out.println("Enter airport code: ");
                                String editCode = scanner.next();
                                String airportEditJSON = "{\"id\": " + editId + ", \"name\": \"" + editName + "\", \"city\": \"" + editCity + "\" + \"airportCode\": \"" + editCode + "\"}";
                                System.out.println(HttpClient.sendPutRequest(airportsURL + "/" + editId, airportEditJSON));
                                break;

                            case 5:
                                airportLoop = false;
                        }
                    }
                        mainLoop = false;
                    }
            }
        }
    }