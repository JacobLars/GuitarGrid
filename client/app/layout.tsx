import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import { CartProvider } from "./contexts/CartContext";
import { Menu } from "./components/userActions/Menu";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Guitar Grid",
  description: "Generated by create next app",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <CartProvider>
        <body className={inter.className}>{children}</body>
      </CartProvider>
    </html>
  );
}
