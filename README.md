# Invoice Management System

## Overview
The **Invoice Management System** is a Java-based desktop application built using JavaFX. It allows users to manage invoices, clients, products, and related data effectively. The system supports essential functionalities such as user authentication, creating invoices, tracking payments, and storing information in a MariaDB database.

---

## Features
- **User Authentication**:
  - Secure login system with password validation.
  - Error handling for incorrect login attempts.

- **Invoice Management**:
  - Create, edit, and delete invoices.
  - Add invoice items linked to products.
  - Track invoice payment status (Paid, Unpaid, Overdue).

- **Client Management**:
  - Add, edit, and delete client information.

- **Product Management**:
  - Maintain a list of products or services with descriptions and prices.

- **Database Integration**:
  - Stores data in a MariaDB database.
  - Utilizes a `.env` file for secure configuration of database credentials.

---

## Requirements
### Software:
- Java 17 or later
- JavaFX SDK
- MariaDB Server
- Maven (for dependency management)

### Libraries:
- [java-dotenv](https://github.com/cdimascio/java-dotenv): For managing environment variables.
- JavaFX Controls and FXML: For UI development.

---

## Database Schema

The database includes four main tables:

### **clients** (Stores client information):
```sql
CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(20),
    tax_id VARCHAR(50)
);
```

### **invoices** (Stores invoice details):
```sql
CREATE TABLE invoices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_number VARCHAR(50) UNIQUE NOT NULL,
    issue_date DATE NOT NULL,
    due_date DATE NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    status ENUM('PAID', 'UNPAID', 'OVERDUE') DEFAULT 'UNPAID',
    client_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);
```

### **products** (Stores product or service information):
```sql
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    unit VARCHAR(20),
    price DECIMAL(10, 2) NOT NULL
);
```

### **invoice_items** (Stores items listed on invoices):
```sql
CREATE TABLE invoice_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity DECIMAL(10, 2) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoices(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id)
);
```

---

## Installation

### 1. Clone the Repository
```bash
git clone https://github.com/your-repo/invoice-management-system.git
cd invoice-management-system
```

### 2. Configure Environment Variables
Create a `.env` file in the root directory with the following content:
```env
DB_URL=jdbc:mariadb://localhost:3306/invoiceapp
DB_USER=your_database_user
DB_PASSWORD=your_database_password
```

### 3. Build the Project
Use Maven to build the project:
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn javafx:run
```

---

## Usage
1. Start the application and log in with valid credentials.
2. Navigate through the following features:
   - **Clients**: Manage client data.
   - **Products**: Add or update products/services.
   - **Invoices**: Create, edit, or view invoices and their statuses.
3. Ensure MariaDB is running and configured correctly before using the application.

---

## Development
### Adding Features:
- Implement additional database tables or modify the schema as needed.
- Extend the JavaFX UI for new functionalities.

### Testing:
- Use mock data for local testing.
- Validate database queries and UI interactions.

---

## Contributing
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.
