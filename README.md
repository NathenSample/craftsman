# Craftsman

Craftsman is a Java Spring Boot application designed to help players of the game *ArcheAge* determine the base ingredient and labor requirements for crafting items, based on user-specified configurations.

## Features

- **Base Ingredient Calculation**: Determines the required base materials (e.g., ores, plants, etc.) for crafting items in *ArcheAge*.
- **Labor Cost Calculation**: Calculates the labor cost for crafting based on user input and predefined configurations.
- **Custom Configurations**: Allows users to define and apply custom configurations for item crafting.
- **API Access**: Easily accessible RESTful API for fetching crafting requirements.

## Prerequisites

- Java 11 or higher

## Installation and Running Locally

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/craftsman.git
    ```

2. Navigate into the project directory:

   ```bash
    cd craftsman
   ```
   
3. Build the project:

   ```bash
    ./gradlew clean build
   ```
   
4. Run the application:

   ```bash
    ./gradlew run
   ```
The application will be available at `http://localhost:8080`.


## API Endpoints (Current)
### Get Crafting Requirements
* **URL:** `/crafting-requirements`
* **Method:** `GET`
* **Query Parameters:**
   * `itemName` (required): Name of the item to craft.

#### Example Request:

   ```bash
   GET localhost:8080/crafting-requirements?itemName=Scroll:+Rampage+S200
   ```

#### Example Response:

   ```json
{
      "Copper Ore": 192,
      "Iron Ore": 3546,
      "Azalea": 880,
      "Narcissus": 880,
      "Charcoal Stabilizer": 1222
   }
   ```


## API Endpoints (Planned)
### Get Crafting Requirements
* **URL:** `/crafting-requirements`
* **Method:** `GET`
* **Query Parameters:**
  * `itemName` (required): Name of the item to craft.
  *  `config` (optional): Custom configuration for the crafting process.
  
#### Example Request:

   ```bash
   GET localhost:8080/crafting-requirements?itemName=Scroll:+Rampage+S200
   ```

#### Example Response:

   ```json
{
   "ingredients": {
      "Copper Ore": 192,
      "Iron Ore": 3546,
      "Azalea": 880,
      "Narcissus": 880,
      "Charcoal Stabilizer": 1222
   },
   "laborRequired": 500
}
   ```

## Configuration (Planned)
The application will support custom user configurations for crafting. This allows you to adjust the proficiency based labour discounts, or add additional rules specific to your needs.

You can pass a configuration in the API request to customize the results.

## Contributing
* Fork the repository
* Create a feature branch (git checkout -b feature/your-feature-name)
* Commit your changes (git commit -m 'Add new feature')
* Push to the branch (git push origin feature/your-feature-name)
* Open a [pull request](https://github.com/NathenSample/craftsman/pulls)

## License
This project is licensed under the MIT License - see the [LICENSE](https://github.com/NathenSample/craftsman/blob/master/LICENSE) file for details.

## Questions or Issues?
If you encounter any issues or have questions, feel free to open an issue or submit a pull request. Happy crafting!