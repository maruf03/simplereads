# Simplereads

Simplereads is a basic Goodreads clone that allows users to post, comment and view book reviews. This project is divided into two main parts: the backend and the frontend.

## Project Structure

- **backend/**: Contains the backend code.
- **frontend/**: Contains the frontend code.
- **sql/**: Contains the sql scripts to create necessary tables and populate them with dummy data for testing purposes.
- **docker-compose.yaml**: Used for orchestrating the deployment of the backend and frontend services.

## Deployment

### Prerequisites

- Docker
- Docker Compose

### Steps

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/simplereads.git
    cd simplereads
    ```

2. Build and start the services using Docker Compose:
    ```sh
    docker-compose up --build
    ```

3. Access the application:
    - Frontend: `http://localhost:3000`
    - Backend: `http://localhost:8000`

## Development

### Database Setup for Development

To set up the database for development, run the scripts located in the `sql` directory. These scripts will create the required tables in PostgreSQL. The `seed.sql` script contains dummy data for testing purposes and is optional.

### Backend

Navigate to the `backend` directory and follow the instructions in the `README.md` file located there.

### Frontend

Navigate to the `frontend` directory and follow the instructions in the `README.md` file located there.

## Contributing

Feel free to submit issues and pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Disclaimer

This project is for demonstration purposes. Viewers are allowed to use it as they please but are discouraged from using it in production.

