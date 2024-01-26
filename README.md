# eTalente Assessment - Spring Boot REST API

Author: Mario Antonio  
School Email: maanton022@student.wethinkcode.co.za  
Personal Email: m.antonio0294@gmail.com

## Overview

This project is a Spring Boot REST API that provides functionality related to investors, their products and withdrawal notices, and H2 database management. It offers the following endpoints:

1. **Get All Investors**
    - **Endpoint:** `GET /investors`
    - **Description:** Gets all the investors stored in the database.

2. **Get Investor by ID**
    - **Endpoint:** `GET /investor/{id}`
    - **Description:** Gets the investor with the provided ID.

3. **Create Withdrawal Notice**
    - **Endpoint:** `POST /withdrawal-notice/{productId}/{withdrawalAmount}`
    - **Description:** Creates a withdrawal notice of a certain amount for a given product.

4. **Get Withdrawal Notices by Product ID**
    - **Endpoint:** `GET /withdrawal-notices/{productId}`
    - **Description:** Gets all the withdrawal notices of a product with the provided ID.

5. **H2 Database Console**
    - **Endpoint:** `/h2-console`
    - **Description:** Allows you to view the H2 database console.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Build and Run

1. Clone the repository:

   ```bash
   git clone https://github.com/MuddBone4/etalente-assessment.git
   ```

2. Navigate to the project directory:

   ```bash
   cd etalente-assessment
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   java -jar .\target\marioantonio-0.0.1-SNAPSHOT.jar
   ```
