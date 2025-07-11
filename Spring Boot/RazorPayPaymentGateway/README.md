# RazorPay Payment Gateway Integration 💳

This project demonstrates a complete end-to-end integration of Razorpay Payment Gateway using Spring Boot for the backend and HTML/CSS/JavaScript for the frontend.

## 🚀 Features

- Razorpay payment integration with dynamic pricing
- Coupon code application (e.g., `EARLYBIRD`, `CLOUDSTART`)
- Real-time price update on UI
- Email confirmation on successful payment
- Razorpay Checkout popup (Test mode)
- Responsive and user-friendly interface

## 🧰 Technologies Used

### Backend (Spring Boot)
- Java 17
- Spring Boot 3.x
- Spring Data JPA (H2/MySQL supported)
- Spring Web (RESTful API)
- JavaMailSender (for email service)
- Razorpay Java SDK

### Frontend
- HTML5, CSS3, Vanilla JavaScript
- Razorpay Checkout.js
- Font Awesome Icons

## 📂 Project Structure

```
Payment-Gateway/
├── src/main/java/com/SpringBoot/Payment_Gateway/
│   ├── controller/PaymentController.java
│   ├── service/EmailService.java
│   ├── entity/PaymentOrder.java
│   ├── repository/PaymentRepository.java
│   ├── config/WebConfig.java
│   └── PaymentGatewayApplication.java
├── public/ or static/
│   ├── index.html
│   ├── styles.css
│   └── script.js
├── resources/
│   ├── application.properties
```

## 📦 How to Run

1. Clone the project
2. Import into any IDE (IntelliJ, VSCode, etc.)
3. Run `PaymentGatewayApplication.java`
4. Open `index.html` with Live Server or host using Spring Boot's static resources

## 📧 Email Integration

Emails are sent using SMTP via `JavaMailSender`. You can configure your SMTP in `application.properties`.

## 📝 License

MIT License