
# Ecommerce App

**Ecommerce App** is a web application designed to provide a seamless online shopping experience. Users can browse products, add them to the cart, and make purchases. The application includes features for both customers and admins.

## ✨ Features

- **Customer Features:**
  - Browse and search for products
  - Add products to the shopping cart
  - Checkout and order products
  - User authentication (register/login/logout)
  
- **Admin Features:**
  - Manage product listings (add, edit, delete)
  - Manage user accounts
  - View and manage orders

## 🛠️ Tech Stack

- **Frontend:** HTML, CSS, JavaScript, React.js (sau altă tehnologie utilizată)
- **Backend:** Node.js, Express.js
- **Database:** MongoDB (sau altă bază de date utilizată)
- **Authentication:** JWT (JSON Web Tokens)
- **Payment Integration:** Stripe (sau altă metodă de plată)

## 🚀 Getting Started

### Prerequisites

- Node.js installed
- MongoDB (local sau cloud)
- A web browser

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/robertsamata/Ecommerce-App.git
   ```

2. **Install dependencies:**
   - Navigate to the project directory:
     ```bash
     cd Ecommerce-App
     ```
   - Install server-side dependencies:
     ```bash
     npm install
     ```
   - Dacă folosești React pentru frontend, navighează în directorul frontend și instalează și acolo dependențele:
     ```bash
     cd frontend
     npm install
     ```

3. **Set up the environment variables:**
   - Creează un fișier `.env` și adaugă variabilele de mediu pentru conexiunea la baza de date și cheile API pentru procesarea plăților.
     ```
     MONGO_URI=your_mongo_connection_string
     JWT_SECRET=your_jwt_secret_key
     STRIPE_SECRET_KEY=your_stripe_secret_key
     ```

4. **Run the application:**
   - Pentru a porni serverul:
     ```bash
     npm start
     ```
   - Deschide browserul și accesează aplicația pe `http://localhost:5000` sau portul corespunzător configurat.

## 📂 Project Structure

```
Ecommerce-App/
├── backend/      # Server-side code (Node.js, Express)
│   ├── models/    # MongoDB models
│   ├── routes/    # API routes
│   └── controllers/  # Route handlers
├── frontend/     # Client-side code (React)
│   ├── src/
│   └── public/
├── config/        # Configuration files
├── .env           # Environment variables
└── package.json   # Project metadata and dependencies
```

## 🎯 Future Improvements

- Add user profile management (update profile, change password)
- Add product reviews and ratings
- Implement order tracking for users
- Optimize for mobile responsiveness
