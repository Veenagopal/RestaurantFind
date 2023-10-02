import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        Restaurant restaurant = null;
        boolean restaurantExists = false;
        Iterator<Restaurant> restaurantIterator = this.getRestaurants().iterator();
        while(restaurantIterator.hasNext()) {
            restaurant = restaurantIterator.next();
            if(restaurant.getName().equalsIgnoreCase(restaurantName)) {
                restaurantExists = true;
                break;
            }
        }
        if(!restaurantExists)
            throw new restaurantNotFoundException(restaurantName);
        return restaurant;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
