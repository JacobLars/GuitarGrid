"use client";
import React, { ReactNode, createContext, useContext, useState } from "react";
import { Product } from "../types/Types";

// Define the shape of your product

// Define the shape of your cart item
interface CartItem {
  product: Product;
  quantity: number;
}

// Define the shape of your context
interface CartContextType {
  cart: CartItem[];
  addToCart: (product: Product) => void;
}

// Create the context
const CartContext = createContext<CartContextType | undefined>(undefined);

// Create a custom hook to access the cart context
export const useCart = () => {
  const context = useContext(CartContext);
  if (!context) {
    throw new Error("useCart must be used within a CartProvider");
  }
  return context;
};

interface CartProviderProps {
  children: ReactNode;
}

// Create the provider component
export const CartProvider: React.FC<CartProviderProps> = ({ children }) => {
  const [cart, setCart] = useState<CartItem[]>([]);

  const addToCart = (product: Product) => {
    // Check if the product already exists in the cart
    const existingItemIndex = cart.findIndex(
      (item) => item.product.id === product.id
    );
    if (existingItemIndex !== -1) {
      // If the product already exists, update its quantity
      const updatedCart = [...cart];
      updatedCart[existingItemIndex].quantity += 1;
      setCart(updatedCart);
    } else {
      // If the product doesn't exist, add it to the cart with quantity 1
      setCart((prevCart) => [...prevCart, { product, quantity: 1 }]);
    }
  };

  return (
    <CartContext.Provider value={{ cart, addToCart }}>
      {children}
    </CartContext.Provider>
  );
};
