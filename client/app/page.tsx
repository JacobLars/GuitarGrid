"use client";
import { NavBar } from "./components/navbar/NavBar";
import { Categories } from "./components/products/Categories";
import { Header } from "./components/header/Header";
import { BrandGallery } from "./components/brands/BrandGallery";
import { Menu } from "./components/navbar/UserMenu";
import { CartItems } from "./components/cart/CartItems";

export default function Home() {
  return (
    <div className="grid grid-cols-1">
      <Header />
      <Menu />
      <NavBar />
      <div className="flex flex-col items-center">
        <Categories />
        <BrandGallery />
      </div>
    </div>
  );
}
