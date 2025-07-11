# 📘 Technical Documentation: Razorpay Payment Gateway Full-Stack Integration

This document provides a detailed explanation of the components, logic, and flow used in building the Razorpay Payment Gateway integration project using Spring Boot and JavaScript.

---

## 🔁 End-to-End Payment Workflow

1. **User fills form on frontend**:
    - Name, Email, Phone number, Coupon code (optional).
    - Price is dynamically adjusted based on the coupon applied.

2. **Payment initiated via Razorpay Checkout**:
    - Frontend sends user details and amount to the backend (`/api/payment/createOrder`).
    - Backend creates a Razorpay order and returns `order_id`.

3. **Razorpay popup is shown**:
    - Razorpay securely collects payment info.
    - On success, Razorpay returns `payment_id` and `order_id`.

4. **Payment confirmation sent to backend**:
    - Frontend makes a second call to `/api/payment/updateOrderr` with paymentId, orderId, and status.

5. **Email confirmation is sent**:
    - Backend updates the database and sends a confirmation email using SMTP.

---

## 🧩 Project Modules Overview

### 1. **Backend (Spring Boot)**

#### ✅ `PaymentController.java`
- **Route:** `/api/payment/createOrder`
    - Accepts JSON with `name`, `email`, `phone`, `amount`, `courseName`
    - Uses Razorpay Java SDK to generate a new order (`Order order = razorpayClient.orders.create(...)`)
    - Persists data to DB with status `CREATED`.

- **Route:** `/api/payment/updateOrderr`
    - Receives `orderId`, `paymentId`, and `status` from frontend after success
    - Updates DB with status `SUCCESS`
    - Sends confirmation email to user

#### ✅ `PaymentService.java`
- Handles logic for Razorpay client creation and DB interaction.
- Converts rupees to paisa (`amount * 100`) before sending to Razorpay.
- Saves `PaymentOrder` with timestamps.

#### ✅ `EmailService.java`
- Uses `JavaMailSender` to send templated confirmation emails.
- Configured using Gmail SMTP (TLS + port 587).

#### ✅ `PaymentOrder.java`
- JPA entity storing:
    - `id`, `name`, `email`, `phone`
    - `courseName`, `amount`, `orderId`, `paymentId`, `status`, `createdAt`

#### ✅ `WebConfig.java`
- Configures CORS to allow frontend access (`localhost:5500` or similar).

### 2. **Frontend (HTML + CSS + JavaScript)**

#### ✅ `index.html`
- Collects user data through a modern, styled form.
- Displays pricing, discount, coupon input, and total amount.
- Banner and highlights of the course.

#### ✅ `script.js`
- Validates form input (name, email, phone).
- Applies coupon (`EARLYBIRD`, `CLOUDSTART`) and updates price dynamically.
- Calls backend `/createOrder` to create Razorpay order.
- Initializes Razorpay Checkout with user and course info.
- On successful payment, POSTs to `/updateOrderr`.
- Displays alert and UI confirmation.

### 3. **application.properties**
```properties
# Razorpay keys
razorpay.key_id=rzp_test_...
razorpay.key_secret=...

# DB (MySQL)
spring.datasource.url=jdbc:mysql://localhost:3306/paymentDB
spring.datasource.username=root
spring.datasource.password=...

# Email (Gmail SMTP)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=youremail@gmail.com
spring.mail.password=...
```

---

## 🗃️ Database Table (`payment_order`)
| Column     | Type         | Description                         |
|------------|--------------|-------------------------------------|
| id         | Long (PK)    | Auto-generated primary key          |
| name       | String       | User's full name                    |
| email      | String       | User's email                        |
| phone      | String       | Contact number                      |
| courseName | String       | Name of the enrolled course         |
| amount     | Double       | Amount paid                         |
| orderId    | String       | Razorpay generated order ID         |
| paymentId  | String       | Razorpay payment ID after success   |
| status     | String       | CREATED / SUCCESS                   |
| createdAt  | LocalDateTime| Timestamp for order creation        |

---

## ✉️ Email Template Sample

```
Hi Prasad,

🎉 Thank you for enrolling in *CloudPro 1.0: Complete Azure Cloud Engineer Bootcamp*!

We’ve successfully received your payment of ₹9999.

📚 Your journey toward mastering Azure Cloud starts now.

If you have any questions, feel free to reply to this email.

Best wishes,  
Team CodeSpark 🚀
```

---

## 🧪 Testing & Validation

- Razorpay is in TEST mode — real money is not deducted.
- UPI, Net Banking, Card, and Wallet options available (except in some test cases).
- Email sends only on successful payment (status = SUCCESS).

---

## ✅ Deployment Notes

- Run backend via Spring Boot main class
- Use `Live Server` in VSCode to launch `index.html` or place it under `/static` in Spring Boot

---

## 📌 Key Tips

- Always convert INR to paisa before calling Razorpay API
- Use correct `key_id` and `key_secret`
- Confirm CORS setup if frontend is hosted separately
- Ensure Gmail App Password is used for JavaMail

---

## 🔐 Security Notes

- Keep your Razorpay credentials secret
- Use HTTPS in production
- Consider adding validations against forged updates

---

## 🙋 Support

Have questions or want to contribute? Feel free to reach out or fork the project.

Happy Coding! ⚡