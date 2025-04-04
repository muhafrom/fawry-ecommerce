# fawry-ecommerce

## Overview

This project implements a simple **ecommerce system** in Java that handles product management, customer checkout, and shipping. The system supports products with different attributes like expiration, stock quantity, and shipping requirements.

## Key Features

- **Products**: Support for products with name, price, quantity, and types (expirable, shippable).
- **Cart**: Add products to the cart and check out.
- **Checkout**: Calculates subtotal, shipping fees, and ensures the customer has enough balance.
- **Shipping**: Manages shipping for shippable products based on weight.

## Classes

- **Product**: Defines the properties and methods for products (e.g., expiration check, quantity).
- **Customer**: Handles customer details and balance.
- **Shippable**: Interface for products that require shipping, with methods to retrieve the product's name and weight.
- **Cart**: Manages items added to the cart.
- **CheckoutService**: Handles checkout logic (subtotal, shipping, balance).
- **ShippingService**: Processes shipping fees based on weight.
- **Main**: Entry point for running the program.

## Error Handling

- **Empty Cart**: Error if no products are in the cart.
- **Insufficient Funds**: Error if the customer doesn't have enough balance.
- **Out of Stock**: Error if product quantity exceeds available stock.
- **Expired Products**: Error if a product is expired.
