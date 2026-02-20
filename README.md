# Personalized Quote Generator API

A **Spring Boot** REST API to manage and fetch quotes.  
Uses **MySQL** for storage and can be run locally or with Docker.

---

## Features

- Fetch all quotes: `GET /quote`
- Get a random quote: `GET /quote/random?increment=false`
- Fetch quotes by category: `GET /quote/category/{category}`
- Create, update, delete quotes: `POST / PUT / DELETE /quote`
- Top 5 popular quotes: `GET /quote/popular`

---

## Quick Start (Local + Docker)

# Clone repository
git clone https://github.com/yourusername/QuoteGenerator.git
cd QuoteGenerator

# Build Docker image for Spring Boot app
mvn clean package -DskipTests
docker build -t devhamaad/quotegenerator:v1 .

# Start services with Docker Compose
docker-compose up -d

# Check logs
docker-compose logs -f

# Stop services
docker-compose down


# View real-time logs
docker-compose logs -f

# Use environment variables to override defaults
# Perfect for testing APIs or deploying anywhere


## NOTE : Please make sure docker hub is installed on your machine

